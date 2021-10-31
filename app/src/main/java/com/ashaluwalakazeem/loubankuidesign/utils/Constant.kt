package com.ashaluwalakazeem.loubankuidesign.utils

import com.ashaluwalakazeem.loubankuidesign.R
import com.ashaluwalakazeem.loubankuidesign.data.model.PassCodeData

const val loginPageRoute = "loginPage"
const val passCodePageRoute = "passCodePage"
const val homeMainPageRoute = "HomeMainPage"
val passCodeList = listOf<PassCodeData>(
    PassCodeData("1", ""),
    PassCodeData("2", "ABC"),
    PassCodeData("3", "DEF"),
    PassCodeData("4", "GHI"),
    PassCodeData("5", "JKL"),
    PassCodeData("6", "MNO"),
    PassCodeData("7", "PQRS"),
    PassCodeData("8", "TUV"),
    PassCodeData("9", "WXYZ"),
    PassCodeData("", ""),
    PassCodeData("0", ""),
    PassCodeData("DEL", ""),
)
val cardList = listOf<Int>(
    R.drawable.card1,
    R.drawable.card2,
    R.drawable.card3,
    R.drawable.card4,
    R.drawable.card5,
)