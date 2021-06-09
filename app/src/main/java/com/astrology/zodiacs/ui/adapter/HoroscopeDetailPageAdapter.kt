import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.astrology.zodiacs.ui.fragments.DailyFragment
import com.astrology.zodiacs.ui.fragments.MonthlyFragment
import com.astrology.zodiacs.ui.fragments.WeeklyFragment
import com.astrology.zodiacs.ui.fragments.YearlyFragment

class HoroscopeDetailPageAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0-> DailyFragment()
            1 -> WeeklyFragment()
            2 -> MonthlyFragment()
            else -> YearlyFragment()
        }
    }

    override fun getCount() = 4
}