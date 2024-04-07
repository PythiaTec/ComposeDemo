import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import composedemo.composeapp.generated.resources.Res
import composedemo.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var value by remember { mutableStateOf("none") }

        val selectionList = listOf("Value1", "Value2", "Value3")
        var selectedItem by remember {  mutableStateOf("Value1") }


        var mExpanded1 by remember { mutableStateOf(false) }
        val icon1 = if (mExpanded1)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown



        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent },
                    modifier = Modifier
                    .height(75.dp)
                .width(175.dp)
                .fillMaxHeight()
                .padding(1.dp)
                .semantics { contentDescription = "Top Button" }
                .testTag("TOPBUTTON"),
            ) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
            Row() {
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .testTag("R1")
                        .padding(1.dp)
                        .background(
                            color = Color.Blue,
                            shape = CircleShape
                        )
                        .size(50.dp, 50.dp)
                        .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                        .combinedClickable(
                            enabled = true,
                            onClick = {
                                value = "1M"
                            },
                            onLongClick = {}
                        )
                ) {
                    Text(
                        text = "1M",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 24.sp,
                        color = Color.White,
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Box(
                    modifier = Modifier
                        .testTag("R3")
                        .padding(1.dp)
                        .background(
                            color = Color.Green,
                            shape = CircleShape
                        )
                        .size(50.dp, 50.dp)
                        .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                        .combinedClickable(
                            enabled = true,
                            onClick = {
                                value = "3M"
                            },
                            onLongClick = {}
                        )
                ) {
                    Text(
                        text = "3M",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 24.sp,
                        color = Color.White,
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Box(
                    modifier = Modifier
                        .testTag("R5")
                        .padding(1.dp)
                        .background(
                            color = Color.Red,
                            shape = CircleShape
                        )
                        .size(50.dp, 50.dp)
                        .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                        .combinedClickable(
                            enabled = true,
                            onClick = {
                                value = "5M"
                            },
                            onLongClick = {}
                        )
                ) {
                    Text(
                        text = "5M",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 24.sp,
                        color = Color.White,
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Box(
                    modifier = Modifier
                        .testTag("R10")
                        .padding(1.dp)
                        .background(
                            color = Color.Yellow,
                            shape = CircleShape
                        )
                        .size(50.dp, 50.dp)
                        .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                        .combinedClickable(
                            enabled = true,
                            onClick = {
                                value = "10M"
                            },
                            onLongClick = {}
                        )
                ) {
                    Text(
                        text = "10M",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 24.sp,
                        color = Color.White,
                    )
                }
            }
                Spacer(modifier = Modifier.width(10.dp))
                Row() {
                    Text(
                        text = value
                    )
                }

            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                OutlinedTextField(
                    value = selectedItem,
                    onValueChange = { selectedItem = it },
                    modifier = Modifier
                        .semantics { contentDescription = "Selection" }
                        .testTag("SelectionTag"),
                    label = { Text(text = "Selection") },
                    trailingIcon = {
                        Icon(icon1, "Selection",
                            modifier = Modifier
                                .clickable { mExpanded1 = !mExpanded1 }
                                .semantics { contentDescription = "Selection Icon" }
                                .testTag("SelectionIconTag"),
                        )
                    }
                )
                DropdownMenu(
                    expanded = mExpanded1,
                    onDismissRequest = { mExpanded1 = false },
                    modifier = Modifier
                        .semantics { contentDescription = "Selection Dropdown" }
                        .testTag("SeelectionDropDownTag"),
                ) {
                    selectionList.forEach { label ->
                        DropdownMenuItem(
                            text = { Text(label) },
                            enabled = true,
                            modifier = Modifier
//                            .semantics { contentDescription = "Setting Match Item" }
                                .testTag("SeelectionDropDownItemTag"),
                            onClick = {
                                selectedItem = label
                                mExpanded1 = false
                            })
                    }
                }
            }

        }
    }
}