package com.example.attribute_programming_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Attribute_Programming_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartupPage()
                }
            }
        }
    }
}

@Composable
fun StartupPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
        ) {
        Column(modifier = Modifier
            .padding(
                top = 50.dp,
                start = 25.dp,
                end = 25.dp,)
            .weight(0.6F)) {
            val image = painterResource(R.drawable.wrmth_logo_01)
            Image(
                painter = image,
                contentDescription = null,
            )
        }

        Column(modifier = Modifier
            .padding(
                top = 40.dp,
                start = 25.dp,
                end = 25.dp,
                bottom = 5.dp)
            .weight(0.75F, fill = false)
        ) {
            Text(
                text = stringResource(R.string.startup_head),
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
            )
        }

        Column(modifier = Modifier
            .padding(
                top = 20.dp,
                start = 55.dp,
                end = 55.dp,
                bottom = 20.dp
            )
            .weight(0.75F, fill = false)
        ) {
            Text(
                text = stringResource(R.string.startup_prompt),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }

        Credentials(modifier = Modifier
            .weight(1.5F)
            .padding(top = 100.dp))
    }
}

@Composable
fun Credentials(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.email_prompt),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 25.dp)
        )
        //where user input box will go
        Text(
            text = "Textbox",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            )

        Text(
            text = stringResource(R.string.serial_prompt),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = 25.dp,
                bottom = 25.dp
            )
        )

        //where user input box will go
        Text(
            text = "Textbox",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Attribute_Programming_AppTheme {
        StartupPage()
    }
}