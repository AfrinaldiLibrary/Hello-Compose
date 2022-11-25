package com.afrinaldi.jetpackcoffee

import SectionText
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afrinaldi.jetpackcoffee.model.Menu
import com.afrinaldi.jetpackcoffee.model.dummyBestSellerMenu
import com.afrinaldi.jetpackcoffee.model.dummyCategory
import com.afrinaldi.jetpackcoffee.model.dummyMenu
import com.afrinaldi.jetpackcoffee.ui.components.CategoryItem
import com.afrinaldi.jetpackcoffee.ui.components.MenuItem
import com.afrinaldi.jetpackcoffee.ui.components.SearchBar
import com.afrinaldi.jetpackcoffee.ui.theme.JetpackCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCoffeeTheme {
                // A surface container using the 'background' color from the theme
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
    ) {
        Banner()
        SectionText(title = stringResource(id = R.string.section_category))
        CategoryRow()
        SectionText(title = stringResource(id = R.string.section_favorite_menu))
        MenuRow(listMenu = dummyMenu)
        SectionText(title = stringResource(id = R.string.section_best_seller_menu))
        MenuRow(listMenu = dummyBestSellerMenu)
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu = menu)
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun BannerPreview() {
    JetpackCoffeeTheme {
        Banner()
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryRowPreview() {
    JetpackCoffeeTheme {
        CategoryRow()
    }
}

@Preview(showBackground = true)
@Composable
fun MenuRowPreview() {
    JetpackCoffeeTheme() {
        MenuRow(dummyMenu)
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun JetpackCoffeeAppPreview() {
    JetpackCoffeeTheme {
        JetCoffeeApp()
    }
}