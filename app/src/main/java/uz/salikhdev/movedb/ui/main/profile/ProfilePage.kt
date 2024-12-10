package uz.salikhdev.movedb.ui.main.profile

import android.app.AlertDialog
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.PageProfilBinding
import uz.salikhdev.movedb.ui.main.MainScreenDirections

class ProfilePage : BaseFragment(R.layout.page_profil) {

    private val binding by viewBinding(PageProfilBinding::bind)
    private val viewModel: ProfileViewModel by viewModels()
    override fun onViewCreated(view: View) {
        viewModel.getProfileDetail()
        setListener()
        observer()

    }

    private fun setListener() {

        binding.logOut.setOnClickListener {

            AlertDialog.Builder(requireContext())
                .setIcon(R.drawable.log)
                .setTitle("Log Out")
                .setMessage("Do you want log out ?")
                .setPositiveButton("Yes") { d, _ ->
                    viewModel.logOut()
                    d.dismiss()
                }
                .setNegativeButton("No") { d, _ ->
                    d.cancel()
                }
                .show()

        }
        /*binding.back.setOnClickListener {
            findNavController().popBackStack()
        }*/

    }

    private fun observer() {
        viewModel.profileDetailLD.observe(viewLifecycleOwner) { data ->

            data?.let {

                Glide.with(requireActivity())
                    .load("https://image.tmdb.org/t/p/w500${it.avatar.tmdb.avatarPath}")
                    .placeholder(R.drawable.person_placeholder)
                    .error(R.drawable.person_placeholder)
                    .into(binding.userProfilePhoto)
                binding.userName.text = it.username

            }

        }
        viewModel.logOutLD.observe(viewLifecycleOwner) {

            it?.let { message ->
                if (message.success) {
                    viewModel.isFirstAndCleaCache()
                    findNavController().navigate(MainScreenDirections.actionMainScreenToLoginScreen())
                }
            }

        }
    }


}