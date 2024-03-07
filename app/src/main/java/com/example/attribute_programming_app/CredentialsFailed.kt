package com.example.attribute_programming_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

@Composable
fun CredentialsFailedPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.credentials_failed),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 50.dp,
                    start = 25.dp,
                    end = 25.dp,
                )
        )

        ErrorImage()

        Spacer(modifier = Modifier.height(20.dp))

        TryAgainButton(navController = navController, route = Screen.AuthenticationScreen.route)

        Spacer(modifier = Modifier.height(125.dp))

        NextButton(navController = navController, route = Screen.BluetoothScreen.route)
    }
}

@Preview(showBackground = true)
@Composable
fun CredentialsFailedPreview() {
    Attribute_Programming_AppTheme {
        CredentialsFailedPage(navController = rememberNavController())
    }
}