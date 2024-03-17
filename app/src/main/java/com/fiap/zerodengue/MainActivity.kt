package com.fiap.zerodengue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fiap.zerodengue.ui.theme.ZeroDengueTheme
import com.fiap.zerodengue.views.cidadao.CidadaoView
import com.fiap.zerodengue.views.cidadao.CidadaoViewModel
import com.fiap.zerodengue.views.cidadao.VistoriadorView
import com.fiap.zerodengue.views.initial.InitialView
import com.fiap.zerodengue.views.vistoriador.VistoriadorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZeroDengueTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "initial"){
                        composable("initial"){
                            InitialView(navController = navController)
                        }
                        composable("cidadao"){
                            CidadaoView(
                                cidadaoViewModel = CidadaoViewModel(),
                                navController = navController
                            )
                        }
                        composable("vistoriador"){
                            VistoriadorView(
                                vistoriadorViewModel = VistoriadorViewModel(),
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}
