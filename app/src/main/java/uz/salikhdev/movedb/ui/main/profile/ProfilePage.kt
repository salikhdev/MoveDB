package uz.salikhdev.movedb.ui.main.profile

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.PageProfilBinding

class ProfilePage : BaseFragment(R.layout.page_profil) {

    private val binding by viewBinding(PageProfilBinding::bind)
    private val viewModel: ProfileViewModel by viewModels()
    override fun onViewCreated(view: View) {
        viewModel.getProfileDetail()
        Log.d("TAGaaaa", "onViewCreated: ")

        observer()
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

    }


}