package com.gabriel.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gabriel.nearby.data.model.Market
import com.gabriel.nearby.ui.screen.HomeScreen
import com.gabriel.nearby.ui.screen.MarketDetailsScreen
import com.gabriel.nearby.ui.screen.SplashScreen
import com.gabriel.nearby.ui.screen.WelcomeScreen
import com.gabriel.nearby.ui.screen.route.Home
import com.gabriel.nearby.ui.screen.route.Splash
import com.gabriel.nearby.ui.screen.route.Welcome
import com.gabriel.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NearbyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            modifier = Modifier.fillMaxSize(),
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(onNavigateToHome = {
                            navController.navigate(Home)
                        })
                    }
                    composable<Home> {
                        HomeScreen(onNavigateToMarketDetails = {selectedMarket ->
                            navController.navigate(selectedMarket)
                        })
                    }
                    composable<Market>{
                        val selectedMarket = it.toRoute<Market>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            modifier = Modifier,
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }

    }
}
