import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import migliorelli.recipes.models.Category
import migliorelli.recipes.ui.components.CategoryItem

@Composable
fun CategoryList(categories: List<Category>, navigateToDetail: (Category) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        items(categories) {
            CategoryItem(category = it, navigateToDetail = {
                navigateToDetail(it)
            })
        }
    }
}