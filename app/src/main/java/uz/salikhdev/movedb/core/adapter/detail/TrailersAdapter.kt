package uz.salikhdev.movedb.core.adapter.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.salikhdev.movedb.core.model.trailers.TrailersResult
import uz.salikhdev.movedb.databinding.ItemTrailerBinding

class TrailersAdapter : RecyclerView.Adapter<TrailersAdapter.ViewHolder>() {

    private val data = ArrayList<TrailersResult>()
    var onClickTrailer: ((url: String) -> Unit)? = null

    fun setData(data: List<TrailersResult>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemTrailerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: TrailersResult) {
            itemView.setOnClickListener {
                onClickTrailer?.invoke(data.key)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTrailerBinding.inflate(
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
