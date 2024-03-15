package com.example.attribute_programming_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.attribute_programming_app.R

@Composable
fun AppButton(
    action: () -> Unit, //action lambda used to define onClick for Button
    head: String,
    modifier: Modifier = Modifier,
    color: Color = Color(R.color.dark_orange)
) {
    Button(
        onClick = action,
        colors = ButtonDefaults.buttonColors(Color(0xFFFFA500)),
        modifier = modifier
    ) {
        Text(text = head)
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
fun AppTextField(
    head: String,
    fieldType: Int
) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dropdownMenu(
    dropdownName: String,
    items: List<String>
): String {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var selectedItem by remember {
        mutableStateOf(dropdownName)
    }

    Box() {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            TextField(
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                    },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        onClick = {
                            selectedItem = item
                            isExpanded = false
                        },
                        text = {
                            Text(text = item)
                        }
                    )

                }

            }

        }
    }

    return selectedItem
}


@Composable
fun ImageBackgroundPage(imageID: Int) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        val image = painterResource(imageID)
        Image(
            painter = image,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )
    }
}




