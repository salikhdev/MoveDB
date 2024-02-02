package uz.salikhdev.movedb.ui.login

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.core.model.login.LoginRequest
import uz.salikhdev.movedb.databinding.ScreenLoginBinding


class LoginScreen : BaseFragment(R.layout.screen_login) {

    private val binding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels()
    private var token: String? = null

    override fun onViewCreated(view: View) {
        viewModel.getToken()

        setListener()
        observer()

    }

    private fun setListener() {

        binding.loginBtn.setOnClickListener {

            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (username.isEmpty() || username.isBlank()) {
                Toast.makeText(context, "Usernameni To'ldiring", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.isBlank()) {
                Toast.makeText(context, "Passwordni To'ldiring", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            token?.let {
                val body = LoginRequest(password, it, username)
                viewModel.login(body)
                binding.loginBtn.isGone = true
                binding.progressBar.isVisible = true
            }

        }


    }

    private fun observer() {

        viewModel.tokenLD.observe(viewLifecycleOwner) {
            token = it
        }

        viewModel.loginLD.observe(viewLifecycleOwner) {

            viewModel.saveTokenToStorage(it.requestToken)
            Toast.makeText(context, "Login qilindi", Toast.LENGTH_SHORT).show()

        }

        viewModel.errorLD.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            Log.d("TAGaaa", "observer:$it ")
            binding.loginBtn.isVisible = true
            binding.progressBar.isGone = true
        }


    }


}