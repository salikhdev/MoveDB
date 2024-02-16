package uz.salikhdev.movedb.core.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.salikhdev.movedb.core.room.dao.MovieDao
import uz.salikhdev.movedb.core.room.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun moviesDao(): MovieDao


}