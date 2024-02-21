package uz.salikhdev.movedb.ui.main.save

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.fav.FavAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.PageSaveBinding
import uz.salikhdev.movedb.ui.main.MainScreenDirections

class SavePage : BaseFragment(R.layout.page_save) {

    private val binding by viewBinding(PageSaveBinding::bind)
    private val viewModel: SaveViewModel by viewModels()
    private val adapter by lazy { FavAdapter() }
    override fun onViewCreated(view: View) {
        setAdapter()
        observe()
        setListener()
    }

    private fun observe() {

        viewModel.getMovies()

        viewModel.saveLD.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

    }

    private fun setListener() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        adapter.onClickSave = {
            findNavController().navigate(MainScreenDirections.actionMainScreenToDetailScreen(it))
        }

    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
    }

}