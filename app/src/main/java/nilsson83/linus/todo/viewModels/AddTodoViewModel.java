package nilsson83.linus.todo.viewModels;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import nilsson83.linus.todo.models.Todo;
import nilsson83.linus.todo.sqlite.TodoRoomDatabase;


public class AddTodoViewModel extends AndroidViewModel {

    private TodoRoomDatabase todoRoomDatabase;

    /**
     * Constructor establishes connection with the database
     * @param application
     */
    public AddTodoViewModel(@NonNull Application application) {
        super(application);

        todoRoomDatabase = TodoRoomDatabase.getDatabase(this.getApplication());
    }

    public void addTodo(final Todo todo) {
        new AddAsyncTask(todoRoomDatabase).execute(todo);
    }

    /**
     * Adds the todo to the database as a background operation wihtout having to
     * manipulate threads and/or handlers.
     */
    private static class AddAsyncTask extends AsyncTask<Todo, Void, Void> {

        private TodoRoomDatabase db;

        AddAsyncTask(TodoRoomDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            db.todoModel().addTodo(todos[0]);
            return null;
        }
    }

}
