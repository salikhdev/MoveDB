package uz.salikhdev.movedb.ui.main.home

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.MediatorLiveData
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


class HomePage : BaseFragment(R.layout.page_home) {

    private val binding by viewBinding(PageHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { MultiAdapter() }
    private val combinedLiveData = MediatorLiveData<Pair<NowPlayingResponse?, PopularResponse?>>()
    override fun onViewCreated(view: View) {
        binding.progressBar.visible()
        setAdapter()
        observer()
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun observer() {

        viewModel.getHomeNowPlaying()
        viewModel.getHomePopular()

        combinedLiveData.addSource(viewModel.homeNowPlayingLiveData) { result1 ->
            combinedLiveData.value = Pair(result1, combinedLiveData.value?.second)
        }

        combinedLiveData.addSource(viewModel.homePopularLiveData) { result2 ->
            combinedLiveData.value = Pair(combinedLiveData.value?.first, result2)
        }

        combinedLiveData.observe(viewLifecycleOwner) { combinedResult ->
            val result1 = combinedResult?.first
            val result2 = combinedResult?.second

            if (result1 != null && result2 != null) {
                adapter.addData(result1)
                adapter.addData(result2)
                binding.progressBar.gone()
            }


        }


    }

}