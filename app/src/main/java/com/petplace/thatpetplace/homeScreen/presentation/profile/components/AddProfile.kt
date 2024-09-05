package com.petplace.thatpetplace.homeScreen.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.petplace.thatpetplace.R

@Composable
fun AddProfile() {
    Box(
        modifier = Modifier
            .width(115.dp)

            .height(115.dp)
            , Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.pet_profile), modifier = Modifier.clip(
                CircleShape
            ), contentScale = ContentScale.Crop, contentDescription = ""
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp),
            Alignment.TopEnd
        ) {
            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFFFFCB9C),
                                    Color(0xFFFDA8A5)

                                )
                            )
                        )
                        .clip(CircleShape), Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }

    }

}