package com.example.sportzinteractive.ui

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sportzinteractive.R
import com.example.sportzinteractive.adapter.Team1PlayerAdapter
import com.example.sportzinteractive.adapter.Team2PlayerAdapter
import com.example.sportzinteractive.databinding.ActivityPlayerDetailsBinding
import com.example.sportzinteractive.viewmodel.MatchDetailsViewModel

class PlayerDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityPlayerDetailsBinding
    lateinit var viewModel: MatchDetailsViewModel

    lateinit var team1PlayerAdapter: Team1PlayerAdapter
    lateinit var team2PlayerAdapter: Team2PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_details)
        viewModel = ViewModelProvider(this).get(MatchDetailsViewModel::class.java)

        team1PlayerAdapter = Team1PlayerAdapter(
            onClick = {
                val dialog = Dialog(this)
                dialog.setContentView(R.layout.customdialog)

                if (it.bowling.average.equals("0")) {
                    val clBowling = dialog.findViewById<ConstraintLayout>(R.id.clBowlingDetails)
                    clBowling.visibility = View.GONE
                }

                if (it.batting.runs.equals("0")) {
                    val clBatting = dialog.findViewById<ConstraintLayout>(R.id.clBattingDetails)
                    clBatting.visibility = View.GONE
                }

                val battingStyle = dialog.findViewById<TextView>(R.id.tvStyle)
                battingStyle.text = resources.getString(R.string.Style, it.batting.style)

                val battingAverage = dialog.findViewById<TextView>(R.id.tvAverage)
                battingAverage.text = resources.getString(R.string.Average, it.batting.average)

                val battingStrikeRate = dialog.findViewById<TextView>(R.id.tvStrikeRate)
                battingStrikeRate.text =
                    resources.getString(R.string.StrikeRate, it.batting.strikeRate)

                val battingRuns = dialog.findViewById<TextView>(R.id.tvRuns)
                battingRuns.text = resources.getString(R.string.battingRuns, it.batting.runs)

                val bowlingStyle = dialog.findViewById<TextView>(R.id.tvBowlingStyle)
                bowlingStyle.text = resources.getString(R.string.Style, it.bowling.style)

                val bowlingAverage = dialog.findViewById<TextView>(R.id.tvBowlingAverage)
                bowlingAverage.text = resources.getString(R.string.Average, it.bowling.average)

                val economyRate = dialog.findViewById<TextView>(R.id.tvEconomyRate)
                economyRate.text = resources.getString(R.string.economyRate, it.bowling.economyRate)

                val wickets = dialog.findViewById<TextView>(R.id.tvWickets)
                wickets.text = resources.getString(R.string.wickets, it.bowling.wickets)

                dialog.show()
            }
        )
        team2PlayerAdapter = Team2PlayerAdapter(
            onClick = {
                val dialog = Dialog(this)
                dialog.setContentView(R.layout.customdialog)

                if (it.bowling.average.equals("0")) {
                    val clBowling = dialog.findViewById<ConstraintLayout>(R.id.clBowlingDetails)
                    clBowling.visibility = View.GONE
                }

                if (it.batting.runs.equals("0")) {
                    val clBatting = dialog.findViewById<ConstraintLayout>(R.id.clBattingDetails)
                    clBatting.visibility = View.GONE
                }

                val battingStyle = dialog.findViewById<TextView>(R.id.tvStyle)
                battingStyle.text = resources.getString(R.string.Style, it.batting.style)

                val battingAverage = dialog.findViewById<TextView>(R.id.tvAverage)
                battingAverage.text = resources.getString(R.string.Average, it.batting.average)

                val battingStrikeRate = dialog.findViewById<TextView>(R.id.tvStrikeRate)
                battingStrikeRate.text =
                    resources.getString(R.string.StrikeRate, it.batting.strikeRate)

                val battingRuns = dialog.findViewById<TextView>(R.id.tvRuns)
                battingRuns.text = resources.getString(R.string.battingRuns, it.batting.runs)

                val bowlingStyle = dialog.findViewById<TextView>(R.id.tvBowlingStyle)
                bowlingStyle.text = resources.getString(R.string.Style, it.bowling.style)

                val bowlingAverage = dialog.findViewById<TextView>(R.id.tvBowlingAverage)
                bowlingAverage.text = resources.getString(R.string.Average, it.bowling.average)

                val economyRate = dialog.findViewById<TextView>(R.id.tvEconomyRate)
                economyRate.text = resources.getString(R.string.economyRate, it.bowling.economyRate)

                val wickets = dialog.findViewById<TextView>(R.id.tvWickets)
                wickets.text = resources.getString(R.string.wickets, it.bowling.wickets)

                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.show()
            }
        )

        var teamName = ""

        if (intent != null) {
            teamName = intent.getStringExtra("teamName").toString()
        }


        viewModel.getINDNZMatchDetails()
        viewModel.getSAPAKMatchDetails()
        viewModel.INDNZMatchDetail.observe(this, Observer {


        })

        viewModel.apply {
            teams.observe(this@PlayerDetailsActivity) {
                if (teamName == "INDNZ") {
                    binding.tvTeam1Name.text = it[0].teamName
                    binding.tvTeam2Name.text = it[1].teamName

                    team1PlayerAdapter.addToList(it[0].players)
                    team2PlayerAdapter.addToList(it[1].players)

                }
            }

            teams1.observe(this@PlayerDetailsActivity) {
                if (teamName == "SAPAK") {
                    binding.tvTeam1Name.text = it[0].teamName
                    binding.tvTeam2Name.text = it[1].teamName

                    team1PlayerAdapter.addToList(it[0].players)
                    team2PlayerAdapter.addToList(it[1].players)

                }
            }
        }

        binding.rvTeam1PlayerDetails.adapter = team1PlayerAdapter
        binding.rvTeam2PlayerDetails.adapter = team2PlayerAdapter


    }

    companion object {
        private const val TAG = "PlayerDetailsActivity"
    }
}