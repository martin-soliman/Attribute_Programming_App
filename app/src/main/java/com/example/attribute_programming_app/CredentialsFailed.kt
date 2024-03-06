package com.example.attribute_programming_app.com.example.attribute_programming_app

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
import com.example.attribute_programming_app.R
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

@Composable
fun CredentialsFailedPage(modifier: Modifier = Modifier) {
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
                    top = 150.dp,
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 5.dp
                )
                .weight(0.75F, fill = false)
        )
        
        val image = painterResource(id = R.drawable.incorrect)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(top = 50.dp)
            )

        //try again button here!
        Text(
            text ="Try again",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    top = 200.dp,
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 5.dp
                )
                .weight(0.75F, fill = false)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CredentialsFailedPreview() {
    Attribute_Programming_AppTheme {
        CredentialsFailedPage()
    }
}