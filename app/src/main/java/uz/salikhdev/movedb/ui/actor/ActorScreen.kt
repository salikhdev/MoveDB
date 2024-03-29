package uz.salikhdev.movedb.ui.actor

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.actor.ActingAdapter
import uz.salikhdev.movedb.core.adapter.actor.ActorsImageAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.core.util.ZoomOutPageTransformer
import uz.salikhdev.movedb.databinding.ScreenActorBinding

class ActorScreen : BaseFragment(R.layout.screen_actor) {

    private val binding by viewBinding(ScreenActorBinding::bind)
    private val adapterImage by lazy { ActorsImageAdapter() }
    private val adapterAction by lazy { ActingAdapter() }
    private val viewModel: ActorViewModel by viewModels()
    private val args: ActorScreenArgs by navArgs()
    override fun onViewCreated(view: View) {

        viewModel.getActorImages(args.id)
        viewModel.getActorDetail(args.id)
        viewModel.getActingFilms(args.id)
        setAdapter()
        observer()
        clickListener()
    }

    private fun setAdapter() {
        binding.viewPager.adapter = adapterImage
        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.clipChildren = false
        binding.viewPager.clipToPadding = false
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())

        binding.recyclerView.adapter = adapterAction
        binding.recyclerView.setHasFixedSize(true)

        adapterAction.onClickActing = {
            findNavController().navigate(ActorScreenDirections.actionActorScreenToDetailScreen(it))
        }

    }

    private fun observer() {

        viewModel.imagesLD.observe(viewLifecycleOwner) { response ->
            response?.let {
                adapterImage.setData(it.profiles)
            }
        }

        viewModel.detailLD.observe(viewLifecycleOwner) { response ->
            response?.let {
                binding.authorName.text = it.name
                binding.biography.text = it.biography
            }
        }

        viewModel.actingLD.observe(viewLifecycleOwner) { acting ->
            acting?.let {
                adapterAction.setData(it.crew)
            }
        }

    }


    private fun clickListener() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}