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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

val orange = 0xFFFFA500
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
                )
    )
}



