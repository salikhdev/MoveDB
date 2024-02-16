package uz.salikhdev.movedb.core.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.salikhdev.movedb.core.room.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveMovie(movies: MovieEntity)

    @Query("SELECT * FROM movies")
    fun getMovie(): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE id =:id")
    fun getData(id: Int): MovieEntity

    @Query("SELECT id FROM movies")
    fun getID(): List<Int>

    @Delete
    fun deleteMovie(movie: MovieEntity)

}