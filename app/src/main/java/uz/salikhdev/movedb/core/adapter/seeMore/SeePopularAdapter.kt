package uz.salikhdev.movedb.core.adapter.seeMore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.model.home.popular.PopularResult
import uz.salikhdev.movedb.core.util.getGenre
import uz.salikhdev.movedb.databinding.ItemPopularBinding

class SeePopularAdapter : RecyclerView.Adapter<SeePopularAdapter.ViewHolder>() {


    private val data = ArrayList<PopularResult>()
    var onClick: ((id: Int) -> Unit)? = null
    var nextPage: (() -> Unit)? = null

    fun setData(data: List<PopularResult>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(data: List<PopularResult>) {
        this.data.addAll(data)
        notifyItemInserted(this.data.size)
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
            data.genreIds.let {
                binding.genre.text = getGenre(it[0])
            }
            itemView.setOnClickListener {
                onClick?.invoke(data.id)
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
        if (data.size - 4 <= position) {
            nextPage?.invoke()
        }
        holder.bindData(data[position])
    }

}