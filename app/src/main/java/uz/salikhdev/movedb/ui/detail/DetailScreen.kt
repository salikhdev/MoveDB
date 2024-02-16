package uz.salikhdev.movedb.ui.detail

import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.detail.ActorAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.core.room.entity.MovieEntity
import uz.salikhdev.movedb.databinding.ScreenDetailBinding
import uz.salikhdev.movedb.ui.main.MainScreenDirections

class DetailScreen : BaseFragment(R.layout.screen_detail) {


    private val binding by viewBinding(ScreenDetailBinding::bind)
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailScreenArgs by navArgs()
    private val actorAdapter by lazy { ActorAdapter() }
    val movie = args.movie
    private var isSave = false

    override fun onViewCreated(view: View) {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        viewModel.getDetail(args.id)
        viewModel.getActor(args.id)
        viewModel.getMoviesId(args.id)
        setAdapter()
        loadListener()
        observer()

    }

    private fun loadListener() {
        actorAdapter.actorClicked = { author ->
            findNavController().navigate(MainScreenDirections.actionMainScreenToActorScreen(author))
        }
        binding.save.setOnClickListener {
            if (isSave) {
                val data = MovieEntity(
                    id = movie!!.id,
                    title = movie.title,
                    rating = movie.rating,
                    language = movie.language,
                    genre = movie.genre,
                    publishedTime = movie.publishedTime,
                    budget = movie.budget,
                    status = movie.status,
                    overview = movie.overview,
                    image = movie.image
                )
                binding.save.setBackgroundResource(R.drawable.bottom_save_btn)
                viewModel.deleteData(data)
                Toast.makeText(context, "Deleted from favourites", Toast.LENGTH_SHORT).show()
            } else {
                val data = MovieEntity(
                    id = movie!!.id,
                    title = movie.title,
                    rating = movie.rating,
                    language = movie.language,
                    genre = movie.genre,
                    publishedTime = movie.publishedTime,
                    budget = movie.budget,
                    status = movie.status,
                    overview = movie.overview,
                    image = movie.image
                )
                binding.save.setBackgroundResource(R.drawable.full_save)
                viewModel.saveData(data)
                Toast.makeText(context, "Saved to favourites", Toast.LENGTH_SHORT).show()
            }
        }
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

        viewModel.haveDataInDB.observe(viewLifecycleOwner) {
            isSave = it
            if (it) {
                binding.save.setBackgroundResource(R.drawable.bottom_save_btn)
            } else {
                binding.save.setBackgroundResource(R.drawable.full_save)
            }
        }

    }

    override fun onStop() {
        super.onStop()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

}