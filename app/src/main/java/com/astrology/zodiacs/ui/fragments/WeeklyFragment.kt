package com.astrology.zodiacs.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.astrology.zodiacs.R
import com.astrology.zodiacs.databinding.DailyFragmentBinding
import com.astrology.zodiacs.databinding.WeeklyFragmentBinding
import com.astrology.zodiacs.ui.activities.HoroscopeDetails
import com.astrology.zodiacs.ui.viewmodel.DailyViewModel
import com.astrology.zodiacs.ui.viewmodel.WeeklyViewModel
import com.astrology.zodiacs.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeeklyFragment : Fragment() {

    @Inject
    lateinit var viewModel: WeeklyViewModel

    private lateinit var viewBinding: WeeklyFragmentBinding
    private var zodiacSelected: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.weekly_fragment, container, false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity: HoroscopeDetails = activity as HoroscopeDetails
        zodiacSelected = activity.getZodiac()
        viewBinding.signDetails.setTexts(R.array.ariesDetails)
        viewBinding.horoscope.movementMethod = ScrollingMovementMethod()
        setupUpperLayout()
        setupObservers()
    }

    fun setupUpperLayout() {

        when (zodiacSelected) {
            "Aries" -> {
                viewBinding.signDetails.setTexts(R.array.ariesDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.ariesresult)
            }
            "Aquarius" -> {
                viewBinding.signDetails.setTexts(R.array.aquariusDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.aquariusresult)

            }
            "Cancer" -> {
                viewBinding.signDetails.setTexts(R.array.cancerDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.cancerresult)

            }
            "Capricorn" -> {
                viewBinding.signDetails.setTexts(R.array.capricornDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.capricornresult)

            }
            "Gemini" -> {
                viewBinding.signDetails.setTexts(R.array.geminiDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.geminiresult)

            }
            "Leo" -> {
                viewBinding.signDetails.setTexts(R.array.leoDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.leoresult)

            }
            "Libra" -> {
                viewBinding.signDetails.setTexts(R.array.libraDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.libraresult)

            }
            "Pisces" -> {
                viewBinding.signDetails.setTexts(R.array.piscesDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.piscesresult)

            }
            "Sagittarius" -> {
                viewBinding.signDetails.setTexts(R.array.sagittariusDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.sagitariusresult)

            }
            "Scorpio" -> {
                viewBinding.signDetails.setTexts(R.array.scorpioDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.scorpioresult)

            }
            "Taurus" -> {
                viewBinding.signDetails.setTexts(R.array.taurusDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.taurusresult)

            }
            "Virgo" -> {
                viewBinding.signDetails.setTexts(R.array.virgoDetails)
                viewBinding.sign.setBackgroundResource(R.drawable.virgoresult)

            }
        }
    }

    private fun setupObservers() {
        viewModel.getHoroscope(zodiacSelected).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        viewBinding.progressBar.visibility = View.GONE
                        viewBinding.horoscope.text = it.data?.horoscope

                    }
                    Status.ERROR -> {
                        viewBinding.progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        viewBinding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}