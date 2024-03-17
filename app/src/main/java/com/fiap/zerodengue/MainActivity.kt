package com.fiap.zerodengue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.fiap.zerodengue.ui.theme.ZeroDengueTheme
import com.fiap.zerodengue.views.main.MainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZeroDengueTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "initial"){
//                        composable("initial"){
//                            InitialView(navController = navController)
//                        }
//                        composable("cidadao"){
//                            CidadaoView(
//                                cidadaoViewModel = CidadaoViewModel(),
//                                navController = navController
//                            )
//                        }
//                        composable("vistoriador"){
//                            VistoriadorView(
//                                vistoriadorViewModel = VistoriadorViewModel(),
//                                navController = navController
//                            )
//                        }
//                    }
                    MainView()
                }
            }
        }
    }
}
