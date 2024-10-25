package com.petplace.thatpetplace.homeScreen.profile.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.common.components.LoadingDialogBox
import com.petplace.thatpetplace.homeScreen.profile.components.DisplayPet
import com.petplace.thatpetplace.homeScreen.profile.components.DisplayProfile
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileView(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: ProfileViewViewModel = koinViewModel()
) {
    val isLoading by remember {
        viewModel.isLoading
    }
    val isError by remember {
        viewModel.isError
    }
    val pets = remember {
        viewModel.listOfPets
    }
    Scaffold(backgroundColor = Color(0xFFF8F7FB), topBar = {
        TopBarProfile(
            rightText = "Add New Pet",
            actionOnclick = { navController.navigate(Routes.HomeScreenRoutes.PET_PROFILE_SCREEN) },
            enabled = false,
            title = "Profile",
            navController = navController,
            elevation = 0.dp
        )
    }) { it ->

        if (isLoading) {
            LoadingDialogBox()
        } else {
            if (isError) {
                Toast.makeText(LocalContext.current, "An error occurred", Toast.LENGTH_LONG).show()
                viewModel.updateError()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(
                            top = paddingValues.calculateTopPadding(),
                            bottom = paddingValues.calculateBottomPadding()
                        )
                ) {
                    DisplayProfile(viewModel = viewModel, navController)
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                            .height(55.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(
                                    Color(0x80FDA8A5)
                                ), Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.other),
                                contentDescription = "",
                                tint = Color(0xFFFDA8A5),
                                modifier = Modifier.size(22.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(horizontal = 5.dp)
                        ) {
                            Text(
                                text = "My pets",
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .fillMaxWidth(.7f)
                                    .padding(start = 8.dp)
                            )
                            Divider(modifier = Modifier.padding(top = 8.dp))
                        }
                    }
                    LazyColumn(
                        modifier = Modifier.clip(
                            RoundedCornerShape(
                                topEndPercent = 15, topStartPercent = 15
                            )
                        )
                    ) {
                        if (!pets.value.isNullOrEmpty()) {
                            items(pets.value!!) { pet ->
                                DisplayPet(
                                    viewModel = viewModel,
                                    navController = navController,
                                    petName = pet.name,
                                    breed = pet.breed,
                                    gender = pet.gender
                                ) {
                                    viewModel.deletePet(pet.id)
                                }
                            }
                        } else {
                            item {
                                Text(
                                    text = "No Pets Found!",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp,
                                    color = Color(0xFFBBC3CE),
                                    fontStyle = FontStyle.Italic,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}