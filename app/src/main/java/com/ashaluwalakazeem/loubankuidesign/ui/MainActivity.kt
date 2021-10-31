package com.ashaluwalakazeem.loubankuidesign.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ashaluwalakazeem.loubankuidesign.ui.pages.HomeMainPage
import com.ashaluwalakazeem.loubankuidesign.ui.pages.LoginPage
import com.ashaluwalakazeem.loubankuidesign.ui.pages.PassCodePage
import com.ashaluwalakazeem.loubankuidesign.ui.theme.LouBankUIDesignTheme
import com.ashaluwalakazeem.loubankuidesign.utils.homeMainPageRoute
import com.ashaluwalakazeem.loubankuidesign.utils.loginPageRoute
import com.ashaluwalakazeem.loubankuidesign.utils.passCodePageRoute
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            LouBankUIDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    RootNavigation()
                }
            }
        }
    }
}

@ExperimentalPagerApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun RootNavigation(){
    val rootNavigation = rememberAnimatedNavController()
    AnimatedNavHost(navController = rootNavigation, startDestination = loginPageRoute){
        composable(
            route = loginPageRoute,
            enterTransition = { initial, _ ->
                when (initial.destination.route) {
                    passCodePageRoute ->
                        slideInVertically(initialOffsetY = { 1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    passCodePageRoute ->
                        slideOutVertically(targetOffsetY = { -1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popEnterTransition = { initial, _ ->
                when (initial.destination.route) {
                    passCodePageRoute ->
                        slideInVertically(initialOffsetY = { -1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popExitTransition = { _, target ->
                when (target.destination.route) {
                    passCodePageRoute ->
                        slideOutVertically(targetOffsetY = { 1000 }, animationSpec = tween(700))
                    else -> null
                }
            }
        ){
            LoginPage(rootNavigation = rootNavigation)
        }

        composable(
            route = passCodePageRoute,
            enterTransition = { initial, _ ->
                when (initial.destination.route) {
                    loginPageRoute, homeMainPageRoute ->
                        slideInVertically(initialOffsetY = { 1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    loginPageRoute, homeMainPageRoute ->
                        slideOutVertically(targetOffsetY = { -1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popEnterTransition = { initial, _ ->
                when (initial.destination.route) {
                    loginPageRoute, homeMainPageRoute ->
                        slideInVertically(initialOffsetY = { -1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popExitTransition = { _, target ->
                when (target.destination.route) {
                    loginPageRoute, homeMainPageRoute ->
                        slideOutVertically(targetOffsetY = { 1000 }, animationSpec = tween(700))
                    else -> null
                }
            }
        ){
            PassCodePage(rootNavigation = rootNavigation)
        }

        composable(
            route = homeMainPageRoute,
            enterTransition = { initial, _ ->
                when (initial.destination.route) {
                    passCodePageRoute ->
                        slideInVertically(initialOffsetY = { 1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    passCodePageRoute ->
                        slideOutVertically(targetOffsetY = { -1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popEnterTransition = { initial, _ ->
                when (initial.destination.route) {
                    passCodePageRoute ->
                        slideInVertically(initialOffsetY = { -1000 }, animationSpec = tween(700))
                    else -> null
                }
            },
            popExitTransition = { _, target ->
                when (target.destination.route) {
                    passCodePageRoute ->
                        slideOutVertically(targetOffsetY = { 1000 }, animationSpec = tween(700))
                    else -> null
                }
            }
        ){
            HomeMainPage(rootNavigation = rootNavigation)
        }

    }
}