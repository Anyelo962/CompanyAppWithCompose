package com.example.companyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.companyapp.ui.theme.CompanyAppTheme
import com.example.companyapp.util.Routes
import com.example.companyapp.vlew.MainScreen
import com.example.companyapp.vlew.client.ClientScreen
import com.example.companyapp.vlew.company.CompanyScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompanyAppTheme {

                val navController = rememberNavController()


                NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN){

                    composable(Routes.MAIN_SCREEN){
                            MainScreen(onNavigate = {
                                navController.navigate(it.routeval)
                            })
                    }
                    composable(Routes.ADD_COMPANY){
                        CompanyScreen(onNavigate = {
                            navController.navigate(it.routeval)
                        })
                    }

                    composable(Routes.CLIENT_SCREEN){
                        ClientScreen(onNavigate = {
                            navController.navigate(it.routeval)
                        })
                    }

                }

            }

        }
    }
}


