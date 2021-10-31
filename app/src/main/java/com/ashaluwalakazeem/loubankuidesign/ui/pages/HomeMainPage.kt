package com.ashaluwalakazeem.loubankuidesign.ui.pages

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ashaluwalakazeem.loubankuidesign.R
import com.ashaluwalakazeem.loubankuidesign.ui.theme.*
import com.ashaluwalakazeem.loubankuidesign.utils.cardList
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun HomeMainPage(rootNavigation: NavHostController) {
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
                        val logoDrawable =
                            AppCompatResources.getDrawable(
                                LocalContext.current,
                                R.drawable.ic_logo1
                            )
                        Image(
                            painter = rememberDrawablePainter(drawable = logoDrawable),
                            contentDescription = null,
                            modifier = Modifier.padding(end = 35.dp)
                        )
                    }
                },
                contentColor = White,
                backgroundColor = Background,
                navigationIcon = {
                    val avatarDrawable =
                        AppCompatResources.getDrawable(
                            LocalContext.current,
                            R.drawable.avatar
                        )
                    Image(
                        painter = rememberDrawablePainter(drawable = avatarDrawable),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .size(30.dp)
                            .clip(
                                RoundedCornerShape(percent = 50)
                            )
                    )
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
                HomeMainPageBottomBar()
            }
        }
    ) { contentPadding ->
        CompositionLocalProvider(LocalRippleTheme provides RippleCustomTheme) {
            HomeMainPageContent(Modifier.padding(contentPadding))
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun HomeMainPageContent(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 20.dp, end = 10.dp)
        ){
            Column() {
                Text(text = "Your balance", style = MaterialTheme.typography.h3,  color = White)
                Text(text = "$7,896", style = MaterialTheme.typography.h1, fontWeight = FontWeight.Bold, color = White)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = White)
            }
        }
        LazyColumn(
            modifier = Modifier.padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item{
                val pagerState = rememberPagerState()
                HorizontalPager(
                    count = cardList.size,
                    state = pagerState,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                ) { page ->
                    PagerItem(page = page,
                        Modifier
                            .fillMaxWidth()
                    )
                }

                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(20.dp),
                    activeColor = Accent,
                    inactiveColor = Grey,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 17.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Transactions", style = MaterialTheme.typography.h2, fontWeight = FontWeight.Bold, color = White)
                    
                    TextButton(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(percent = 50),
                        colors = ButtonDefaults.buttonColors(Grey2, White),
                        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 2.dp)
                    ) {
                        Text(text = "Filter", style = MaterialTheme.typography.button, color = White)
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null, tint = White)
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 17.dp, vertical = 10.dp)
                ){
                    Text(text = "Today", style = MaterialTheme.typography.h5, color = White, modifier = Modifier.padding(vertical = 10.dp))
                    TransactionItem(
                        icon = R.drawable.ic_receive,
                        transactionTitle = "Transfer",
                        transactionInfo = "Incoming Transfer",
                        amount = "+ $3,110"
                    ) {}
                    TransactionItem(
                        icon = R.drawable.ic_sent,
                        transactionTitle = "Health",
                        transactionInfo = "Pharmacy",
                        amount = "- $3,129"
                    ) {}
                    Text(text = "June 13th", style = MaterialTheme.typography.h5, color = White, modifier = Modifier.padding(vertical = 10.dp))
                    TransactionItem(
                        icon = R.drawable.ic_receive,
                        transactionTitle = "Transfer",
                        transactionInfo = "Incoming Transfer",
                        amount = "+ $3,110"
                    ) {}
                    TransactionItem(
                        icon = R.drawable.ic_sent,
                        transactionTitle = "Health",
                        transactionInfo = "Pharmacy",
                        amount = "- $3,129"
                    ) {}
                }
            }
        }
    }
}

@Composable
private fun TransactionItem(icon: Int, transactionTitle: String, transactionInfo: String, amount: String, onclick: () -> Unit){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clickable { onclick() }
    ){
        val drawableIcon = AppCompatResources.getDrawable(LocalContext.current, icon)
        Image(painter = rememberDrawablePainter(drawable = drawableIcon), contentDescription = null)
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 20.dp)
        ) {
            Text(text = transactionTitle, style = MaterialTheme.typography.h4, color = White, fontWeight = FontWeight.Bold)
            Text(text = transactionInfo, style = MaterialTheme.typography.body1, color = Grey, fontWeight = FontWeight.Bold)
        }
        Text(text = amount, style = MaterialTheme.typography.h4, color = White, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun PagerItem(page: Int, modifier: Modifier){
    val cardDrawable =
        AppCompatResources.getDrawable(
            LocalContext.current,
            cardList[page]
        )
    Image(
        painter = rememberDrawablePainter(drawable = cardDrawable),
        contentDescription = null,
        modifier = modifier.padding(horizontal = 20.dp)
    )
}

@Composable
private fun HomeMainPageBottomBar(){
    Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        val homeDrawable = AppCompatResources.getDrawable(LocalContext.current, R.drawable.ic_home_active)
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