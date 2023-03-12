package com.sylvainmrzd.bankinchallenge.feature_categories_list.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sylvainmrzd.bankinchallenge.feature_categories_list.domain.model.Resource

@Composable
fun CategoryItem(category: Resource, index: Int, onClick: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onClick(index) },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Surface {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                /*AsyncImage(
                    model = , 
                    contentDescription = category.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                )*/
                Text(text = category.name)
            }
        }
    }

}