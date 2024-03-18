package com.fiap.zerodengue.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun login(email: String, password: String): Result<String> = withContext(Dispatchers.IO){
        return@withContext try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()

            val user = firebaseAuth.currentUser
            if(user != null){
                val userType = getUserType(user.uid)
                Result.success(userType)
            } else{
                Result.failure(Exception("Usuário não encontrado"))
            }

        } catch (e: FirebaseAuthException){
            Result.failure(Exception(e.errorCode))
        }
    }

    private suspend fun getUserType(uuid: String): String{
        val document = firestore.collection("users").document(uuid).get().await()
        return document.getString("userType") ?: ""
    }

    suspend fun register(email: String, password: String, name: String, userType: String): Result<Boolean> = withContext(Dispatchers.IO){
        return@withContext try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()

            if(authResult.user != null){
                val user = hashMapOf(
                    "name" to name,
                    "email" to email,
                    "userType" to userType
                )
                firestore.collection("users").document(authResult.user!!.uid)
                    .set(user)
                    .await()
            }

            Result.success(true)
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}