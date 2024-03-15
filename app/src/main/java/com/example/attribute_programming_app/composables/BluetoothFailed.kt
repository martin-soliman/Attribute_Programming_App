package com.example.attribute_programming_app.composables

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
import com.example.attribute_programming_app.R
import com.example.attribute_programming_app.navigation.Screen
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

@Composable
fun BluetoothFailedPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.bluetooth_fail),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 50.dp,
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 5.dp
                )
        )

        ErrorImage()

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(
            { navController.navigate(Screen.BluetoothScreen.route) },
            stringResource(R.string.try_again)
        )

        Spacer(modifier = Modifier.height(125.dp))

        AppButton(
            { navController.navigate(Screen.QueryScreen.route) },
            stringResource(R.string.next)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BluetoothFailedPreview() {
    Attribute_Programming_AppTheme {
        BluetoothFailedPage(navController = rememberNavController())
    }
}