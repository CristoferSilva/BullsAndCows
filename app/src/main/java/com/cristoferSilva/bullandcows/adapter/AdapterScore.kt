package com.cristoferSilva.bullandcows.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristoferSilva.bullandcows.databinding.ScoreItemBinding
import com.cristoferSilva.bullandcows.model.Score

class AdapterScore(private val context: Context, private val scoreList: MutableList<Score>): RecyclerView.Adapter<AdapterScore.ScoreViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        var itemList = ScoreItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ScoreViewHolder(itemList)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        holder.bullsNumber.text = scoreList[position].bullsNumber.toString()
        holder.cowsNumber.text = scoreList[position].cowsNumber.toString()
        holder.guessNumber.text = scoreList[position].guessNumber.toString()
    }

    override fun getItemCount()= scoreList.size

    inner class  ScoreViewHolder(binding: ScoreItemBinding): RecyclerView.ViewHolder(binding.root) {
        var cowsNumber = binding.cowsNumber
        var bullsNumber = binding.bullsNumber
        var guessNumber = binding.guessNumber
    }
}