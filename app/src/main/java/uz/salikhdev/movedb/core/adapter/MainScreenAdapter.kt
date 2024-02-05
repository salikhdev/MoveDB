package uz.salikhdev.movedb.core.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.salikhdev.movedb.ui.main.home.HomePage
import uz.salikhdev.movedb.ui.main.profile.ProfilePage
import uz.salikhdev.movedb.ui.main.save.SavePage

class MainScreenAdapter(lf: Lifecycle, fm: FragmentManager) : FragmentStateAdapter(fm, lf) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomePage()
            1 -> SavePage()
            else -> ProfilePage()
        }
    }
}