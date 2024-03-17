package com.fiap.zerodengue.views.cidadao

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fiap.zerodengue.R
import com.fiap.zerodengue.ui.components.CustomTopBar
import com.fiap.zerodengue.ui.components.TabsLogin
import com.fiap.zerodengue.views.cidadao.tabs.SignInTabCidadao
import com.fiap.zerodengue.views.cidadao.tabs.SignUpTabCidadao

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CidadaoView(){

    var tabIndex by remember {
        mutableStateOf(0)
    }

    val tabs = listOf("Entrar", "Cadastrar")

    Scaffold(
        topBar = CustomTopBar(
            title = "Cidadão",
            navigationIcon = R.drawable.arrow_back_ios_24,
            contentDescription = "Volta"
        ),
        content = {
            paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TabsLogin(
                        tabIndex = tabIndex,
                        onSelectedTab = {
                            tabIndex = it
                        },
                        tabs = tabs
                    )
                    when (tabIndex){
                        0 -> SignInTabCidadao()
                        1 -> SignUpTabCidadao()
                    }
                }
            }
        }
    )
}