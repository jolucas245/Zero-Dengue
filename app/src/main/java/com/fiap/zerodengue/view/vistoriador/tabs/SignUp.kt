package com.fiap.zerodengue.view.vistoriador.tabs

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
import androidx.compose.runtime.livedata.observeAsState
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
import com.fiap.zerodengue.view.vistoriador.VistoriadorViewModel

@Composable
fun SignUpTabVistoriador(navController: NavController, vistoriadorViewModel: VistoriadorViewModel){
    val name by vistoriadorViewModel.name.observeAsState("")
    val email by vistoriadorViewModel.email.observeAsState("")
    val password by vistoriadorViewModel.password.observeAsState("")

    Column(
        modifier = Modifier.fillMaxWidth().padding(42.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.signup_v),
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
                focusedBorderColor = colorResource(id = R.color.vistoriador),
                focusedLabelColor = colorResource(id = R.color.vistoriador)
            ),
            maxLines = 1,
            singleLine = true,
            label = {
                Text(text = "Nome")
            },
            value = name,
            onValueChange = {
                vistoriadorViewModel.onNameChanged(it)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.vistoriador),
                focusedLabelColor = colorResource(id = R.color.vistoriador)
            ),
            maxLines = 1,
            singleLine = true,
            label = {
                Text(text = "E-mail")
            },
            value = email,
            onValueChange = {
                vistoriadorViewModel.onEmailChanged(it)
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
                focusedBorderColor = colorResource(id = R.color.vistoriador),
                focusedLabelColor = colorResource(id = R.color.vistoriador)

            ),
            maxLines = 1,
            singleLine = true,
            label = {
                Text(text = "Senha")
            },
            value = password,
            onValueChange = {
                vistoriadorViewModel.onPasswordChanged(it)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        GradientButton(
            gradient = Brush.horizontalGradient(listOf(Color(0xFF04A8F3), Color(0xFF5C6BC0))),
            elevation = ButtonDefaults.buttonElevation(4.dp),
            onClick = {
                vistoriadorViewModel.register(
                    email,
                    password,
                    name,
                    onSuccess = {
                        navController.navigate("main/vistoriador"){
                            popUpTo("initial"){inclusive = true}
                        }
                    },
                    onFailed = {
                        print("Deu não mano")
                    }
                )
            },
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Cadastrar",
                fontSize = 24.sp,
            )
        }

    }
}