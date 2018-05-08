package nilsson83.linus.todo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;


import java.util.ArrayList;
import java.util.List;

import nilsson83.linus.todo.adapters.TodoListRecyclerViewAdapter;
import nilsson83.linus.todo.models.Todo;
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
        FragmentTodoList fragment = new FragmentTodoList();
        doFragmentTransaction(fragment, getString(R.string.fragment_todo_list), false);
    }

    private void doFragmentTransaction(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();

    }

    /*@Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab_create_todo) {
            Intent intent = new Intent(TodoListActivity.this, ShoppingListActivity.class);
            startActivity(intent);
        } else {
            Todo todo = (Todo) view.getTag();
            Intent intent = new Intent(TodoListActivity.this, TodoActivity.class);
            intent.putExtra("name", todo.getName());
            intent.putExtra("content", todo.getTodos());
            startActivity(intent);
        }
    }*/

    @Override
    public void inflateFragment(String fragmentTag) {
        if (fragmentTag.equals(getString(R.string.fragment_todo_list))) {
            FragmentTodoList fragment = new FragmentTodoList();
            doFragmentTransaction(fragment, fragmentTag, true);
        } else if (fragmentTag.equals(getString(R.string.fragment_add_todo))) {
            FragmentAddTodo fragment = new FragmentAddTodo();
            doFragmentTransaction(fragment, fragmentTag, true);
        } else if (fragmentTag.equals(getString(R.string.fragment_todo))) {
            FragmentTodo fragment = new FragmentTodo();
            doFragmentTransaction(fragment, fragmentTag, true);
        }
    }

      /*findViewById(R.id.fab_create_todo).setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_todoList);

        adapter = new TodoListRecyclerViewAdapter(new ArrayList<Todo>(), this);

        //mErrorMessageDisplay = (TextView) findViewById(R.id.tv_todo_list_error_message);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);


        viewModel = ViewModelProviders.of(this).get(TodoListViewModel.class);

        viewModel.getTodoList().observe(TodoListActivity.this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(@Nullable List<Todo> todos) {
                adapter.addItems(todos);
            }
        });*/
}