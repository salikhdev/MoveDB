package uz.salikhdev.movedb.core.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.salikhdev.movedb.core.room.dao.MovieDao
import uz.salikhdev.movedb.core.room.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun moviesDao(): MovieDao

    fun getDatabase(context: Context): MovieDataBase {
        var INSTANCE: MovieDataBase? = null
        if (INSTANCE == null) {
            synchronized(this) {
                INSTANCE = buildDatabase(context)
            }
        }
        return INSTANCE!!
    }

    fun buildDatabase(context: Context): MovieDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            MovieDataBase::class.java,
            "notes_database"
        )
            .build()
    }


}