package nilsson83.linus.todo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nilsson83.linus.todo.adapters.TodoListRecyclerViewAdapter;
import nilsson83.linus.todo.models.Todo;
import nilsson83.linus.todo.viewModels.TodoListViewModel;



public class TodoListFragment extends Fragment implements View.OnClickListener {

    View view;
    private TodoListViewModel viewModel;
    private RecyclerView recyclerView;
    private TodoListRecyclerViewAdapter todoListAdapter;

    private ITodoListActivity iTodoListActivity;


    /**
     * Sets the view with the lists of todos in the RecyclerView.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        view.findViewById(R.id.fabCreateTodo).setOnClickListener(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTodoList);

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
        if (view.getId() == R.id.fabCreateTodo) {
            iTodoListActivity.inflateFragment(getString(R.string.fragment_add_todo));
        } else {
            Todo todo = (Todo) view.getTag();
            viewModel.setTodo(todo);
            iTodoListActivity.inflateFragment(getString(R.string.fragment_todo));
        }
    }

    /**
     * Creates a instance of ITodoListActivity when the fragment is added to its activity.
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iTodoListActivity = (ITodoListActivity) getActivity();
    }

}
