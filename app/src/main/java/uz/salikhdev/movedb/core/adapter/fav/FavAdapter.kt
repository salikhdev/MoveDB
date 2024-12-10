package uz.salikhdev.movedb.core.adapter.fav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.room.entity.MovieEntity
import uz.salikhdev.movedb.core.util.getGenre
import uz.salikhdev.movedb.databinding.ItemPopularBinding

class FavAdapter : RecyclerView.Adapter<FavAdapter.ViewHolder>() {

    private val data = ArrayList<MovieEntity>()
    var onClickSave: ((id: Int) -> Unit)? = null

    fun setData(data: List<MovieEntity>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemPopularBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: MovieEntity) {

            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original/${data.image}")
                .error(R.drawable.person_placeholder)
                .placeholder(R.drawable.person_placeholder)
                .into(binding.image)

            binding.filmName.text = data.title
            binding.rating.text = String.format("%s/10 IMDb", data.rating)
            binding.date.text = data.publishedTime

            binding.genre.text.let {
                binding.genre.text = getGenre(data.genre!!.toInt())
            }


            itemView.setOnClickListener {
                onClickSave?.invoke(data.id)
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