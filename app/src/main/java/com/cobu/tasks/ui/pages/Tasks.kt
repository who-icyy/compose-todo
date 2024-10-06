package com.cobu.tasks.ui.pages

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

val iftasks = false

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tasks(){
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = { Icon(Icons.Outlined.Menu, contentDescription = "Menu" , modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 5.dp)) },
                title = { Text("To-Do List") }
            ) },
        floatingActionButton = {
            ElevatedButton(modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .padding(10.dp),
                shape = RoundedCornerShape(10.dp)
                , onClick = {}) {
                Icon(Icons.Outlined.Add, contentDescription = "Menu")
            }
        }
    ) { innerPadding ->
        Text("Hello, world!", modifier = Modifier.padding(innerPadding))
    }
}