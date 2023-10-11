package com.farshadchalenges.bazimizi.database

import androidx.room.Entity
import androidx.room.PrimaryKey

// Fields we need to have
@Entity
data class Shelem(
    //Rules for each Game
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    //game with joker or without joker 165 , 200
    val jokOrNotJok: Boolean,
    //Total point with joker for each hand 200,230
    val totalPointWithJoker: Int,
    //Total point without joker for each hand 165,185
    val totalPointWithoutJoker: Int,
    //Trigger in case that if one of the teams take all points
    //without saying "SHELEM", what will happen?For WithJoker
    //equals to point they took for that hand, or 240 or 2x
    val fullPointWithJokerForEachHand: Int,
    //Trigger in case that if one of the teams take all points
    //without saying "SHELEM", what will happen?For WithJoker
    //equals to point they took for that hand, or 240 or 2x
    val fullPointWithoutJokerForEachHand: Int,
    //maximum point to win 600,800,1600
    val maxPointWithJoker: Int,
    //maximum point to win without joker 400,650,1165
    val maxPointWithoutJoker: Int,
    //should game end will different between points
    // or not? team a - team b = 1165
    val gamePointsDifferent: Boolean,

    val firstTeam: String,
    val secondTeam: String,

    //specify how much of points will hakem take
    val hakemPointPromised:Int,
    //specify that which Team gave the promise
    val hakemTeam: Int,
    //did the hakem keep their promise ?
    val hakemPromise: Boolean,
    // full points of team1
    val firstTeamTotalPoints: Int,
    // full points of team2
    val secondTeamTotalPoints: Int,
    // winner
    val winnerOfGame : String
)
