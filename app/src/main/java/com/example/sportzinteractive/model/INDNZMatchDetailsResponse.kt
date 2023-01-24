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

data class TeamsINDNZ(

    @SerializedName("4") var teamIndia: TeamIndia? = TeamIndia(),
    @SerializedName("5") var teamNewZealand: TeamNewZealand? = TeamNewZealand()

)


data class TeamIndia(

    @SerializedName("Name_Full") var nameFull: String? = null,
    @SerializedName("Name_Short") var nameShort: String? = null,
    @SerializedName("Players") var teamIndiaPlayers: TeamIndiaPlayers? = TeamIndiaPlayers()

)

data class TeamNewZealand(

    @SerializedName("Name_Full") var nameFull: String? = null,
    @SerializedName("Name_Short") var nameShort: String? = null,
    @SerializedName("Players") var teamNewZealandPlayers: TeamNewZealandPlayers? = TeamNewZealandPlayers()

)

data class TeamIndiaPlayers(

    @SerializedName("3632")
    var player1: PlayerDetails? = PlayerDetails(),
    @SerializedName("3722")
    var player2: PlayerDetails? = PlayerDetails(),
    @SerializedName("3852")
    var player3: PlayerDetails? = PlayerDetails(),
    @SerializedName("4176")
    var player4: PlayerDetails? = PlayerDetails(),
    @SerializedName("4532")
    var player5: PlayerDetails? = PlayerDetails(),
    @SerializedName("5132")
    var player6: PlayerDetails? = PlayerDetails(),
    @SerializedName("9844")
    var player7: PlayerDetails? = PlayerDetails(),
    @SerializedName("63187")
    var player8: PlayerDetails? = PlayerDetails(),
    @SerializedName("63751")
    var player9: PlayerDetails? = PlayerDetails(),
    @SerializedName("65867")
    var player10: PlayerDetails? = PlayerDetails(),
    @SerializedName("66818")
    var player11: PlayerDetails? = PlayerDetails()

)


data class TeamNewZealandPlayers(

    @SerializedName("3752") var player1: PlayerDetails? = PlayerDetails(),
    @SerializedName("4330") var player2: PlayerDetails? = PlayerDetails(),
    @SerializedName("4338") var player3: PlayerDetails? = PlayerDetails(),
    @SerializedName("4964") var player4: PlayerDetails? = PlayerDetails(),
    @SerializedName("10167") var player5: PlayerDetails? = PlayerDetails(),
    @SerializedName("10172") var player6: PlayerDetails? = PlayerDetails(),
    @SerializedName("11703") var player7: PlayerDetails? = PlayerDetails(),
    @SerializedName("11706") var player8: PlayerDetails? = PlayerDetails(),
    @SerializedName("57594") var player9: PlayerDetails? = PlayerDetails(),
    @SerializedName("57903") var player10: PlayerDetails? = PlayerDetails(),
    @SerializedName("60544") var player11: PlayerDetails? = PlayerDetails()

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
    val isCaptain :Boolean = false
)

/*data class Batting(
    @SerializedName("Average")
    val average: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Strikerate")
    val strikerate: String,
    @SerializedName("Style")
    val style: String
)

data class Bowling(
    @SerializedName("Average")
    val average: String,
    @SerializedName("Economyrate")
    val economyrate: String,
    @SerializedName("Style")
    val style: String,
    @SerializedName("Wickets")
    val wickets: String
)*/

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


