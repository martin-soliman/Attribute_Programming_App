package com.example.attribute_programming_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

val orange = 0xFFFFA500

@Composable
fun WrmthHeader(prompt: String) {
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
    )

    Text(
        text = prompt,
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
    )
}
@Composable
fun NextButton(modifier: Modifier = Modifier, navController: NavController, route: String) {
    Button(
        onClick = {navController.navigate(route) },
        colors = ButtonDefaults.buttonColors(Color(orange)),
        modifier = modifier.padding(
            start = 175.dp,
            top = 25.dp)
    ) {
        Text("Thank you, next")
    }
}

@Composable
fun TryAgainButton(modifier: Modifier = Modifier, navController: NavController, route: String) {
    Button(
        onClick = { navController.navigate(route) },
        colors = ButtonDefaults.buttonColors(Color(orange)),
        modifier = modifier
            .scale(2F)
            .padding(top = 25.dp)
    ) {
        Text(stringResource(R.string.try_again))
    }
}

@Composable
fun ErrorImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.incorrect_icon)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .scale(0.5F)
    )
}

@Composable
fun AppTextField(head: String, fieldType: Int) {
    var filledText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = filledText,
        onValueChange = { filledText = it },
        label = {
            Text(text = head)
        },
        leadingIcon = {
            Icon(
                imageVector = if(fieldType == 0) Icons.Outlined.Email else Icons.Outlined.Search,
                contentDescription = null,
            )
        },
        keyboardOptions = KeyboardOptions(
                keyboardType = if(fieldType == 0) KeyboardType.Email else KeyboardType.Number
                ),
        supportingText = {
            Text(text = if (fieldType == 0) "" else "*The serial number is on the chair's PCB")
        }

    )
}



