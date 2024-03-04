package uz.salikhdev.movedb.ui.seeMore

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.seeMore.SeeMoreAdapter
import uz.salikhdev.movedb.core.adapter.seeMore.SeePopularAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.core.util.NOW_PLAY
import uz.salikhdev.movedb.core.util.gone
import uz.salikhdev.movedb.core.util.visible
import uz.salikhdev.movedb.databinding.ScreenSeeMoreBinding

class SeeMoreScreen : BaseFragment(R.layout.screen_see_more) {

    private val binding by viewBinding(ScreenSeeMoreBinding::bind)
    private val viewModel: SeeMoreViewModel by viewModels()
    private val args: SeeMoreScreenArgs by navArgs()
    private val adapterNow by lazy { SeeMoreAdapter() }
    private val adapterPopular by lazy { SeePopularAdapter() }
    private var isLoad = false
    override fun onViewCreated(view: View) {

        observe()
        binding.progressBar.visible()
        if (args.type == NOW_PLAY) {
            binding.recyclerView.adapter = adapterNow
            viewModel.getNowPlaying()
        } else {
            binding.recyclerView.adapter = adapterPopular
            viewModel.getPopular()

        }

        setListener()

    }

    private fun setListener() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        adapterNow.nextPage = {
            if (!isLoad) {
                viewModel.getNowPlaying()
                isLoad = true
            }
        }
        adapterPopular.nextPage = {
            if (!isLoad) {
                viewModel.getPopular()
                isLoad = true
            }
        }

        adapterPopular.onClick = {
            findNavController().navigate(
                SeeMoreScreenDirections.actionSeeMoreScreenToDetailScreen(
                    it
                )
            )
        }
        adapterNow.onClick = {
            findNavController().navigate(
                SeeMoreScreenDirections.actionSeeMoreScreenToDetailScreen(
                    it
                )
            )
        }


    }

    private fun observe() {
        viewModel.nowPlayingLD.observe(viewLifecycleOwner) {
            it?.let {
                adapterNow.addData(it.nowPlayResults)
            }
            binding.progressBar.gone()
            isLoad = false
        }

        viewModel.popularLD.observe(viewLifecycleOwner) {
            it?.let {
                adapterPopular.addData(it.popularResults)
            }
            binding.progressBar.gone()
            isLoad = false
        }

    }


}