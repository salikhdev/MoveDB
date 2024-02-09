package uz.salikhdev.movedb.core.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.salikhdev.movedb.core.model.home.BaseData
import uz.salikhdev.movedb.core.model.home.now_play.NowPlayingResponse
import uz.salikhdev.movedb.core.model.home.popular.PopularResponse
import uz.salikhdev.movedb.databinding.ItemHomeParentBinding

class MultiAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<BaseData>()
    var onClickItem: ((id: Int) -> Unit)? = null
    fun setData(data: ArrayList<BaseData>) {
        this.data.clear()
        data.sortBy { it.getType() }
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(data: BaseData) {
        this.data.add(data)
        this.data.sortBy { it.getType() }
        notifyItemInserted(this.data.size)
    }

    fun clearData() {
        this.data.clear()
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    inner class NowPlayViewHolder(private val binding: ItemHomeParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter by lazy { NowPlayAdapter() }
        fun bindData(data: NowPlayingResponse) {

            binding.textView.text = "Now Playing"
            binding.parentRecycler.adapter = adapter
            binding.parentRecycler.layoutManager =
                LinearLayoutManager(binding.parentRecycler.context, RecyclerView.HORIZONTAL, false)
            binding.parentRecycler.setHasFixedSize(true)
            adapter.setData(data.nowPlayResults)

            adapter.onClickNowPlay = {
                onClickItem?.invoke(it)
            }


        }

    }

    inner class PopularViewHolder(private val binding: ItemHomeParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter by lazy { PopularAdapter() }
        fun bindData(data: PopularResponse) {

            binding.textView.text = "Popular"

            binding.parentRecycler.adapter = adapter
            binding.parentRecycler.layoutManager =
                LinearLayoutManager(binding.parentRecycler.context, RecyclerView.VERTICAL, false)
            binding.parentRecycler.setHasFixedSize(true)
            adapter.setData(data.popularResults)

            adapter.onClickPopular = {
                onClickItem?.invoke(it)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BaseData.NOW_PLAYING -> {
                NowPlayViewHolder(
                    ItemHomeParentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                PopularViewHolder(
                    ItemHomeParentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (getItemViewType(position)) {
            BaseData.NOW_PLAYING -> {
                (holder as NowPlayViewHolder).bindData(data[position] as NowPlayingResponse)
            }

            else -> {
                (holder as PopularViewHolder).bindData(data[position] as PopularResponse)
            }
        }


    }


}