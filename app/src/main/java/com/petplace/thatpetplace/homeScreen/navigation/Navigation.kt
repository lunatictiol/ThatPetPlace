package com.petplace.thatpetplace.homeScreen.navigation


import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.petplace.thatpetplace.auth.presentation.login.LoginScreen
import com.petplace.thatpetplace.auth.presentation.signupDetails.SignUpDetails
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.homeScreen.Payment.PaymentSuccessful
import com.petplace.thatpetplace.homeScreen.appointments.Appointments
import com.petplace.thatpetplace.homeScreen.explore.presentation.CartScreen.CartScreen
import com.petplace.thatpetplace.homeScreen.explore.presentation.Explore
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.ExploreDetailScreen
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.StoreScreen
import com.petplace.thatpetplace.homeScreen.profile.presentation.ProfileView
import com.petplace.thatpetplace.homeScreen.profile.presentation.petDetail.PetDetailScreen
import com.petplace.thatpetplace.homeScreen.profile.presentation.profileDetail.Profile
import com.petplace.thatpetplace.homeScreen.search.SearchScreen
import com.petplace.thatpetplace.welcome.presentation.FirstScreen
import com.petplace.thatpetplace.welcome.presentation.SecondScreen
import com.petplace.thatpetplace.welcome.presentation.ThirdScreen
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: NavigationViewModel = koinViewModel(),
    paddingValues: PaddingValues,
    isProfile: ()->Unit={}

) {

    val isWelcomeCompleted by viewModel.isWelcomeCompleted.collectAsState(initial = false)
    val isLoggedIn by viewModel.isLoginCompleted.collectAsState(initial = false)


        if (isWelcomeCompleted && isLoggedIn) {
            NavHost(
                navController = navController,
                startDestination = Routes.HomeScreenRoutes.SEARCH_SCREEN
            ) {

                composable(Routes.HomeScreenRoutes.SEARCH_SCREEN) {
                    SearchScreen(navController)
                }
                composable(Routes.HomeScreenRoutes.APPOINTMENT_SCREEN) {
                    Appointments(paddingValues, navController)
                }
                composable(Routes.HomeScreenRoutes.EXPLORE_SCREEN +"/{passedString}?", arguments = listOf(navArgument("passedString") { type = NavType.StringType })
                ) { backStackEntry ->
                    val passedString = backStackEntry.arguments?.getString("passedString")?:""
                    Explore(paddingValues, filter = passedString,navController)
                }
                composable(Routes.HomeScreenRoutes.PROFILE_SCREEN) {

                    Profile(navController, paddingValues = paddingValues)
                }
                composable(Routes.HomeScreenRoutes.PET_PROFILE_SCREEN) {backStackEntry->
                    val status: String = backStackEntry.arguments?.getString( "status" ) ?:""
                    PetDetailScreen(navController, paddingValues = paddingValues)
                }
                composable(Routes.HomeScreenRoutes.PROFILE_VIEW_SCREEN) {

                    ProfileView(navController, paddingValues = paddingValues)
                }
                composable(Routes.HomeScreenRoutes.EXPLORE_DETAIL_SCREEN + "/{id}") {backStackEntry->
                    val id: String = backStackEntry.arguments?.getString( "id" ) ?:""
                    ExploreDetailScreen(paddingValues = paddingValues,navController, isProfile = isProfile, id = id)
                }
                composable(Routes.HomeScreenRoutes.STORE_SCREEN) {

                    StoreScreen(paddingValues = paddingValues,navController,)
                }
                composable(Routes.HomeScreenRoutes.PAYMENT_SUCCESS_SCREEN) {

                    PaymentSuccessful(navController)
                }
                composable(Routes.HomeScreenRoutes.CART_SCREEN){
                    CartScreen(navController = navController, isProfile = isProfile)
                }


            }
        } else if (!isLoggedIn && isWelcomeCompleted) {
            NavHost(
                navController = navController,
                startDestination = Routes.AuthRoutes.LOGIN_SCREEN
            ) {

                composable(Routes.AuthRoutes.LOGIN_SCREEN) {
                    LoginScreen(navHostController = navController)
                }
                composable(Routes.AuthRoutes.SIGNUP_DETAILS_SCREEN) {
                    SignUpDetails(navHostController = navController)
                }


            }
        } else {
            NavHost(
                navController = navController,
                startDestination = Routes.WelcomeRoutes.FIRST_SCREEN
            ) {
                composable(Routes.WelcomeRoutes.FIRST_SCREEN) {
                    FirstScreen(navHostController = navController)
                }
                composable(Routes.WelcomeRoutes.SECOND_SCREEN) {
                    SecondScreen(navHostController = navController)
                }
                composable(Routes.WelcomeRoutes.THIRD_SCREEN) {
                    ThirdScreen(navHostController = navController) {
                        viewModel.updateIsWelcomeCompleted(
                            completed = true
                        )
                    }
                }
            }
        }




}

