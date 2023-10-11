package com.farshadchalenges.bazimizi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun retrieveLanguage() : SnapshotStateList<LanguageModel> {

    val languageList = remember {
        mutableStateListOf(
            LanguageModel("Persian",),
            LanguageModel( "English")
        )
    }
    return languageList
}