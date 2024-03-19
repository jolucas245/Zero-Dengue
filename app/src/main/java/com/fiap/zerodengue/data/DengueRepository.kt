package com.fiap.zerodengue.data

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.time.LocalTime
import java.util.UUID

class DengueRepository {
    val db = Firebase.firestore
    val user = Firebase.auth.currentUser


    @RequiresApi(Build.VERSION_CODES.O)
    fun saveDengueLocation(location: DengueLocation, imageUri: Uri, callback: (Boolean) -> Unit, ){
        callback(true)
        uploadImage(imageUri){ imageUri ->
            if(imageUri != null){
                location.imageUrl = imageUri
                user?.uid?.let { userId ->
                    db.collection("locations")
                        .document(userId + LocalTime.now())
                        .set(location)
                        .addOnSuccessListener {
                            callback(false)
                        }
                        .addOnFailureListener{
                            callback(false)
                        }
                }
            } else {
                callback(false)
            }
        }
    }

    fun uploadImage(imageUri: Uri, callback: (String) -> Unit){
        val storageRef =  Firebase.storage.reference.child("images/${UUID.randomUUID()}")
        storageRef.putFile(imageUri)
            .addOnSuccessListener { taskSnapshot ->
                storageRef.downloadUrl.addOnSuccessListener { uri -> callback(uri.toString()) }
            }
            .addOnFailureListener{
                callback(null.toString())
            }
    }

    fun getImages(onSuccess: (List<String>) -> Unit, onFailure: (Exception) -> Unit) {
        val db = Firebase.firestore
        db.collection("locations")
            .get()
            .addOnSuccessListener { documents ->
                val urls = documents.mapNotNull { it.getString("imageUrl") }
                onSuccess(urls)
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }

}