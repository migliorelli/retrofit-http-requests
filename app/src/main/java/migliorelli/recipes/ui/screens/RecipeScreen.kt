package migliorelli.recipes.ui.screens

import CategoryList
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import migliorelli.recipes.models.Category
import migliorelli.recipes.viewmodels.MainViewModel

@Composable
fun RecipeScreen(
    viewState: MainViewModel.RecipeState,
    modifier: Modifier = Modifier,
    navigateToDetail: (Category) -> Unit
) {
    val recipeViewModel: MainViewModel = viewModel()

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text("ERROR OCCURRED")
            }

            else -> {
                Text(
                    text = "Categories",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                CategoryList(
                    categories = viewState.list,
                    navigateToDetail = navigateToDetail
                )
            }

        }
    }
}


