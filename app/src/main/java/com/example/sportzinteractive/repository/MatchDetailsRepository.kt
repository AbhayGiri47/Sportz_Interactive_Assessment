package com.example.sportzinteractive.repository

import com.example.sportzinteractive.network.RetrofitInterface

class MatchDetailsRepository {

    suspend fun getINDNZMatchDetails ()= RetrofitInterface.getInstance().getINDNZMatchDetails()

    suspend fun getSAPAkMatchDetails ()= RetrofitInterface.getInstance().getSAPAKMatchDetails()
}