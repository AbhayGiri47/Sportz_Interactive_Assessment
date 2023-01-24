package com.example.sportzinteractive.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sportzinteractive.R
import com.example.sportzinteractive.databinding.ActivityMatchDetailsBinding
import com.example.sportzinteractive.viewmodel.MatchDetailsViewModel

class MatchDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMatchDetailsBinding
    lateinit var viewModel: MatchDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_details)
        viewModel = ViewModelProvider(this).get(MatchDetailsViewModel::class.java)

        viewModel.getINDNZMatchDetails()
        viewModel.INDNZMatchDetail.observe(this, Observer {
            binding.tvSeriesNameINDNZ.text = it.matchdetail?.series?.tourName
            binding.tvDateINDNZ.text = it.matchdetail?.match?.date
            binding.tvTimeINDNZ.text = it.matchdetail?.match?.time
            binding.tvVenueINDNZ.text = it.matchdetail?.venue?.name

        })

        viewModel.teams.observe(this@MatchDetailsActivity){
            binding.tvTeam1NameINDNZ.text = it[0].teamName
            binding.tvTeam2NameINDNZ.text = it[1].teamName
        }

        viewModel.getSAPAKMatchDetails()
        viewModel.SAPAKMatchDetail.observe(this, Observer {

            binding.tvSeriesNameSAPAK.text = it.matchdetail?.series?.tourName

            binding.tvDateSAPAK.text = it.matchdetail?.match?.date
            binding.tvTimeSAPAK.text = it.matchdetail?.match?.time
            binding.tvVenueSAPAK.text = it.matchdetail?.venue?.name
        })

        viewModel.teams1.observe(this@MatchDetailsActivity){
            binding.tvTeam1NameSAPAK.text = it[0].teamName
            binding.tvTeam2NameSAPAK.text = it[1].teamName
        }

        binding.cvMatchDetailsINDNZ.setOnClickListener {
            val intent=Intent(this,PlayerDetailsActivity::class.java)
            intent.putExtra("teamName","INDNZ")
            startActivity(intent)
        }

        binding.cvMatchDetailsSAPAK.setOnClickListener {
            val intent=Intent(this,PlayerDetailsActivity::class.java)
            intent.putExtra("teamName","SAPAK")
            startActivity(intent)
        }
    }
}