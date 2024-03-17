    package com.fiap.zerodengue.ui.components

    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.Text
    import androidx.compose.material3.TopAppBar
    import androidx.compose.material3.TopAppBarDefaults
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.colorResource
    import androidx.compose.ui.res.painterResource

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomTopBar(
        title: String? = null,
        navigationIcon: Int? = null,
        onClickIcon: () -> Unit = {},
        contentDescription: String,
        colorAppBar: Int
    ): @Composable () -> Unit {
        return {
            TopAppBar(
                title = {
                    if(title != null) Text(title, color = Color.White)
                },
                navigationIcon = {
                    if(navigationIcon != null) {
                        IconButton(
                            onClick = onClickIcon
                        ) {
                            Icon(
                                painter = painterResource(id = navigationIcon),
                                contentDescription = contentDescription,
                                tint = Color.White
                            )
                        }
                    }
                },
                actions = {
                    IconButton(
                        onClick = {onClickIcon}
                    ) {

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(colorAppBar)
                )
            )
        }
    }
