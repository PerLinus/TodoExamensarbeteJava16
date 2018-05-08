package nilsson83.linus.todo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nilsson83.linus.todo.models.Todo;
import nilsson83.linus.todo.viewModels.TodoListViewModel;

/**
 * Created by Linus on 2018-05-06.
 */

public class FragmentTodo extends Fragment {

    private View view;
    private TodoListViewModel viewModel;
    private Todo todo;
    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(TodoListViewModel.class);
        todo = viewModel.getTodo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_todo, container, false);
        textView = view.findViewById(R.id.text);
        textView.setText(todo.getName());
        return view;
    }
}
