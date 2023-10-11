package com.farshadchalenges.bazimizi.database

data class ShelemState(

    val shelem: List<Shelem> = emptyList(),
    val jokOrNotJoker: Boolean = false,
    val totalPointWithJok: Int = 200,
    val totalPointWithoutJok: Int = 165,
    val fullPointWithJokerForEachHand: Int = 200,
    val fullPointWithoutJokerForEachHand: Int = 165,
    val maxPointWithJoker: Int = 1600,
    val maxPointWithoutJoker: Int = 1165,
    val gamePointsDifferent: Boolean = true,
    val firstTeamName: String = "",
    val secondTeamName: String = "",
    val hakemPointPromised: Int = 0,
    val hakemTeam: Int = 1,
    val hakemPromise:Boolean = false,
    val hakemDidntPromise:Boolean = false,
    val firstTeamTotalPoints:Int = 0,
    val secondTeamTotalPoints:Int = 0,
    val winnerOfGame: String = "",
    val sortType: SortType = SortType.ID,
    val isAddingNewGame : Boolean=false
)