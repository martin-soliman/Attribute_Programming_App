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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.attribute_programming_app.ui.theme.Attribute_Programming_AppTheme

@Composable
fun QueryPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.query_status) + "\n" /* + statusVar */,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 100.dp,
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 25.dp
                )
                .weight(0.75F, fill = false)


        )

        Text(
            text = stringResource(R.string.query_prompt),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(150.dp))

        //button options here
        val orange = 0xFFFFA500
        Button(
            onClick = { navController.navigate(Screen.QAScreen.route) },
            Modifier.scale(2F),
            colors = ButtonDefaults.buttonColors(Color(orange))
        ) {
            Text(stringResource(R.string.qa_review))
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { navController.navigate(Screen.NFCScreen.route) },
            Modifier.scale(2F),
            colors = ButtonDefaults.buttonColors(Color(orange))
        ) {
            Text(stringResource(R.string.program_chair))
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { navController.navigate(Screen.FinalInspectionScreen.route) },
            Modifier.scale(2F),
            colors = ButtonDefaults.buttonColors(Color(orange))
        ) {
            Text(stringResource(R.string.final_inspection))
        }
        Spacer(modifier = Modifier.height(100.dp))

        AppButton(
            { navController.navigate(Screen.StartupScreen.route) },
            stringResource(R.string.next)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QueryPreview() {
    Attribute_Programming_AppTheme {
        QueryPage(navController = rememberNavController())
    }
}