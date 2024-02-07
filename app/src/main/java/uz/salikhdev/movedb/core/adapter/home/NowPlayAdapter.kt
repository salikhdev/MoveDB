package uz.salikhdev.movedb.core.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.model.home.now_play.NowPlayResult
import uz.salikhdev.movedb.databinding.ItemNowShowingBinding

class NowPlayAdapter : RecyclerView.Adapter<NowPlayAdapter.ViewHolder>() {

    private val data = ArrayList<NowPlayResult>()

    fun setData(data: List<NowPlayResult>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemNowShowingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: NowPlayResult) {

            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original/${data.posterPath}")
                .error(R.drawable.person_placeholder)
                .placeholder(R.drawable.person_placeholder)
                .into(binding.image)

            binding.filmName.text = data.title
            binding.rating.text = String.format("%s/10 IMDb", data.voteAverage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNowShowingBinding.inflate(
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