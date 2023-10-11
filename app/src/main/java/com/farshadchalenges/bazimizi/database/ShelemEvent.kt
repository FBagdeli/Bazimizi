package com.farshadchalenges.bazimizi.database

// the ShelemEvent , we should define actions of user
//for example if he click on add what should happen and ect

sealed interface ShelemEvent{

    object PlayWithJokOrNotJok:ShelemEvent
    data class SetTotalPointWithJok(val totalPointWithJok: Int):ShelemEvent
    data class SetTotalPointWithoutJok(val totalPointWithoutJok: Int):ShelemEvent
    data class SetFullPointWithJokerForEachHand(val fullPointWithJokerForEachHand: Int):ShelemEvent
    data class SetFullPointWithoutJokerForEachHand(val fullPointWithoutJokerForEachHand: Int):ShelemEvent
    data class SetMaxPointWithJoker(val maxPointWithJoker: Int):ShelemEvent
    data class SetMaxPointWithoutJoker(val maxPointWithoutJoker: Int):ShelemEvent
    object WinForPointDifference:ShelemEvent
    data class SetFirstTeam(val firstTeam: String):ShelemEvent
    data class SetSecondTeam(val secondTeam: String):ShelemEvent
    data class SetHakemPointPromised(val hakemPointPromised: Int) :ShelemEvent
    data class SetHakemTeam(val hakemTeam: Int):ShelemEvent
    object HakemKeptPromise:ShelemEvent
    object HakemDidntKeptPromise:ShelemEvent
    data class SumFirstTeamPoints(val firstTeamPoints: Int):ShelemEvent
    data class SumSecondTeamPoints(val secondTeamPoints: Int):ShelemEvent
    data class SetWinnerOfGame(val winnerOfGame: String):ShelemEvent

}