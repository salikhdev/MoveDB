package uz.salikhdev.movedb.ui.splash

import android.annotation.SuppressLint
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.ScreenSplashBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseFragment(R.layout.screen_splash) {

    private val binding by viewBinding(ScreenSplashBinding::bind)

    override fun onViewCreated(view: View) {



    }


}