package com.example.sportzinteractive.model

import com.google.gson.annotations.SerializedName


data class SAPAKMatchDetailsResponse(

    @SerializedName("Matchdetail") var matchdetail: Matchdetail? = Matchdetail(),
    @SerializedName("Teams") var teams: TeamsSAPAK? = TeamsSAPAK(),

    )

data class TeamsSAPAK(
    @SerializedName("6") var teamPAK: TeamPAK? = TeamPAK(),
    @SerializedName("7") var teamSA: TeamSA? = TeamSA()
)

data class TeamPAK(

    @SerializedName("Name_Full") var nameFull: String? = null,
    @SerializedName("Name_Short") var nameShort: String? = null,
    @SerializedName("Players") var pakPlayers: PAKPlayers? = PAKPlayers()

)

data class TeamSA(

    @SerializedName("Name_Full") var nameFull: String? = null,
    @SerializedName("Name_Short") var nameShort: String? = null,
    @SerializedName("Players") var saPlayers: SAPlayers? = SAPlayers()

)

data class PAKPlayers(

    @SerializedName("2734")
    var player1: PlayerDetails? = PlayerDetails(),
    @SerializedName("3472")
    var player2: PlayerDetails? = PlayerDetails(),
    @SerializedName("4038")
    var player3: PlayerDetails? = PlayerDetails(),
    @SerializedName("57492")
    var player4: PlayerDetails? = PlayerDetails(),
    @SerializedName("59429")
    var player5: PlayerDetails? = PlayerDetails(),
    @SerializedName("63084")
    var player6: PlayerDetails? = PlayerDetails(),
    @SerializedName("64073")
    var player7: PlayerDetails? = PlayerDetails(),
    @SerializedName("64306")
    var player8: PlayerDetails? = PlayerDetails(),
    @SerializedName("64321")
    var player9: PlayerDetails? = PlayerDetails(),
    @SerializedName("65739")
    var player10: PlayerDetails? = PlayerDetails(),
    @SerializedName("66833")
    var player11: PlayerDetails? = PlayerDetails()

)


data class SAPlayers(

    @SerializedName("3667") var player1: PlayerDetails? = PlayerDetails(),
    @SerializedName("4356") var player2: PlayerDetails? = PlayerDetails(),
    @SerializedName("5313") var player3: PlayerDetails? = PlayerDetails(),
    @SerializedName("12518") var player4: PlayerDetails? = PlayerDetails(),
    @SerializedName("24669") var player5: PlayerDetails? = PlayerDetails(),
    @SerializedName("28891") var player6: PlayerDetails? = PlayerDetails(),
    @SerializedName("48191") var player7: PlayerDetails? = PlayerDetails(),
    @SerializedName("57458") var player8: PlayerDetails? = PlayerDetails(),
    @SerializedName("59736") var player9: PlayerDetails? = PlayerDetails(),
    @SerializedName("63611") var player10: PlayerDetails? = PlayerDetails(),
    @SerializedName("64221") var player11: PlayerDetails? = PlayerDetails()

)




