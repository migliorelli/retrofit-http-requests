package migliorelli.recipes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import migliorelli.recipes.models.Category
import migliorelli.recipes.models.Screen
import migliorelli.recipes.ui.screens.CategoryDetailScreen
import migliorelli.recipes.ui.screens.RecipeScreen
import migliorelli.recipes.viewmodels.MainViewModel

@Composable
fun RecipesApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val recipesViewState by recipeViewModel.categoryState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(Screen.RecipeScreen.route) {
            RecipeScreen(
                viewState = recipesViewState,
                navigateToDetail = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                    navController.navigate(Screen.DetailScreen.route)
                })
        }

        composable(Screen.DetailScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                    ?: Category("", "", "", "")

            CategoryDetailScreen(category = category)
        }
    }
}