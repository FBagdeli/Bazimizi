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
            ShelemEvent.HakemKeptPromise -> {
                _state.update {
                    it.copy(
                    hakemPromise = true
                    )
                }
            }

            ShelemEvent.PlayWithJokOrNotJok -> TODO()
            is ShelemEvent.SetFirstTeam -> TODO()
            is ShelemEvent.SetFullPointWithJokerForEachHand -> TODO()
            is ShelemEvent.SetFullPointWithoutJokerForEachHand -> TODO()
            is ShelemEvent.SetHakemPointPromised -> TODO()
            is ShelemEvent.SetHakemTeam -> TODO()
            is ShelemEvent.SetMaxPointWithJoker -> TODO()
            is ShelemEvent.SetMaxPointWithoutJoker -> TODO()
            is ShelemEvent.SetSecondTeam -> TODO()
            is ShelemEvent.SetTotalPointWithJok -> TODO()
            is ShelemEvent.SetTotalPointWithoutJok -> TODO()
            is ShelemEvent.SetWinnerOfGame -> TODO()
            is ShelemEvent.SumFirstTeamPoints -> TODO()
            is ShelemEvent.SumSecondTeamPoints -> TODO()
            ShelemEvent.WinForPointDifference -> TODO()
            ShelemEvent.HakemDidntKeptPromise -> TODO()
        }
    }

}