package com.example.attribute_programming_app

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun SerialNumPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        WrmthHeader(prompt = stringResource(R.string.serial_num_prompt))
        AppTextField(head = "Serial #", fieldType = 1)

        NextButton(
            navController = navController,
            route = Screen.AuthenticationScreen.route,
            modifier = Modifier
                .padding(top = 100.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Preview(showBackground = true)
@Composable
fun SerialNumPreview() {
    Attribute_Programming_AppTheme {
        SerialNumPage(navController = rememberNavController())
    }
}