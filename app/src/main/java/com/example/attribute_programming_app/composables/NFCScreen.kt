package com.example.attribute_programming_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attribute_programming_app.R
import com.example.attribute_programming_app.navigation.Screen
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme


@Composable
fun NFCPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        val wmrthImage = painterResource(R.drawable.wrmth_logo_01)
        Image(
            painter = wmrthImage,
            contentDescription = null,
            modifier = Modifier.scale(0.5F)
        )

        Spacer(modifier = Modifier.height(50.dp))

        val nfcImage = painterResource(R.drawable.nfc)
        Image(
            painter = nfcImage,
            contentDescription = null,
            modifier = Modifier.scale(1.5F)
        )

        Spacer(modifier = Modifier.height(150.dp))

        AppButton(
            { navController.navigate(Screen.ProgrammingScreen.route) },
            stringResource(R.string.next)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NFCPreview() {
    Attribute_Programming_AppTheme {
        NFCPage(navController = rememberNavController())
    }
}