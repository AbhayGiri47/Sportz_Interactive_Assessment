package com.example.sportzinteractive.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.sportzinteractive.model.INDNZMatchDetailsResponse
import com.example.sportzinteractive.model.Player
import com.example.sportzinteractive.model.SAPAKMatchDetailsResponse
import com.example.sportzinteractive.model.Team
import com.example.sportzinteractive.repository.MatchDetailsRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.lang.Exception

class MatchDetailsViewModel: ViewModel() {

    val repository = MatchDetailsRepository()
    val temp1Teams = mutableListOf<Team>()
    val temp2Teams = mutableListOf<Team>()


    private var _INDNZMatchDetails = MutableLiveData <INDNZMatchDetailsResponse>()
    val INDNZMatchDetail: LiveData<INDNZMatchDetailsResponse> = _INDNZMatchDetails

    private var _SAPAKMatchDetails = MutableLiveData <SAPAKMatchDetailsResponse>()
    val SAPAKMatchDetail: LiveData<SAPAKMatchDetailsResponse> = _SAPAKMatchDetails

    private var _teams= MutableLiveData<List<Team>>()
    val teams :LiveData<List<Team>> = _teams

    private var _teams1= MutableLiveData<List<Team>>()
    val teams1 :LiveData<List<Team>> = _teams1


    fun getINDNZMatchDetails(){
        viewModelScope.launch {
           try {
               val result=  repository.getINDNZMatchDetails()
               if (result.body() != null){
                   _INDNZMatchDetails.value = result.body()
                   parseMatchDetails(result.body()!!)
               }
           }catch (e:Exception){
               print(e.message)
           }

        }
    }

    fun getSAPAKMatchDetails(){
        viewModelScope.launch {
            val result=  repository.getSAPAkMatchDetails()
            if (result.body() != null){
                _SAPAKMatchDetails.value = result.body()
                parseMatchDetails(result.body()!!)
            }
        }
    }

    private fun parseMatchDetails(matchDetails: INDNZMatchDetailsResponse) {
        val teamListJSONObject = JSONObject(Gson().toJson(matchDetails.teams))

        val teamKeys: Iterator<String> = teamListJSONObject.keys()
        while (teamKeys.hasNext()) {
            val teamKey = teamKeys.next()
            val teamJsonObject =
                JSONObject(teamListJSONObject.getJSONObject(teamKey).toString())
            val players = mutableListOf<Player>()
            val playersListJsonObject = teamJsonObject.getJSONObject("Players")
            val playerKeys: Iterator<String> = playersListJsonObject.keys()
            while (playerKeys.hasNext()) {
                val playerKey = playerKeys.next()
                val player = Gson().fromJson(
                    playersListJsonObject.getJSONObject(playerKey).toString(),
                    Player::class.java
                )
                players.add(player.copy(teamName = teamJsonObject.getString("Name_Full")))
            }
            temp1Teams.add(
                Team(
                    teamName = teamJsonObject.getString("Name_Full"),
                    players = players
                )
            )
            Log.d(TAG, "parseMatchDetails: Teams => ${Gson().toJson(temp1Teams)}")
        }
        _teams.postValue(temp1Teams)
        _INDNZMatchDetails.postValue(matchDetails)
    }

    private fun parseMatchDetails(matchDetails: SAPAKMatchDetailsResponse) {
        val teamListJSONObject = JSONObject(Gson().toJson(matchDetails.teams))

        val teamKeys: Iterator<String> = teamListJSONObject.keys()
        while (teamKeys.hasNext()) {
            val teamKey = teamKeys.next()
            val teamJsonObject =
                JSONObject(teamListJSONObject.getJSONObject(teamKey).toString())
            val players = mutableListOf<Player>()
            val playersListJsonObject = teamJsonObject.getJSONObject("Players")
            val playerKeys: Iterator<String> = playersListJsonObject.keys()
            while (playerKeys.hasNext()) {
                val playerKey = playerKeys.next()
                val player = Gson().fromJson(
                    playersListJsonObject.getJSONObject(playerKey).toString(),
                    Player::class.java
                )
                players.add(player.copy(teamName = teamJsonObject.getString("Name_Full")))
            }
            temp2Teams.add(
                Team(
                    teamName = teamJsonObject.getString("Name_Full"),
                    players = players
                )
            )
            Log.d(TAG, "parseMatchDetails: Teams 2 => ${Gson().toJson(temp2Teams)}")
        }

        _teams1.postValue(temp2Teams)
        _SAPAKMatchDetails.postValue(matchDetails)
    }

    companion object {
        private const val TAG = "MatchDetailsViewModel"
    }
}