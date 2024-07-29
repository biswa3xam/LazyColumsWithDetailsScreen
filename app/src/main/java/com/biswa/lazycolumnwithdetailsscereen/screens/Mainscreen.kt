package com.biswa.lazycolumnwithdetailsscereen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    imageId: Array<Int>,
    name: Array<String>,
    ingredients: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    LazyColumn(contentPadding = PaddingValues(16.dp)) {

        val itemSize = imageId.size

        items(itemSize) {
            ColumnItems(
                modifier,
                painter = imageId,
                title = name,
                ingredients = ingredients,
                itemIndex = it,
                navController = navController
            )
        }
    }

}

@Composable
fun ColumnItems(
    modifier: Modifier,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navController: NavController
) {

    Card(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
            .clickable {
                navController.navigate("DetailsScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(20.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = "DishImage",
                Modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = title[itemIndex], fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = ingredients[itemIndex], fontSize = 18.sp)
            }

        }


    }

}