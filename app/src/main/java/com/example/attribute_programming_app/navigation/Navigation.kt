package com.example.attribute_programming_app.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.attribute_programming_app.composables.BluetoothFailedPage
import com.example.attribute_programming_app.composables.BluetoothScanPage
import com.example.attribute_programming_app.composables.CredentialsAuthenticationPage
import com.example.attribute_programming_app.composables.CredentialsFailedPage
import com.example.attribute_programming_app.composables.NFCPage
import com.example.attribute_programming_app.composables.ProgrammingPage
import com.example.attribute_programming_app.composables.QueryPage
import com.example.attribute_programming_app.composables.StartupPage

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
