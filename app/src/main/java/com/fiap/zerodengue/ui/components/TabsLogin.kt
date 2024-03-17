package com.fiap.zerodengue.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.fiap.zerodengue.R

@Composable
fun TabsLogin(
    tabIndex: Int,
    onSelectedTab: (Int) -> Unit,
    tabs: List<String>
){
    TabRow(
        contentColor = colorResource(id = R.color.cidadao),
        containerColor = colorResource(id = R.color.cidadao),
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[tabIndex])
                    .height(4.dp)
                    .offset(y = -(4).dp)
                    .clip(RoundedCornerShape(8.dp)) // clip modifier not working
                    .padding(horizontal = 50.dp)
                    .background(color = Color.White)
            )
        },
        selectedTabIndex = tabIndex
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(text = title, color = Color.White)
                },
                selected = tabIndex == index,
                onClick = {
                    onSelectedTab(index)
                    println("Você está na $tabIndex")
                }
            )
        }
    }
}