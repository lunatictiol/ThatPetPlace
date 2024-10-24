package com.petplace.thatpetplace.homeScreen.profile.components

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.homeScreen.profile.presentation.ProfileViewViewModel

@Composable
fun DisplayPet(viewModel: ProfileViewViewModel, navController: NavHostController, petName: String, breed: String, gender:String,onDelete:()->Unit) {
    var selectedImage by remember {
        mutableStateOf<Uri?>(null)
    }
    Log.e("details", petName)
    ListItem(modifier = Modifier.padding(vertical = 2.dp),
        headlineContent = { Text(text = petName) },
        leadingContent = {
            AsyncImage(
                model = if (selectedImage == null) {
                    R.drawable.petprofile_placeholder
                } else selectedImage,
                contentDescription = "Profile photo",
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clip(
                        CircleShape
                    )
                    .shadow(8.dp, CircleShape),
                contentScale = ContentScale.Crop
            )
        },
        overlineContent = { Text(text = breed) },
        supportingContent = { Text(text = gender) },
        trailingContent = {
            Column {
            IconButton(
                    onClick = { navController.navigate(Routes.HomeScreenRoutes.PET_PROFILE_SCREEN) },
                    modifier = Modifier.size(20.dp)
                ) {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = "Edit",
                tint = Color(0xFFFDA8A5)
            )
        }
                IconButton(
                    onClick = {onDelete()},
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete",
                        tint = Color(0xFFFDA8A5)
                    )
                }

            }
        })
}