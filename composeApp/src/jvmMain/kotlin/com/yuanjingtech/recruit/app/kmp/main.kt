package com.yuanjingtech.recruit.app.kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Recruitappkmp",
    ) {
        App()
    }
}