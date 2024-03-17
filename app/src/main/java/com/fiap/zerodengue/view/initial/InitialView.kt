package com.fiap.zerodengue.view.initial

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiap.zerodengue.R
import com.fiap.zerodengue.ui.components.GradientButton

@Composable
fun InitialView(navController: NavController){

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
                   navController.navigate("cidadao")
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
               onClick = {
                   navController.navigate("vistoriador")
               },
               modifier = Modifier
                   .padding(vertical = 8.dp)
                   .fillMaxWidth()
           ) {
               Text(text = "Vistoriador", fontSize = 24.sp)
           }
       }
    }
}