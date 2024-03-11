package com.example.attribute_programming_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

@Composable
fun StartupPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        val image = painterResource(R.drawable.wrmth_logo_01)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(
                    top = 50.dp,
                    start = 25.dp,
                    end = 25.dp,
                )
                .weight(0.6F)
        )

        Text(
            text = stringResource(R.string.startup_head),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 40.dp,
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 5.dp
                )
                .weight(0.75F, fill = false)
        )

        Text(
            text = stringResource(R.string.startup_prompt),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 20.dp,
                    start = 55.dp,
                    end = 55.dp,
                    bottom = 20.dp
                )
                .weight(0.75F, fill = false)
        )

        Credentials(modifier = Modifier
            .weight(1.5F)
            .padding(top = 100.dp))

        AppButton(
            { navController.navigate(Screen.AuthenticationScreen.route) },
            stringResource(R.string.next)
        )
    }
}

@Composable
fun Credentials(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        AppTextField(head = "Email", fieldType = 0)
        AppTextField(head = "Serial #", fieldType = 1)
    }
}

@Preview(showBackground = true)
@Composable
fun StartupPreview() {
    Attribute_Programming_AppTheme {
        StartupPage(navController = rememberNavController())
    }
}