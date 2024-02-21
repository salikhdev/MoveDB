package uz.salikhdev.movedb.core.adapter.actor_multi.acting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.model.acting.acting.Crew
import uz.salikhdev.movedb.databinding.ItemActingBinding

class ActingAdapter : RecyclerView.Adapter<ActingAdapter.ViewHolder>() {

    private val data = ArrayList<Crew>()
    var onClickActing: ((id: Int) -> Unit)? = null

    fun setData(data: ArrayList<Crew>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemActingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Crew) {
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original/${data.posterPath}")
                .error(R.drawable.person_placeholder)
                .placeholder(R.drawable.person_placeholder)
                .into(binding.image)
            binding.title.text = data.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemActingBinding.inflate(
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
        holder.bindData(data[position])
    }


}
