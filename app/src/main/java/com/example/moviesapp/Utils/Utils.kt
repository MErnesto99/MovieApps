package com.example.moviesapp.Utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
    TopAppBar(title = { Text(text = title,Modifier.padding(start=5.dp)) },
        backgroundColor = Color.Yellow,
        elevation = 5.dp,
    navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = icon, contentDescription = "",
                modifier = Modifier
                    .padding(10.dp)
                    .clickable(onClick = { iconClicked.invoke() }))
        }
    })

}

@Composable
fun AppBar1(title: String,icon: ImageVector,iconClicked: () -> Unit){
    
    TopAppBar(backgroundColor = Color.Yellow.copy(1f)) {
        IconButton(onClick = {iconClicked.invoke() }) {
            Icon(imageVector = icon, contentDescription ="")
        }
        Row(modifier = Modifier.padding(0.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = title)
        }
    }
}