package com.petplace.thatpetplace.auth.presentation.signupDetails

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.auth.presentation.common.CustomButton
import com.petplace.thatpetplace.auth.presentation.common.CustomFont
import com.petplace.thatpetplace.auth.presentation.common.CustomOutlinedInput
import com.petplace.thatpetplace.auth.presentation.common.CustomPasswordInput
import com.petplace.thatpetplace.ui.theme.alegrya
import com.petplace.thatpetplace.ui.theme.alfa
import com.petplace.thatpetplace.ui.theme.rozha

@Composable
fun SignUpDetails() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 10.dp)) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Back",
                modifier = Modifier.size(40.dp),
                tint = Color.White
            )
        }
    }) { paddingValues ->

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFFFDA8A5),
                                Color(0xFFFFCB9C),
                            )
                        )
                    )
                    .padding(top = paddingValues.calculateTopPadding())
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "That Pet Place",
                    fontSize = 40.sp,
                    fontFamily = rozha,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
                Text(
                    text = "Create New Account",
                    fontSize = 20.sp,
                    fontFamily = alfa,
                    color = Color.White,
                    style = TextStyle(
                        shadow = Shadow(
                            Color.DarkGray, offset = Offset(x = 8.0f, y = -2.0f)
                        )
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
                CustomOutlinedInput(label = "Full Name")
                Spacer(modifier = Modifier.height(15.dp))
                CustomOutlinedInput(label = "Email")
                Spacer(modifier = Modifier.height(15.dp))
                CustomPasswordInput(label = "Password")
                Spacer(modifier = Modifier.height(15.dp))
                CustomPasswordInput(label = "Confirm Password")
                Spacer(modifier = Modifier.height(15.dp))
                CustomButton(label = "Submit", onClick = {/*TODO*/ })
                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(topStartPercent = 55, topEndPercent = 55))
                        .background(Color.White),
                    Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Crop,

                        )
                    Box(
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(
                                    topStartPercent = 50,
                                    topEndPercent = 50
                                )
                            )
                            .shadow(
                                elevation = 2.dp,
                                shape = RoundedCornerShape(
                                    topStartPercent = 55,
                                    topEndPercent = 55
                                ),
                            )
                            .fillMaxSize()
                    ) {

                    }
                }

            }
        }
    }
}