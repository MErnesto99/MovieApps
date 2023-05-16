package com.example.movieapps.Utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun AppBar(title:String,icon:ImageVector,iconClicked:() -> Unit){
    TopAppBar(title = { Text(text = title) },
        backgroundColor = Color.Yellow,
        elevation = 5.dp,
    navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = icon, contentDescription = "",
                modifier = Modifier
                    .padding(10.dp)
                    .clickable (onClick = { iconClicked.invoke() }))
        }
    })

}