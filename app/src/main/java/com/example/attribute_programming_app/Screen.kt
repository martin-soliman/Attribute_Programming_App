package com.example.attribute_programming_app

sealed class Screen(val route: String) {
    object StartupScreen: Screen("startup_screen")
    object AuthenticationScreen: Screen("authentication_screen")
    object AuthenticationFailedScreen: Screen("authentication_failed_screen")
    object BluetoothScreen: Screen("bluetooth_screen")
    object BluetoothFailedScreen: Screen("bluetooth_failed_screen")
    object QueryScreen: Screen("query_screen")
}