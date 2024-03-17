package com.fiap.zerodengue.views.initial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.fiap.zerodengue.R
import com.fiap.zerodengue.ui.components.GradientButton

@Composable
fun InitialView(){

    Box(
        contentAlignment = Alignment.Center,
    ) {
       Column(
           modifier = Modifier
               .padding(vertical = 50.dp, horizontal = 72.dp),
       ) {
           Icon(
               painter = painterResource(id = R.drawable.fly_icon),
               contentDescription = "Fly",
               modifier = Modifier
                   .align(Alignment.CenterHorizontally)
                   .padding(bottom = 30.dp)
           )
           Text(
               text = "Entrar como:",
               fontSize = 24.sp,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Center,
               modifier = Modifier
                   .padding(bottom = 15.dp)
                   .fillMaxWidth()
           )
           GradientButton(
               gradient = Brush.horizontalGradient(listOf(Color(0xFFF58327), Color(0xFFED165A))),
               elevation = ButtonDefaults.buttonElevation(4.dp),
               onClick = {

               },
               modifier = Modifier
                   .padding(bottom = 30.dp)
                   .fillMaxWidth()
           ) {
               Text(
                   text = "Cidadão",
                   fontSize = 24.sp,
               )
           }
           GradientButton(
               gradient = Brush.horizontalGradient(listOf(Color(0xFF04A8F3), Color(0xFF5C6BC0))),
               elevation = ButtonDefaults.buttonElevation(4.dp),
               onClick = {},
               modifier = Modifier
                   .padding(vertical = 8.dp)
                   .fillMaxWidth()
           ) {
               Text(text = "Vistoriador", fontSize = 24.sp)
           }
       }
    }
}