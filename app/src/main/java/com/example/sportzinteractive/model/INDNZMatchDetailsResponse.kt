package com.example.sportzinteractive.model

import com.google.gson.annotations.SerializedName


data class INDNZMatchDetailsResponse(

    @SerializedName("Matchdetail") var matchdetail: Matchdetail? = Matchdetail(),
    @SerializedName("Teams") var teams: Any

)

data class Matchdetail(

    @SerializedName("Team_Home") var teamHome: String? = null,
    @SerializedName("Team_Away") var teamAway: String? = null,
    @SerializedName("Match") var match: Match? = Match(),
    @SerializedName("Series") var series: Series? = Series(),
    @SerializedName("Venue") var venue: Venue? = Venue(),
)

data class Match(

    @SerializedName("Date") var date: String? = null,
    @SerializedName("Time") var time: String? = null

)

data class Series(
    @SerializedName("Tour_Name") var tourName: String? = null

)

data class Venue(

    @SerializedName("Name") var name: String? = null

)

data class Team(
    val teamName: String,
    val players: List<Player>
)

data class Player(
    @SerializedName("Batting")
    val batting: Batting,
    @SerializedName("Bowling")
    val bowling: Bowling,
    @SerializedName("Iskeeper")
    val iskeeper: Boolean = false,
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Position")
    val position: String,
    val teamName: String,
    @SerializedName("Iscaptain")
    val isCaptain: Boolean = false
)

data class PlayerDetails(

    @SerializedName("Position") var position: String? = null,
    @SerializedName("Name_Full") var nameFull: String? = null,
    @SerializedName("Iskeeper") var isKeeper: Boolean? = null,
    @SerializedName("Iscaptain") var isCaptain: Boolean? = null,
    @SerializedName("Batting") var batting: Batting? = Batting(),
    @SerializedName("Bowling") var bowling: Bowling? = Bowling()

)

data class Batting(

    @SerializedName("Style") var style: String? = null,
    @SerializedName("Average") var average: String? = null,
    @SerializedName("Strikerate") var strikeRate: String? = null,
    @SerializedName("Runs") var runs: String? = null

)

data class Bowling(

    @SerializedName("Style") var style: String? = null,
    @SerializedName("Average") var average: String? = null,
    @SerializedName("Economyrate") var economyRate: String? = null,
    @SerializedName("Wickets") var wickets: String? = null

)


