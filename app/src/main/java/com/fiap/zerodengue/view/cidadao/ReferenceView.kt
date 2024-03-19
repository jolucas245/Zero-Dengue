package com.fiap.zerodengue.view.cidadao

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fiap.zerodengue.R

@Composable
fun ReferenceView(
    navController: NavController,
    referenceViewModel: ReferenceViewModel
){

    val address by referenceViewModel.address.observeAsState("")
    val refPoint by referenceViewModel.refPoint.observeAsState("")
    val description by referenceViewModel.description.observeAsState("")
    val selectedImageUri by referenceViewModel.selectedImageUri
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            referenceViewModel.setSelectedImageUri(uri)
        }
    )

    LazyColumn(
        modifier = Modifier.padding(24.dp)
    ) {
        item {

            Box(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            singlePhotoPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        },
                ) {
                    if(selectedImageUri == null) {
                        Text(
                            text = "Clique para adicionar uma imagem",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxHeight()
                                .align(
                                    alignment = Alignment.CenterHorizontally
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically)
                        )
                    }
                    Box {
                        AsyncImage(
                            model = selectedImageUri,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .background(colorResource(id = R.color.cidadao), shape = CircleShape)
                                .size(42.dp)
                                .clickable { referenceViewModel.setSelectedImageUri(null)}
                            ,
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "X",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                            )
                        }
                    }
                }
            }
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
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
                    Text(text = "Endereço")
                },
                value = address,
                onValueChange = {
                    referenceViewModel.onAddressChanged(it)
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
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
                    Text(text = "Ponto de referência")
                },
                value = refPoint,
                onValueChange = {
                    referenceViewModel.onRefPointChanged(it)
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Default
                ),
                shape = RoundedCornerShape(32.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.cidadao),
                    focusedLabelColor = colorResource(id = R.color.cidadao)

                ),
                label = {
                    Text(text = "Descrição")
                },
                value = description,
                onValueChange = {
                    referenceViewModel.onDescriptionChanged(it)
                }
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                OutlinedButton(
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = colorResource(id = R.color.cidadao),
                    ),
                    border = BorderStroke(1.dp, color = colorResource(id = R.color.cidadao)),
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text(text = "Cancelar")
                }
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.cidadao)
                    )
                ) {
                    Text(text = "Enviar")
                }
            }
        }
    }
}