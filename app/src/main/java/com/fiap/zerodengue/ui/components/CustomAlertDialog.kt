package com.fiap.zerodengue.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.zerodengue.data.DengueLocation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAlertDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    locations: List<DengueLocation>
) {
    if (openDialog) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = {
                Text(
                    text = "Detalhes do Local",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            text = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                ) {
                    items(count = locations.size) { location ->
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Endereço: ${locations[location].address}",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "Referência: ${locations[location].refPoint}",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "Descrição: ${locations[location].description}",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            },
            confirmButton = {}
        )
    }
}