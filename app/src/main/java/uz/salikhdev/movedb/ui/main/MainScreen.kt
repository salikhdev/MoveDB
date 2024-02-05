package uz.salikhdev.movedb.ui.main

import android.view.View
import android.view.WindowManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.MainScreenAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.ScreenMainBinding


class MainScreen : BaseFragment(R.layout.screen_main) {

    private val binding by viewBinding(ScreenMainBinding::bind)

    override fun onViewCreated(view: View) {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        setViewPager()

    }

    private fun setViewPager() {

        val adapter = MainScreenAdapter(lifecycle, childFragmentManager)

        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false
        binding.bottomBar.setOnItemSelectedListener {

            when (it) {
                0 -> binding.viewPager.setCurrentItem(0, false)
                1 -> binding.viewPager.setCurrentItem(1, false)
                2 -> binding.viewPager.setCurrentItem(2, false)
            }

        }


    }

}