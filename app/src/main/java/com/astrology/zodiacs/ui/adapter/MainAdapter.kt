package com.astrology.zodiacs.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.astrology.zodiacs.data.model.ActionItem
import com.astrology.zodiacs.ui.navigator.onClick
import com.astrology.zodiacs.R
import com.bumptech.glide.Glide
import com.skydoves.elasticviews.ElasticLayout


class MainAdapter constructor(
    private val zodiacList: ArrayList<ActionItem>,
    private val onClick: onClick
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.horoscope_item, parent, false)
        )
    }

    override fun getItemCount(): Int {

        return zodiacList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.zodiac.text = zodiacList[position].zodiac
            Glide.with(holder.zodiacSign.context)
                .load(zodiacList[position].drawable)
                .into(holder.zodiacSign)

        holder.cardView.setOnClickListener{

            onClick.onZodiacClick(zodiacList[position])
        }
    }

    fun getPrice(position: Int): String{
       return zodiacList[position].zodiac
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var zodiac: TextView = view.findViewById(R.id.zodiacText) as TextView
        var zodiacSign: ImageView= view.findViewById(R.id.zodiacSign) as ImageView
        var cardView: ElasticLayout = view.findViewById(R.id.cardView) as ElasticLayout

    }
}