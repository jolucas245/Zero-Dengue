package com.fiap.zerodengue.view.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fiap.zerodengue.R
import com.fiap.zerodengue.ui.components.CustomTopBar

@Composable
fun MainView(navController: NavController, type: String){
    Scaffold(
        topBar = CustomTopBar(
            contentDescription = "Sair",
            colorAppBar = if(type == "cidadao") R.color.cidadao else R.color.vistoriador,
            actionIcon = R.drawable.exit_to_app_24,
            onClickActionIcon = {
                navController.navigateUp()
            }
        ),
        floatingActionButton = {
            if(type == "cidadao"){
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = colorResource(id = R.color.cidadao),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_24),
                        contentDescription = "Novo Foco",
                        tint = Color.White
                    )
                }
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ){
                Column {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(32.dp),
                        elevation = CardDefaults.cardElevation(5.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            ){
                                AsyncImage(
                                    model = "https://s2-g1.glbimg.com/yXcz5LDjIBgKK7HTVieYcb89kfo=/0x0:950x600/984x0/smart/filters:strip_icc()/s.glbimg.com/jo/g1/f/original/2013/02/08/piscina-edilson-950.jpg",
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds
                                    
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}