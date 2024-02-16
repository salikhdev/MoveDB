package uz.salikhdev.movedb.ui.detail

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.salikhdev.movedb.R
import uz.salikhdev.movedb.core.adapter.actor.ActorsImageAdapter
import uz.salikhdev.movedb.core.common.BaseFragment
import uz.salikhdev.movedb.core.model.actor.Cast
import uz.salikhdev.movedb.databinding.ScreenActorBinding

class ActorScreen : BaseFragment(R.layout.screen_actor) {

    private val binding by viewBinding(ScreenActorBinding::bind)
    private val adapter by lazy { ActorsImageAdapter() }
    private val args: ActorScreenArgs by navArgs()
    private val data = ArrayList<Cast>()
    override fun onViewCreated(view: View) {
        setAdapter()
        setData()
        clickListener()
    }

    private fun setData() {
        val data = args.author
        binding.name.text = data.name

    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        adapter.setData(data)
    }

    private fun clickListener() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}