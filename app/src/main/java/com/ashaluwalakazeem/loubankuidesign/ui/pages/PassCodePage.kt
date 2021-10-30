package com.ashaluwalakazeem.loubankuidesign.ui.pages

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ashaluwalakazeem.loubankuidesign.R
import com.ashaluwalakazeem.loubankuidesign.ui.theme.*
import com.ashaluwalakazeem.loubankuidesign.utils.passCodeList
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@ExperimentalFoundationApi
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
                            AppCompatResources.getDrawable(
                                LocalContext.current,
                                R.drawable.ic_logo1
                            )
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
        backgroundColor = Background,
        bottomBar = {
            Spacer(
                Modifier
                    .navigationBarsHeight()
                    .fillMaxWidth())
            CompositionLocalProvider(LocalRippleTheme provides RippleCustomTheme) {
                PassCodeBottomBar()
            }
        }
    ) {
        PassCodePageContent()
    }
}

@ExperimentalFoundationApi
@Composable
private fun PassCodePageContent() {
    var displayDemoModeDialog by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        Text(text = "Enter Passcode", style = MaterialTheme.typography.body1, color = White)

        Row(modifier = Modifier.padding(top = 20.dp, bottom = 25.dp)) {
            Box(
                modifier = Modifier
                    .size(width = 30.dp, height = 10.dp)
                    .padding(horizontal = 10.dp)
                    .background(color = Grey, shape = CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(width = 30.dp, height = 10.dp)
                    .padding(horizontal = 10.dp)
                    .background(color = Grey, shape = CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(width = 30.dp, height = 10.dp)
                    .padding(horizontal = 10.dp)
                    .background(color = Grey, shape = CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(width = 30.dp, height = 10.dp)
                    .padding(horizontal = 10.dp)
                    .background(color = Grey, shape = CircleShape)
            )
        }

        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(10.dp),
        ) {
            items(passCodeList.size) { index ->
                val item = passCodeList[index]
                if (item.number.isNotEmpty()) {
                    PassCodeCustomButton(number = item.number, letters = item.letters) {

                    }
                }
            }
        }
        Text(text = "Can not login?", color = Accent, style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(vertical = 2.dp)
                .clickable {
                    displayDemoModeDialog = true
                }
        )
        if(displayDemoModeDialog){
            AlertDialog(
                onDismissRequest = { displayDemoModeDialog = false},
                title = {

                },
                text = {
                    TextButton(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = White, TextDarkColor),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Demo mode", style = MaterialTheme.typography.body1)
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null, modifier = Modifier.padding(start = 10.dp))
                    }
                },
                shape = MaterialTheme.shapes.large,
                backgroundColor = White,
                contentColor = TextDarkColor,
                buttons = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun PassCodeCustomButton(number: String, letters: String = "", onclick: () -> Unit) {
    CompositionLocalProvider(LocalRippleTheme provides RippleCustomTheme) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .size(70.dp)
                    .background(
                        color = if (number != "DEL") Grey2 else Background,
                        shape = RoundedCornerShape(percent = 50)
                    )
                    .clip(shape = RoundedCornerShape(percent = 50)) // Shape the Ripple Effect
                    .clickable {
                        onclick()
                    }
            ) {
                if(number != "DEL"){
                    Text(text = number, style = MaterialTheme.typography.h2, color = White)
                    if (letters.isNotEmpty()) Text(
                        text = letters,
                        style = MaterialTheme.typography.body1,
                        color = White
                    )
                }else {
                    IconButton(onClick = {  }) {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_backspace_24), contentDescription = null, tint = White)
                    }
                }
            }
        }
    }
}

@Composable
private fun PassCodeBottomBar(){
    Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        val homeDrawable = AppCompatResources.getDrawable(LocalContext.current, R.drawable.ic_home_unactive)
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = rememberDrawablePainter(drawable = homeDrawable), contentDescription = null)
        }
        val shopDrawable = AppCompatResources.getDrawable(LocalContext.current, R.drawable.ic_shop_unactive)
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = rememberDrawablePainter(drawable = shopDrawable), contentDescription = null)
        }
        val cardDrawable = AppCompatResources.getDrawable(LocalContext.current, R.drawable.ic_card_unactive)
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = rememberDrawablePainter(drawable = cardDrawable), contentDescription = null)
        }
        val chatDrawable = AppCompatResources.getDrawable(LocalContext.current, R.drawable.ic_chat_unactive)
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = rememberDrawablePainter(drawable = chatDrawable), contentDescription = null)
        }
        val historyDrawable = AppCompatResources.getDrawable(LocalContext.current, R.drawable.ic_history_unactive)
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = rememberDrawablePainter(drawable = historyDrawable), contentDescription = null)
        }
    }
}