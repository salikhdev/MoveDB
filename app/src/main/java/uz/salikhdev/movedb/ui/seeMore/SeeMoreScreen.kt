package uz.salikhdev.movedb.ui.seeMore

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.seeMore.SeeMoreAdapter
import uz.salikhdev.movedb.core.adapter.seeMore.SeePopularAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.ScreenSeeMoreBinding

class SeeMoreScreen : BaseFragment(R.layout.screen_see_more) {

    private val binding by lazy { ScreenSeeMoreBinding.inflate(layoutInflater) }
    private val viewModel: SeeMoreViewModel by viewModels()
    private val adapter by lazy { SeeMoreAdapter() }
    private val adapter2 by lazy { SeePopularAdapter() }
    override fun onViewCreated(view: View) {
        setAdapter()
        clickListener()
        observe()
    }

    private fun clickListener() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observe() {
        adapter.nextPage = {
            viewModel.getNowPlaying()
        }
        viewModel.nowPlayingLD.observe(viewLifecycleOwner) {
            adapter.addData(it!!.nowPlayResults)
        }

    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
    }


}