package com.farshadchalenges.bazimizi.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class ShelemViewModel(
    private val dao: ShelemDao,
) : ViewModel() {
    private val _sortType = MutableStateFlow(SortType.ID)
    private val _state = MutableStateFlow(ShelemState())
    private val _shelem = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                SortType.ID -> dao.getShelemHandsOrderedByID()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    val state = combine(_state, _shelem, _sortType) { state, shelems, sortType ->
        state.copy(
            sortType = sortType,
            shelem = shelems
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ShelemState())

    fun onEvent(event: ShelemEvent) {
        when (event) {
            ShelemEvent.SaveNewGame -> {
                val playWithJok = state.value.playWithJok
                val totalPointWithJok = state.value.totalPointWithJok
                val totalPointWithoutJok = state.value.totalPointWithoutJok
                val fullPointWithJokerForEachHand=state.value.fullPointWithJokerForEachHand
                val fullPointWithoutJokerForEachHand=state.value.fullPointWithoutJokerForEachHand
                val maxPointWithJoker = state.value.maxPointWithJoker
                val maxPointWithoutJoker = state.value.maxPointWithoutJoker
                val winForPointsDifference = state.value.winForPointsDifferent
                val firstTeamName = state.value.firstTeamName
                val secondTeamName = state.value.secondTeamName
                val hakemPointPromised = state.value.hakemPointPromised
                val hakemTeam = state.value.hakemTeam
                val hakemKeptPromise = state.value.hakemKeptPromise
                val sumFirstTEamTotalPoints = state.value.sumFirstTeamTotalPoints
                val sumSecondTeamTotalPoints = state.value.sumSecondTeamTotalPoints
                val winnerOfGame = state.value.winnerOfGame

                val shelem = Shelem(
                    jokOrNotJok = playWithJok,
                    totalPointWithJoker = totalPointWithJok,
                    totalPointWithoutJoker = totalPointWithoutJok,
                    fullPointWithJokerForEachHand = fullPointWithJokerForEachHand,
                    fullPointWithoutJokerForEachHand = fullPointWithoutJokerForEachHand,
                    maxPointWithJoker = maxPointWithJoker,
                    maxPointWithoutJoker = maxPointWithoutJoker,
                    winWithPointsDifference = winForPointsDifference,
                    firstTeamName = firstTeamName,
                    secondTeamName = secondTeamName,
                    hakemPointPromised = hakemPointPromised,
                    hakemTeam = hakemTeam,
                    hakemKeptPromise = hakemKeptPromise,
                    sumFirstTeamTotalPoints = sumFirstTEamTotalPoints,
                    sumSecondTeamTotalPoints = sumSecondTeamTotalPoints,
                    winnerOfGame = winnerOfGame
                )
                viewModelScope.launch {
                    dao.upsertNewGame(shelem)
                }
                _state.update {
                    it.copy(

                    )
                }
            }

            ShelemEvent.HakemKeptPromise -> {
                _state.update {
                    it.copy(
                        hakemKeptPromise = true
                    )
                }
            }

            ShelemEvent.HakemDidntKeptPromise -> {
                _state.update {
                    it.copy(
                        hakemKeptPromise = false
                    )
                }
            }

            ShelemEvent.PlayWithJok -> {
                _state.update {
                    it.copy(
                        playWithJok = true
                    )
                }
            }

            ShelemEvent.PlayWithoutJok -> {
                _state.update {
                    it.copy(
                        playWithJok = false
                    )
                }
            }

            is ShelemEvent.SetFirstTeam -> {
                _state.update {
                    it.copy(
                        firstTeamName = event.firstTeam
                    )
                }
            }

            is ShelemEvent.SetFullPointWithJokerForEachHand -> {
                _state.update {
                    it.copy(
                        fullPointWithJokerForEachHand = event.fullPointWithJokerForEachHand
                    )
                }
            }

            is ShelemEvent.SetFullPointWithoutJokerForEachHand -> {
                _state.update {
                    it.copy(
                        fullPointWithoutJokerForEachHand = event.fullPointWithoutJokerForEachHand
                    )
                }
            }

            is ShelemEvent.SetHakemPointPromised -> {
                _state.update {
                    it.copy(
                        hakemPointPromised = event.hakemPointPromised
                    )
                }
            }

            is ShelemEvent.SetHakemTeam -> {
                _state.update {
                    it.copy(
                        hakemTeam = event.hakemTeam //1 or 2
                    )
                }
            }

            is ShelemEvent.SetMaxPointWithJoker -> {
                _state.update {
                    it.copy(
                        maxPointWithJoker = event.maxPointWithJoker
                    )
                }
            }

            is ShelemEvent.SetMaxPointWithoutJoker -> {
                _state.update {
                    it.copy(
                        maxPointWithoutJoker = event.maxPointWithoutJoker
                    )
                }
            }

            is ShelemEvent.SetSecondTeam -> {
                _state.update {
                    it.copy(
                        secondTeamName = event.secondTeam
                    )
                }
            }

            is ShelemEvent.SetTotalPointWithJok -> {
                _state.update {
                    it.copy(
                        totalPointWithJok = event.totalPointWithJok
                    )
                }
            }

            is ShelemEvent.SetTotalPointWithoutJok -> {
                _state.update {
                    it.copy(
                        totalPointWithoutJok = event.totalPointWithoutJok
                    )
                }
            }

            is ShelemEvent.SetWinnerOfGame -> {
                _state.update {
                    it.copy(
                        winnerOfGame = event.winnerOfGame
                    )
                }
            }

            is ShelemEvent.SumFirstTeamPoints -> {
                _state.update {
                    it.copy(
                        sumFirstTeamTotalPoints = event.sumFirstTeamPoints
                    )
                }
            }

            is ShelemEvent.SumSecondTeamPoints -> {
                _state.update {
                    it.copy(
                        sumSecondTeamTotalPoints = event.sumSecondTeamPoints
                    )
                }
            }

            ShelemEvent.WinForPointDifference -> {
                _state.update {
                    it.copy(
                        winForPointsDifferent = false
                    )
                }
            }


        }
    }

}