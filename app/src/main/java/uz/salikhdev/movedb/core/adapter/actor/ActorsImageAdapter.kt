package uz.salikhdev.movedb.core.adapter.actor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.model.actor.actor_image.Profile
import uz.salikhdev.movedb.databinding.ItemActorBinding

class ActorsImageAdapter : RecyclerView.Adapter<ActorsImageAdapter.ViewHolder>() {
    private val data = ArrayList<Profile>()

    fun setData(data: List<Profile>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemActorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Profile) {
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500/${data.filePath}")
                .error(R.drawable.person_placeholder)
                .placeholder(R.drawable.person_placeholder)
                .into(binding.actorImage)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemActorBinding.inflate(
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