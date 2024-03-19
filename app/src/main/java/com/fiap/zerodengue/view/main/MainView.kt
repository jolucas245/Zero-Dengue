    package com.fiap.zerodengue.view.main

    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.CircularProgressIndicator
    import androidx.compose.material3.FloatingActionButton
    import androidx.compose.material3.Icon
    import androidx.compose.material3.Scaffold
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.colorResource
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.unit.dp
    import androidx.navigation.NavController
    import coil.compose.SubcomposeAsyncImage
    import com.fiap.zerodengue.R
    import com.fiap.zerodengue.data.DengueRepository
    import com.fiap.zerodengue.ui.components.CustomTopBar

    @Composable
    fun MainView(navController: NavController, type: String){

        var urls by remember { mutableStateOf(emptyList<String>()) }

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
                        onClick = {
                            navController.navigate("reference")
                        },
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
                    LaunchedEffect(key1 = Unit) {
                        val dengueRepository = DengueRepository()
                        dengueRepository.getImages(
                            onSuccess = { newUrls ->
                                urls = newUrls
                            },
                            onFailure = {
                                println(it)
                            }
                        )
                    }
                    if(urls.isNotEmpty()) {
                        LazyColumn {
                            items(count = urls.size) { index ->
                                val url = urls[index]
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(250.dp)
                                        .padding(horizontal = 32.dp, vertical = 10.dp),
                                    elevation = CardDefaults.cardElevation(5.dp)
                                ) {
                                    SubcomposeAsyncImage(
                                        model = url,
                                        loading = {
                                            CircularProgressIndicator()
                                        },
                                        contentDescription = "Imagem ${url[index]}",
                                        contentScale = ContentScale.FillBounds,
                                        modifier = Modifier.fillMaxSize(),

                                    )
                                }
                            }
                        }
                    }
                }
            }
        )
    }