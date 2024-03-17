package com.fiap.zerodengue.views.cidadao.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInTab(){
    Box(
        modifier = Modifier.height(200.dp).width(200.dp).background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Entrar", color = Color.White, fontSize = 24.sp)
    }
}