package com.example.attribute_programming_app
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.StartupScreen.route) {
        composable(route = Screen.StartupScreen.route) {
            StartupPage(navController = navController)
        }
        composable(route = Screen.AuthenticationScreen.route) {
            CredentialsAuthenticationPage(navController = navController)
        }
        composable(route = Screen.AuthenticationFailedScreen.route) {
            CredentialsFailedPage(navController = navController)
        }
        composable(route = Screen.BluetoothScreen.route) {
            BluetoothScanPage(navController = navController)
        }
        composable(route = Screen.BluetoothFailedScreen.route) {
            BluetoothFailedPage(navController = navController)
        }
        composable(route = Screen.QueryScreen.route) {
            QueryPage(navController = navController)
        }
        composable(route = Screen.QAScreen.route) {
            QueryPage(navController = navController)
        }
        composable(route = Screen.QASignOffScreen.route) {
            QueryPage(navController = navController)
        }
        composable(route = Screen.NFCScreen.route) {
            NFCPage(navController = navController)
        }
        composable(route = Screen.ProgrammingScreen.route) {
            ProgrammingPage(navController = navController)
        }
        composable(route = Screen.FinalInspectionScreen.route) {
            QueryPage(navController = navController)
        }
        composable(route = Screen.FinalInspectionSignOffScreen.route) {
            QueryPage(navController = navController)
        }
    }
}
