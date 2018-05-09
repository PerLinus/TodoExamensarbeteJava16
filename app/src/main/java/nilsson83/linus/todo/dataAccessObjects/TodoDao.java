package nilsson83.linus.todo.dataAccessObjects;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import java.util.List;

import nilsson83.linus.todo.models.Todo;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * A Data Access Object. Defines database interactions. At
 * compile time, Room(a librabry for handling SQLite databases)
 * will generate an implementation of this
 * class when it is referenced by a Database.
 */
@Dao
public interface TodoDao {

    @Query("SELECT * FROM Todo")
    LiveData<List<Todo>> getAllTodoItems();

    @Insert(onConflict = REPLACE)
    void addTodo(Todo todo);
}
