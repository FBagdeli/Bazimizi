package com.farshadchalenges.bazimizi.database

data class ShelemState(

    val shelem: List<Shelem> = emptyList(),

    val playWithJok: Boolean = false, //game with joker or without joker 165 , 200
    //val playWithoutJok: Boolean = false,
    val totalPointWithJok: Int = 200,//Total point with joker for each hand 200,230
    val totalPointWithoutJok: Int = 165,//Total point without joker for each hand 165,185
    val fullPointWithJokerForEachHand: Int = 200, //Trigger in case that if one of the teams take all points
    //without saying "SHELEM", what will happen?For WithJoker
    //equals to point they took for that hand, or 240 or 2x
    //WITHOUT SAYING SHELEM
    val fullPointWithoutJokerForEachHand: Int = 165,//Trigger in case that if one of the teams take all points
    //without saying "SHELEM", what will happen?For WithJoker
    //equals to point they took for that hand, or 240 or 2x
    //WITHOUT SAYING SHELEM
    val maxPointWithJoker: Int = 1600, //maximum point to win 600,800,1600
    val maxPointWithoutJoker: Int = 1165,//maximum point to win without joker 400,650,1165
    val winForPointsDifferent: Boolean = true, //should game end will different between points
    // or not? team a - team b = 1165
    val firstTeamName: String = "",
    val secondTeamName: String = "",
    val hakemPointPromised: Int = 0,//specify how much of points will hakem take
    val hakemTeam: Int = 1,//specify that which Team gave the promise
    val hakemKeptPromise:Boolean = false, //did the hakem keep their promise ?
  // val hakemDidntPromise:Boolean = false,
    val sumFirstTeamTotalPoints:Int = 0, // full points of team1
    val sumSecondTeamTotalPoints:Int = 0, // full points of team2
    val winnerOfGame: String = "", // winner
    val sortType: SortType = SortType.ID,
    val isAddingNewGame : Boolean=false
)