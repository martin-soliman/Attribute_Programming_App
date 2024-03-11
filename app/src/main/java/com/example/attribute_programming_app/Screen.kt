package com.example.attribute_programming_app

sealed class Screen(val route: String) {
    object StartupScreen: Screen("startup_screen")
    object AuthenticationScreen: Screen("authentication_screen")
    object AuthenticationFailedScreen: Screen("authentication_failed_screen")
    object BluetoothScreen: Screen("bluetooth_screen")
    object BluetoothFailedScreen: Screen("bluetooth_failed_screen")
    object QueryScreen: Screen("query_screen")
    object QAScreen: Screen("qa_screen")
    object QASignOffScreen: Screen("qa_signoff_screen")
    object NFCScreen: Screen("nfc_screen")
    object ProgrammingScreen: Screen("programming_screen")
    object FinalInspectionScreen: Screen("final_inspection_screen")
    object FinalInspectionSignOffScreen: Screen("final_inspection_signoff_screen")
}