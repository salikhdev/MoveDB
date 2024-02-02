package uz.salikhdev.movedb.core.common

abstract class GetType {

    companion object {
        const val CURRENT = 0
        const val POPULAR = 1
    }

    abstract fun getType(): Int

}