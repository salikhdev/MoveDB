package uz.salikhdev.movedb.core.model.home

abstract class BaseData {

    companion object {
        const val NOW_PLAYING = 0
        const val POPULAR = 1
    }

    abstract fun getType(): Int

}