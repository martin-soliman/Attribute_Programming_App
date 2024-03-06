package com.example.attribute_programming_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

@Composable
fun QueryPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.query_head),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 150.dp,
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 25.dp
                )
                .weight(0.75F, fill = false)
        )

        Spacer(modifier = Modifier.height(100.dp))

        //button options here
        val orange = 0xFFFFA500
        Button(
            onClick = { /*TODO*/ }, Modifier.scale(2F),
            colors = ButtonDefaults.buttonColors(Color(orange))
        ) {
            Text(stringResource(R.string.qa_review))
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { /*TODO*/ }, Modifier.scale(2F),
            colors = ButtonDefaults.buttonColors(Color(orange))
        ) {
            Text(stringResource(R.string.program_chair))
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { /*TODO*/ }, Modifier.scale(2F),
            colors = ButtonDefaults.buttonColors(Color(orange))
        ) {
            Text(stringResource(R.string.final_inspection))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QueryPreview() {
    Attribute_Programming_AppTheme {
        QueryPage()
    }
}