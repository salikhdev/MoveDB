package uz.salikhdev.movedb.ui.detail

import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.detail.ActorAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.databinding.ScreenDetailBinding

class DetailScreen : BaseFragment(R.layout.screen_detail) {


    private val binding by viewBinding(ScreenDetailBinding::bind)
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailScreenArgs by navArgs()
    private val actorAdapter by lazy { ActorAdapter() }

    override fun onViewCreated(view: View) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        viewModel.getDetail(args.id)
        viewModel.getActor(args.id)
        setAdapter()
        observer()

    }

    private fun setAdapter() {
        binding.recyclerViewActors.adapter = actorAdapter
        binding.recyclerViewActors.setHasFixedSize(true)
    }

    private fun observer() {

        viewModel.detailLD.observe(viewLifecycleOwner) { detail ->
            detail?.let {

                Glide.with(requireActivity())
                    .load("https://image.tmdb.org/t/p/original${it.backdropPath}")
                    .into(binding.backImage)

                Glide.with(requireActivity())
                    .load("https://image.tmdb.org/t/p/original${it.posterPath}")
                    .into(binding.littleImage)

                binding.title.text = it.title
                binding.publishedTime.text = "Date\n${it.releaseDate}"
                binding.discription.text = it.overview
                binding.budjet.text = "Revenue\n${it.revenue}$"
                binding.rating.text = it.voteAverage.toInt().toString()
                binding.status.text = "Stastus\n${it.status}"
                binding.genre.text = it.genres[0].name
                binding.language.text = it.originalLanguage.uppercase()
            }
        }
        viewModel.actorLD.observe(viewLifecycleOwner) { actors ->
            actors?.let {
                actorAdapter.setData(it.cast)
            }
        }

    }


    override fun onStop() {
        super.onStop()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

}