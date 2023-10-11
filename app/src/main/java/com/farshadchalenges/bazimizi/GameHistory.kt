package com.farshadchalenges.bazimizi

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun GameHistory(navController: NavController){

    Button(onClick = { navController.popBackStack() }) {
        Text(text = stringResource(id = R.string.games_history_explanation))
    }

}