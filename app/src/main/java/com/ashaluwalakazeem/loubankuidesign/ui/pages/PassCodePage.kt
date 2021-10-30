package com.ashaluwalakazeem.loubankuidesign.ui.pages

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ashaluwalakazeem.loubankuidesign.R
import com.ashaluwalakazeem.loubankuidesign.ui.theme.Background
import com.ashaluwalakazeem.loubankuidesign.ui.theme.White
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun PassCodePage(rootNavigation: NavHostController) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Background,
            darkIcons = false
        )
    }
    Scaffold(
        topBar = {
            // We use TopAppBar from accompanist-insets-ui which allows us to provide
            // content padding matching the system bars insets.
            TopAppBar(
                contentPadding = rememberInsetsPaddingValues(
                    insets = LocalWindowInsets.current.statusBars,
                    applyStart = true,
                    applyTop = true,
                    applyEnd = true,
                ),
                title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        val drawable =
                            AppCompatResources.getDrawable(LocalContext.current, R.drawable.ic_logo)
                        Image(
                            painter = rememberDrawablePainter(drawable = drawable),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 35.dp)
                        )
                    }
                },
                contentColor = White,
                backgroundColor = Background,
                actions = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                    }
                }
            )
        },
        backgroundColor = Background
    ) {
        PassCodePageContent()
    }
}

@Composable
private fun PassCodePageContent(){

}