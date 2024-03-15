package com.example.attribute_programming_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
fun ProgrammingPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .scale(0.95F)
    ) {
        val wrmthImage = painterResource(id = R.drawable.wrmth_logo_01)

        Image(
            painter = wrmthImage,
            contentDescription = null,
            modifier = Modifier.scale(0.5F)
        )

        //setting chair image to var to display correct colors once fields are filled
        var corianColor by remember { mutableStateOf("") }
        var frameColor by remember { mutableStateOf("") }

        val chairImage = getChairImage(
            corianColor,
            frameColor
        )

        Image(
            painter = chairImage,
            contentDescription = null,
        )

        Column(modifier = Modifier) {
            AppTextField(
                head = "Serial Number",
                fieldType = 1
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            dropdownMenu(
                dropdownName = "Product Type",
                items = listOf(
                    "Muskoka",
                    "Test 1",
                    "Test 2"
                )
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            corianColor = dropdownMenu(
                dropdownName = "Corian Colour",
                items = listOf(
                    "Tundra",
                    "Carbon",
                )
            )

            val stringValue = "Hello"
            val mutableStateString = remember { mutableStateOf(stringValue)}

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            frameColor = dropdownMenu(
                dropdownName = "Frame Colour",
                items = listOf(
                    "Argent",
                    "Caramel",
                    "Slate",
                )
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            dropdownMenu(
                dropdownName = "Status",
                items = listOf(
                    "QA",
                    "Programming",
                    "Inspection",
                    "Inventory"
                )
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { navController.navigate(Screen.QueryScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFFFA500),
                    containerColor = Color.White
                )
                ) {
                Text(stringResource(R.string.cancel))
            }

            Button(
                onClick = { TODO() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xfffcc474))
            ) {
                Text(stringResource(R.string.reset))
            }

            AppButton(
                {
                    //Store inputted fields
                    navController.navigate(Screen.QueryScreen.route)
                },
                stringResource(R.string.save)
            )
        }
    }
}

@Composable
fun getChairImage(corian: String, frame: String): Painter {

    var image = painterResource(R.drawable.chair_outline)

    if (corian == "Tundra") {
        image = when (frame) {
            "Argent" -> painterResource(R.drawable.tundra_silver)
            "Caramel" -> painterResource(R.drawable.tundra_gold)
            "Slate" -> painterResource(R.drawable.tundra_black)
            else -> painterResource(R.drawable.chair_outline)
        }
    }
    
    else if (corian == "Carbon") {
        image = when (frame) {
            "Argent" -> painterResource(R.drawable.carbon_silver)
            "Caramel" -> painterResource(R.drawable.carbon_gold)
            "Slate" -> painterResource(R.drawable.carbon_black)
            else -> painterResource(R.drawable.chair_outline)
        }
    }

    return image
}

//create functions to store information in database and firmware on button clicks



@Preview(showBackground = true)
@Composable
fun ProgrammingPreview() {
    Attribute_Programming_AppTheme {
        ProgrammingPage(navController = rememberNavController())
    }
}

fun CheckAllFields(): Boolean {
    TODO("check that all dropdowns have been filled")
    //if all fields have been filled out, return true
    //otherwise, return false
}
