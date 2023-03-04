package com.study.appwithmultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.appwithmultimodule.ui.theme.AppWithMultiModuleTheme
import com.study.appwithmultimodule.util.navigate
import com.study.core.navigation.Route
import com.study.onboarding_presentation.activity.ActivityLevelScreen
import com.study.onboarding_presentation.age.AgeScreen
import com.study.onboarding_presentation.gender.GenderScreen
import com.study.onboarding_presentation.goal.GoalTypeScreen
import com.study.onboarding_presentation.height.HeightScreen
import com.study.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.study.onboarding_presentation.weight.WeightScreen
import com.study.onboarding_presentation.welcome.WelcomeScreen
import com.study.tracker_presentation.tracker_overview.TrackerOverviewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppWithMultiModuleTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.WELCOME
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.AGE) {
                         AgeScreen(scaffoldState = scaffoldState ,onNavigate = navController::navigate)
                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(scaffoldState = scaffoldState, onNavigate = navController::navigate )
                        }
                        composable(Route.WEIGHT) {
                            WeightScreen(scaffoldState = scaffoldState, onNavigate = navController::navigate )
                        }
                        composable(Route.NUTRIENT_GOAL) {
                            NutrientGoalScreen(scaffoldState = scaffoldState, onNavigate = navController::navigate)
                        }
                        composable(Route.ACTIVITY) {
                            ActivityLevelScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.GOAL) {
                            GoalTypeScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                            TrackerOverviewScreen(onNavigate = navController::navigate)
                        }
                        composable(Route.SEARCH) {

                        }
                    }
                }


            }
        }
    }
}

