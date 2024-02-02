package uz.salikhdev.movedb.ui.splash

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.delay
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.ScreenSplashBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseFragment(R.layout.screen_splash) {

    private val binding by viewBinding(ScreenSplashBinding::bind)

    override fun onViewCreated(view: View) {
        Glide
            .with(this)
            .load(binding.image)
            .centerCrop()
            .into(binding.image)

        lifecycleScope.launchWhenCreated {
            delay(3000)
        }

    }


}