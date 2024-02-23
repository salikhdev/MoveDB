package uz.salikhdev.movedb.ui.main.home

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.MediatorLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.home.MultiAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.core.model.home.now_play.NowPlayingResponse
import uz.salikhdev.movedb.core.model.home.popular.PopularResponse
import uz.salikhdev.movedb.core.util.gone
import uz.salikhdev.movedb.core.util.visible
import uz.salikhdev.movedb.databinding.PageHomeBinding
import uz.salikhdev.movedb.ui.main.MainScreenDirections


class HomePage : BaseFragment(R.layout.page_home) {

    private val binding by viewBinding(PageHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { MultiAdapter() }
    private val combinedLiveData = MediatorLiveData<Pair<NowPlayingResponse?, PopularResponse?>>()
    private var result1 = false
    private var result2 = false
    private var first = false
    override fun onViewCreated(view: View) {
        binding.progressBar.visible()
        setAdapter()
        loadListener()
        observer()
    }

    private fun loadListener() {
        adapter.onClickItem = { id ->
            findNavController().navigate(
                MainScreenDirections.actionMainScreenToDetailScreen(id)
            )
        }
        adapter.seeNowPlayingClick = {
            findNavController().navigate(
                MainScreenDirections.actionMainScreenToSeeMoreScreen()
            )
        }
        adapter.seePopularClick = {
            findNavController().navigate(MainScreenDirections.actionMainScreenToSeeMoreScreen())
        }

    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun observer() {

        binding.progressBar.visible()
        viewModel.getHomeNowPlaying()
        viewModel.getHomePopular()

        if (!result1) {
            combinedLiveData.addSource(viewModel.homeNowPlayingLiveData) { result ->
                combinedLiveData.value = Pair(result, combinedLiveData.value?.second)
            }
            result1 = true
        }

        if (!result2) {
            combinedLiveData.addSource(viewModel.homePopularLiveData) { result ->
                combinedLiveData.value = Pair(combinedLiveData.value?.first, result)
            }
            result2 = true
        }

        combinedLiveData.observe(viewLifecycleOwner) { combinedResult ->
            val result1 = combinedResult?.first
            val result2 = combinedResult?.second



            if (result1 != null && result2 != null) {
                if (!first) {
                    adapter.addData(result1)
                    adapter.addData(result2)
                    first = true
                }
                binding.progressBar.gone()
            }


        }


    }


}