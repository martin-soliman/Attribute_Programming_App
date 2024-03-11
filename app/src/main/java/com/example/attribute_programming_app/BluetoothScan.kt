package com.example.attribute_programming_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

@Composable
fun BluetoothScanPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.bluetooth_scan),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 100.dp,
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 5.dp
                )
        )

        Spacer(modifier = Modifier.height(40.dp))

        val image = painterResource(R.drawable.bluetooth_icon)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 50.dp)
                .scale(0.5F)
        )

        Spacer(modifier = Modifier.height(100.dp))

        LinearProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .padding(top = 50.dp)
                .scale(3F),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
        Spacer(modifier = Modifier.height(100.dp))

        AppButton(
            { navController.navigate(Screen.BluetoothFailedScreen.route) },
            stringResource(R.string.next)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BluetoothScanPreview() {
    Attribute_Programming_AppTheme {
        BluetoothScanPage(navController = rememberNavController())
    }
}