package com.petplace.thatpetplace.common.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun NumberInputField(
    label: String, value: String, verified: Boolean= false, enabled: Boolean= false, onValueChangeEvent: (String)-> Unit
) {

    TextField(value = value,
        onValueChange = {
            onValueChangeEvent(it)

        }, modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(fontSize = 16.sp,),
        label = { Text(text = label) },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedLabelColor = Color(0xFFBBC3CE),
            focusedIndicatorColor = Color(0xFFBBC3CE),
            textColor = Color.Black
        ),
        trailingIcon = {
            if (enabled) {

                Icon(
                    imageVector = if (verified) Icons.Filled.CheckCircle else Icons.Rounded.Warning,
                    contentDescription = "",
                    tint = if (verified) Color(0xFF04AF70) else Color.LightGray
                )
            }

        })
}