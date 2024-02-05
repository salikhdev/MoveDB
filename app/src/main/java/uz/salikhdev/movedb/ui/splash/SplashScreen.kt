package uz.salikhdev.movedb.ui.splash

import android.annotation.SuppressLint
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.delay
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.ScreenSplashBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseFragment(R.layout.screen_splash) {

    private val binding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        viewModel.getIsFirs()

        observer()

    }

    private fun observer() {

        viewModel.isFirsLD.observe(viewLifecycleOwner) { natija ->

            lifecycleScope.launchWhenCreated {
                delay(1500)

                if (natija) {
                    findNavController().navigate(SplashScreenDirections.actionSplashScreenToLoginScreen())
                } else {
                    findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
                }

            }

        }

    }


}