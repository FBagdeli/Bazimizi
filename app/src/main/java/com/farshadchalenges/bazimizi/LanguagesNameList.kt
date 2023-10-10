package com.farshadchalenges.bazimizi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun retrieveLanguage() : SnapshotStateList<LanguageModel> {

    val languageList = remember {
        mutableStateListOf(
            LanguageModel(1, "Persian", R.drawable.persain_flag),
            LanguageModel(2, "English", R.drawable.england_flag)
        )
    }
    return languageList
}