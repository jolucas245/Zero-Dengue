package com.fiap.zerodengue.view.cidadao

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
import androidx.navigation.NavController
import com.fiap.zerodengue.R
import com.fiap.zerodengue.ui.components.CustomTopBar
import com.fiap.zerodengue.ui.components.TabsLogin
import com.fiap.zerodengue.view.cidadao.tabs.SignInTabCidadao
import com.fiap.zerodengue.view.cidadao.tabs.SignUpTabCidadao

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CidadaoView(
    cidadaoViewModel: CidadaoViewModel,
    navController: NavController
){

    val tabIndex by cidadaoViewModel.tabIndex.observeAsState(initial = 0)

    Scaffold(
        topBar = CustomTopBar(
            title = "Cidadão",
            navigationIcon = R.drawable.arrow_back_ios_24,
            contentDescription = "Volta",
            colorAppBar = R.color.cidadao,
            onClickIcon = {
                navController.popBackStack()
            }
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
                            cidadaoViewModel.onTabIndexChanged(it)
                        },
                        tabs = cidadaoViewModel.tabs,
                        color = R.color.cidadao
                    )
                    when (tabIndex){
                        0 -> SignInTabCidadao(navController)
                        1 -> SignUpTabCidadao(navController)
                    }
                }
            }
        }
    )
}