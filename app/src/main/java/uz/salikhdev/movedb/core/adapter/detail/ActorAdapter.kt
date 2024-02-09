package uz.salikhdev.movedb.core.adapter.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.model.actor.Cast
import uz.salikhdev.movedb.databinding.ItemAuthorBinding

class ActorAdapter : RecyclerView.Adapter<ActorAdapter.ViewHolder>() {

    private val data = ArrayList<Cast>()

    fun setData(data: List<Cast>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Cast) {

            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original/${data.profilePath}")
                .error(R.drawable.person_placeholder)
                .placeholder(R.drawable.person_placeholder)
                .into(binding.image)

            binding.name.text = data.originalName


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAuthorBinding.inflate(
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