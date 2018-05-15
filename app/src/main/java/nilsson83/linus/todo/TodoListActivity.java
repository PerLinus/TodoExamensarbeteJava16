package nilsson83.linus.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;


import nilsson83.linus.todo.adapters.TodoListRecyclerViewAdapter;
import nilsson83.linus.todo.viewModels.TodoListViewModel;

public class TodoListActivity extends AppCompatActivity implements ITodoListActivity {

    private TodoListViewModel viewModel;
    private RecyclerView recyclerView;
    private TodoListRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        init();

    }

    private void init() {
        TodoListFragment fragment = new TodoListFragment();
        doFragmentTransaction(fragment, getString(R.string.fragment_todo_list), false);
    }

    /**
     * Replace an existing fragment in the fragmentContainer.
     *
     * @param fragment
     * @param tag
     * @param addToBackStack
     */
    private void doFragmentTransaction(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();

    }

    /**
     * Implementation of method from ITodoListActivity
     * @param fragmentTag
     */
    @Override
    public void inflateFragment(String fragmentTag) {
        if (fragmentTag.equals(getString(R.string.fragment_todo_list))) {
            TodoListFragment fragment = new TodoListFragment();
            doFragmentTransaction(fragment, fragmentTag, true);
        } else if (fragmentTag.equals(getString(R.string.fragment_add_todo))) {
            AddTodoFragment fragment = new AddTodoFragment();
            doFragmentTransaction(fragment, fragmentTag, true);
        } else if (fragmentTag.equals(getString(R.string.fragment_todo))) {
            TodoFragment fragment = new TodoFragment();
            doFragmentTransaction(fragment, fragmentTag, true);
        }
    }

}
