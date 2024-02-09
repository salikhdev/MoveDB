package uz.salikhdev.movedb.core.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.model.home.popular.PopularResult
import uz.salikhdev.movedb.core.util.getGenre
import uz.salikhdev.movedb.databinding.ItemPopularBinding
import java.util.Collections

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    private val data = ArrayList<PopularResult>()
    var onClickPopular: ((id: Int) -> Unit)? = null

    fun setData(data: List<PopularResult>) {
        this.data.clear()
        Collections.shuffle(data)
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemPopularBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: PopularResult) {

            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original/${data.posterPath}")
                .error(R.drawable.person_placeholder)
                .placeholder(R.drawable.person_placeholder)
                .into(binding.image)

            binding.filmName.text = data.title
            binding.rating.text = String.format("%s/10 IMDb", data.voteAverage)
            binding.date.text = data.releaseDate
            binding.genre.text = getGenre(data.genreIds[0])

            itemView.setOnClickListener {
                onClickPopular?.invoke(data.id)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPopularBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data = data[position])
    }
}