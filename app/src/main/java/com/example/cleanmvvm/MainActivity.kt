package com.example.cleanmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanmvvm.presentation.Screen
import com.example.cleanmvvm.presentation.country_detail.CountryDetailScreen
import com.example.cleanmvvm.presentation.country_list.CountryListScreen
import com.example.cleanmvvm.presentation.ui.theme.CleanMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanMVVMTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.CountryListScreen.route
                ) {
                    composable(
                        Screen.CountryListScreen.route
                    ) {
                        CountryListScreen(navController = navController)
                    }
                    composable(
                        Screen.DetailScreen.route + "/{countryCode}"
                    ) {
                        CountryDetailScreen()
                    }
                }
            }
        }
    }
}