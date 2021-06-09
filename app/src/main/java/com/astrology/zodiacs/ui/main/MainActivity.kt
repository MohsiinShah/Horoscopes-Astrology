package com.astrology.zodiacs.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.astrology.zodiacs.data.model.ActionItem

import com.astrology.zodiacs.ui.navigator.onClick
import com.astrology.zodiacs.R
import com.astrology.zodiacs.databinding.ActivityMainBinding
import com.astrology.zodiacs.ui.activities.HoroscopeDetails
import com.astrology.zodiacs.ui.adapter.MainAdapter

class MainActivity : AppCompatActivity(), onClick {

    lateinit var mainAdapter: MainAdapter

    var zodiacList = ArrayList<ActionItem>()

    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        backGroundColor()
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView(){

        viewBinding.horoscopeRecycler.layoutManager = GridLayoutManager(this, 3)
        viewBinding.horoscopeRecycler.isNestedScrollingEnabled = false;

        val zodiacArray = resources.getStringArray(R.array.zodiacs)
        for(element in zodiacArray){

            Log.d("Element",element)

            when(element){
                "Aries"->{
                    zodiacList.add(ActionItem(element, R.drawable.aries))
                }
                "Aquarius"->{
                    zodiacList.add(ActionItem(element, R.drawable.aquarius))

                }
                "Cancer"->{
                    zodiacList.add(ActionItem(element, R.drawable.cancer))

                }
                "Capricorn"->{
                    zodiacList.add(ActionItem(element, R.drawable.capricorn))

                }
                "Gemini"->{
                    zodiacList.add(ActionItem(element, R.drawable.gemini))

                }
                "Leo"->{
                    zodiacList.add(ActionItem(element, R.drawable.leo))

                }
                "Libra"->{
                    zodiacList.add(ActionItem(element, R.drawable.libra))

                }
                "Pisces"->{
                    zodiacList.add(ActionItem(element, R.drawable.pisces))

                }
                "Sagittarius"->{
                    zodiacList.add(ActionItem(element, R.drawable.sagittarius))

                }
                "Scorpio"->{
                    zodiacList.add(ActionItem(element, R.drawable.scorpio))

                }
                "Taurus"->{
                    zodiacList.add(ActionItem(element, R.drawable.taurus))

                }
                "Virgo"->{
                    zodiacList.add(ActionItem(element, R.drawable.virgo))

                }
            }
        }
        mainAdapter = MainAdapter( zodiacList, this)
        viewBinding.horoscopeRecycler.adapter = mainAdapter

    }

    fun backGroundColor() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.navigationBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.setBackgroundDrawableResource(R.color.transparent)
    }

    override fun onZodiacClick(data: ActionItem) {
        var intent = Intent(this, HoroscopeDetails::class.java)
        intent.putExtra("zodiac", data.zodiac)
        startActivity(intent)
    }
}