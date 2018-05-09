package nilsson83.linus.todo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nilsson83.linus.todo.adapters.TodoListRecyclerViewAdapter;
import nilsson83.linus.todo.models.Todo;
import nilsson83.linus.todo.viewModels.AddTodoViewModel;
import nilsson83.linus.todo.viewModels.TodoListViewModel;



public class FragmentTodoList extends Fragment implements View.OnClickListener {

    View view;
    private TodoListViewModel viewModel;
    private RecyclerView recyclerView;
    private TodoListRecyclerViewAdapter todoListAdapter;

    private ITodoListActivity iTodoListActivity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        view.findViewById(R.id.fab_create_todo).setOnClickListener(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_todoList);

        todoListAdapter = new TodoListRecyclerViewAdapter(new ArrayList<Todo>(), this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(todoListAdapter);

        viewModel = ViewModelProviders.of(getActivity()).get(TodoListViewModel.class);

        viewModel.getTodoList().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(@Nullable List<Todo> todos) {
                todoListAdapter.addItems(todos);
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab_create_todo) {
            iTodoListActivity.inflateFragment(getString(R.string.fragment_add_todo));
        } else {
            Todo todo = (Todo) view.getTag();
            viewModel.setTodo(todo);
            iTodoListActivity.inflateFragment(getString(R.string.fragment_todo));
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iTodoListActivity = (ITodoListActivity) getActivity();
    }

    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AddTodoViewModel addTodoViewModel = ViewModelProviders.of(this).get(AddTodoViewModel.class);
        addTodoViewModel.addTodo(new Todo("Test", "test"));
        addTodoViewModel.addTodo(new Todo("Test1", "test1"));
        addTodoViewModel.addTodo(new Todo("Test2", "test2"));
        addTodoViewModel.addTodo(new Todo("Test3", "test3"));
    }*/

   /* @Override
    public void onClick(View view) {
        Fragment fragment = null;

        if (view.getId() == R.id.fab_create_todo) {
            fragment = new FragmentAddTodo();
            replaceFragment(fragment);
        } else {
            Todo todo = (Todo) view.getTag();
            fragment = new FragmentTodo();
            replaceFragment(fragment);
        }

       *//* switch (view.getId()) {
            case R.id.todo_item:
                fragment = new FragmentTodo();
                replaceFragment(fragment);
                break;

            case R.id.fab_create_todo:
                fragment = new FragmentAddTodo();
                replaceFragment(fragment);
                break;
        }*//*
    }*/

   /* public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.test, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }*/

}
