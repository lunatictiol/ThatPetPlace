package com.petplace.thatpetplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.petplace.thatpetplace.auth.presentation.login.LoginScreen
import com.petplace.thatpetplace.auth.presentation.signup.SignUp
import com.petplace.thatpetplace.auth.presentation.signupDetails.SignUpDetails
import com.petplace.thatpetplace.common.Navigation
import com.petplace.thatpetplace.ui.theme.ThatPetPlaceTheme

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContent {
            ThatPetPlaceTheme {

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThatPetPlaceTheme {
        Greeting("Android")
    }
}