package com.astrology.zodiacs.ui.activities

import HoroscopeDetailPageAdapter
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.astrology.zodiacs.R
import com.astrology.zodiacs.databinding.ActivityHoroscopeDetailBinding
import com.astrology.zodiacs.ui.viewmodel.HoroscopeDetailsViewModel
import com.skydoves.androidbottombar.BottomMenuItem
import com.skydoves.androidbottombar.OnMenuItemSelectedListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HoroscopeDetails : AppCompatActivity(){

    @Inject
    lateinit var viewModel: HoroscopeDetailsViewModel

    lateinit var viewBinding: ActivityHoroscopeDetailBinding

    private var zodiacSelected = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        backGroundColor()
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_horoscope_detail)

        zodiacSelected = intent.getStringExtra("zodiac").toString()

        with(viewBinding.viewpager) {
            adapter = HoroscopeDetailPageAdapter(supportFragmentManager)
            offscreenPageLimit = 3
        }

        viewBinding.androidBottomBar.addBottomMenuItems(mutableListOf(
            BottomMenuItem(this)
                .setTitle("Daily") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(10f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.daily)
                .setIconColorRes(R.color.white) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.white) // sets the color of the icon when selected/active.
                .setIconSize(20)

                .build(),

            BottomMenuItem(this)
                .setTitle("Hourly") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(10f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.weekly)
                .setIconColorRes(R.color.white) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.white) // sets the color of the icon when selected/active.
                .setIconSize(20)
                .build(),

            BottomMenuItem(this)
                .setTitle("Yearly") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(10f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.monthly)
                .setIconColorRes(R.color.white) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.white) // sets the color of the icon when selected/active.
                .setIconSize(20)
                .build(),

            BottomMenuItem(this)
                .setTitle("Yearly") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(10f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.yearly)
                .setIconColorRes(R.color.white) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.white) // sets the color of the icon when selected/active.
                .setIconSize(20)
                .build()
        ))

        viewBinding.androidBottomBar.onMenuItemSelectedListener = OnMenuItemSelectedListener { index, _, _ ->
            viewBinding.viewpager.currentItem = index
            viewBinding.androidBottomBar.dismissBadge(index)
        }

        viewBinding.androidBottomBar.setOnBottomMenuInitializedListener {
            viewBinding.androidBottomBar.bindViewPager(viewBinding.viewpager)
        }
    }

    fun backGroundColor() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.navigationBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.setBackgroundDrawableResource(R.color.black)
    }

    fun getZodiac(): String {
        return zodiacSelected
    }
}