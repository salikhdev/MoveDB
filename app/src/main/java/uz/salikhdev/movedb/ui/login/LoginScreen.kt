package uz.salikhdev.movedb.ui.login

import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.ScreenLoginBinding


class LoginScreen : BaseFragment(R.layout.screen_login) {

    private val binding by viewBinding(ScreenLoginBinding::bind)

    override fun onViewCreated(view: View) {


        binding.root.setOnClickListener {
            Toast.makeText(context, "aa", Toast.LENGTH_SHORT).show()
        }


    }


}