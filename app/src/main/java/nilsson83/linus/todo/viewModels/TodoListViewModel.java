package nilsson83.linus.todo.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;


import java.util.List;

import nilsson83.linus.todo.models.Todo;
import nilsson83.linus.todo.sqlite.TodoRoomDatabase;

/**
 *
 */

public class TodoListViewModel extends AndroidViewModel {

    private LiveData<List<Todo>> todoList;
    private Todo todo;

    private TodoRoomDatabase todoRoomDatabase;

    /**
     * Constructor fetches all todoLists from the database
     * and populate the LiveData List with them.
     * @param application
     */
    public TodoListViewModel(@NonNull Application application) {
        super(application);

        todoRoomDatabase = TodoRoomDatabase.getDatabase(this.getApplication());

        todoList = todoRoomDatabase.todoModel().getAllTodoItems();
    }

    public LiveData<List<Todo>> getTodoList() {
        return todoList;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }


}
