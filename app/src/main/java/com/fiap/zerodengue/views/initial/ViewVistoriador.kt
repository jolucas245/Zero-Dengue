package com.fiap.zerodengue.views.initial

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fiap.zerodengue.R


@SuppressLint("PrivateResource")
@Composable
fun ViewVistoriador() {

    //
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
    //
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Blue)
        ){
           Row(
               //verticalAlignment = Alignment.CenterVertically
           ) {
               Text(text = "Zero-Dengue",
                   fontWeight = FontWeight.Bold,
                   textAlign = TextAlign.Center)
           }
           Row {
               Button(onClick = {}) {
                   Image(painter = painterResource(id = R.drawable.logout_24),
                       contentDescription = "Botão de logout")
               }
           }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 20.dp)
                .offset(x = 0.dp, y = 70.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                elevation = CardDefaults 
                    .cardElevation(1.dp),
                border = BorderStroke(
                    width = 2.dp,
                    Color.DarkGray
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                //Image(painter = , contentDescription ="" )
                Text(text = "IMAGEM 1")
            }
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                elevation = CardDefaults
                    .cardElevation(1.dp),
                border = BorderStroke(width = 2.dp, Color.DarkGray)
            ) {
                //Image(painter = , contentDescription ="" )
                Text(text = "IMAGEM 2")

            }
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                elevation = CardDefaults
                    .cardElevation(1.dp),
                border = BorderStroke(width = 2.dp, Color.DarkGray)
            ) {
                //Image(painter = , contentDescription ="" )
                Text(text = "IMAGEM 3")
            }
        }
    }
}