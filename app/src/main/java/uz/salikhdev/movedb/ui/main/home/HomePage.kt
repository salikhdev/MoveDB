package uz.salikhdev.movedb.ui.main.home

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.PageHomeBinding

class HomePage : BaseFragment(R.layout.page_home) {

    private val binding by viewBinding(PageHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View) {

        viewModel.getHomeInfo()

        observer()

    }

    private fun observer() {
        viewModel.homeLiveData.observe(viewLifecycleOwner) { homeResponse ->
            homeResponse?.let {
                Log.d("TAGfff", "observer: $it ")
            }
        }
    }

}