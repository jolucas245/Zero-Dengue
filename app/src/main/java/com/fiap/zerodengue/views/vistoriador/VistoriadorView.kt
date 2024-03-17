package com.fiap.zerodengue.views.cidadao

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fiap.zerodengue.R
import com.fiap.zerodengue.ui.components.CustomTopBar
import com.fiap.zerodengue.ui.components.TabsLogin
import com.fiap.zerodengue.views.vistoriador.VistoriadorViewModel
import com.fiap.zerodengue.views.vistoriador.tabs.SignInTabVistoriador
import com.fiap.zerodengue.views.vistoriador.tabs.SignUpTabVistoriador

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VistoriadorView(vistoriadorViewModel: VistoriadorViewModel){

    val tabIndex by vistoriadorViewModel.tabIndex.observeAsState(initial = 0)

    Scaffold(
        topBar = CustomTopBar(
            title = "Vistoriador",
            navigationIcon = R.drawable.arrow_back_ios_24,
            contentDescription = "Volta",
            colorAppBar = R.color.vistoriador
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
                            vistoriadorViewModel.onTabIndexChanged(it)
                        },
                        tabs = vistoriadorViewModel.tabs,
                        color = R.color.vistoriador
                    )
                    when (tabIndex){
                        0 -> SignInTabVistoriador()
                        1 -> SignUpTabVistoriador()
                    }
                }
            }
        }
    )
}