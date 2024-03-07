package com.example.attribute_programming_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
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
fun CredentialsAuthenticationPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.credentials_authentication),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 5.dp)
                .weight(0.75F, fill = false)
        )

        Spacer(modifier = Modifier.height(100.dp))

        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .padding(
                    top = 50.dp,
                    bottom = 250.dp
                ),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )

        NextButton(navController = navController, route = Screen.AuthenticationFailedScreen.route)
    }
}

@Preview(showBackground = true)
@Composable
fun CredentialsAuthenticationPreview() {
    Attribute_Programming_AppTheme {
       CredentialsAuthenticationPage(navController = rememberNavController())
    }
}