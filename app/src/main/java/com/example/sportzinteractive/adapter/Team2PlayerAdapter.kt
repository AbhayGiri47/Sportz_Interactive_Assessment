package com.example.sportzinteractive.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportzinteractive.R
import com.example.sportzinteractive.databinding.ItemPlayerDetailsBinding
import com.example.sportzinteractive.model.Player

class Team2PlayerAdapter(val onClick: (Player) -> Unit) :
    RecyclerView.Adapter<Team2PlayerAdapter.ViewHolder>() {

    var list = ArrayList<Player>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPlayerDetailsBinding.inflate(
            LayoutInflater.from(parent.getContext()),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (list.get(position).isCaptain && list.get(position).iskeeper) {
            holder.playerName.text = holder.itemView.context.resources.getString(
                R.string.cwk, list.get(position).nameFull
            )
        } else if (list.get(position).iskeeper) {
            holder.playerName.text = holder.itemView.context.resources.getString(
                R.string.wicketkeeper, list.get(position).nameFull
            )
        } else if (list.get(position).isCaptain) {
            holder.playerName.text = holder.itemView.context.resources.getString(
                R.string.captain, list.get(position).nameFull
            )
        } else {
            holder.playerName.text = list.get(position).nameFull
        }
        holder.playerName.setOnClickListener {
            onClick.invoke(list.get(position))
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(binding: ItemPlayerDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
        val playerName = binding.tvPlayerName

    }

    fun addToList(playerList: List<Player>) {
        list.clear()
        list.addAll(playerList)
        notifyDataSetChanged()
    }
}