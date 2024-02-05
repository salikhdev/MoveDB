package uz.salikhdev.movedb.ui.profil

import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.PageProfilBinding

class ProfilePage : BaseFragment(R.layout.page_profil) {

    private val binding by viewBinding(PageProfilBinding::bind)
    override fun onViewCreated(view: View) {
        setListener()
    }

    private fun setListener() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}