package com.fiap.zerodengue.data

data class DengueLocation(
    val address: String,
    val refPoint: String,
    val description: String,
    var imageUrl: String = ""
)
