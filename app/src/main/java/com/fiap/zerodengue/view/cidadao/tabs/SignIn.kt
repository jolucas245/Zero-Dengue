package com.fiap.zerodengue.view.cidadao.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiap.zerodengue.R
import com.fiap.zerodengue.ui.components.GradientButton

@Composable
fun SignInTabCidadao(navController: NavController){

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(42.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.signin_c),
            contentDescription = "",
            modifier = Modifier.height(200.dp)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.cidadao),
                focusedLabelColor = colorResource(id = R.color.cidadao)
            ),
            maxLines = 1,
            singleLine = true,
            label = {
                Text(text = "E-mail")
            },
            value = email,
            onValueChange = {
                email = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.cidadao),
                focusedLabelColor = colorResource(id = R.color.cidadao)

            ),
            maxLines = 1,
            singleLine = true,
            label = {
                Text(text = "Senha")
            },
            value = password,
            onValueChange = {
                password = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        GradientButton(
            gradient = Brush.horizontalGradient(listOf(Color(0xFFF58327), Color(0xFFED165A))),
            elevation = ButtonDefaults.buttonElevation(4.dp),
            onClick = {
                navController.navigate("main/cidadao"){
                    popUpTo("initial"){inclusive = true}
                }
            },
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Entrar",
                fontSize = 24.sp,
            )
        }

    }
}