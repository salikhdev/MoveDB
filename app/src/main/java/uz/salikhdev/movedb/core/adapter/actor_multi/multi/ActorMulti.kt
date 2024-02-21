package uz.salikhdev.movedb.core.adapter.actor_multi.multi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.salikhdev.movedb.core.adapter.actor_multi.acting.ActingAdapter
import uz.salikhdev.movedb.core.adapter.actor_multi.actor.ActorsImageAdapter
import uz.salikhdev.movedb.core.model.acting.acting.ActingResponse
import uz.salikhdev.movedb.core.model.actor.actor_list.ActorResponse
import uz.salikhdev.movedb.core.model.home.BaseData
import uz.salikhdev.movedb.databinding.ItemActingParentBinding
import uz.salikhdev.movedb.databinding.ItemActorParentBinding

class ActorMulti : RecyclerView.Adapter<ViewHolder>() {

    private val data = ArrayList<BaseData>()
    var onClickItem: ((id: Int) -> Unit)? = null

    fun setData(data: ArrayList<BaseData>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(data: BaseData) {
        this.data.add(data)
        notifyItemInserted(this.data.size)
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    inner class ActorViewHolder(private val binding: ItemActorParentBinding) :
        ViewHolder(binding.root) {

        private val adapter by lazy { ActorsImageAdapter() }

        fun bindDada(data: ActorResponse) {
            binding.parentRecycler.adapter = adapter
            binding.parentRecycler.layoutManager =
                LinearLayoutManager(binding.parentRecycler.context, RecyclerView.HORIZONTAL, false)
            binding.parentRecycler.setHasFixedSize(true)
            //adapter.setData(data)
        }

    }

    inner class ActingViewHolder(private val binding: ItemActingParentBinding) :
        ViewHolder(binding.root) {
        private val adapter by lazy { ActingAdapter() }
        fun bindData(data: ActingResponse) {
            binding.parentRecycler.adapter = adapter
            binding.parentRecycler.layoutManager =
                LinearLayoutManager(binding.parentRecycler.context, RecyclerView.HORIZONTAL, false)
            binding.parentRecycler.setHasFixedSize(true)
            //adapter.setData(data)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            BaseData.ACTOR -> {
                ActorViewHolder(
                    ItemActorParentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                ActingViewHolder(
                    ItemActingParentBinding.inflate(
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            BaseData.ACTOR -> {
                (holder as ActorMulti.ActorViewHolder).bindDada(data[position] as ActorResponse)
            }

            else -> {
                (holder as ActorMulti.ActingViewHolder).bindData(data[position] as ActingResponse)
            }
        }
    }


}