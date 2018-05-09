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
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import nilsson83.linus.todo.models.Todo;
import nilsson83.linus.todo.viewModels.TodoListViewModel;


public class TodoFragment extends Fragment {

    private View view;
    private TodoListViewModel viewModel;
    private Todo todo;
    private EditText title;
    private EditText content;

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
        title = view.findViewById(R.id.editTextTitle);
        content = view.findViewById(R.id.editTextContent);
        title.setText(todo.getName());
        content.setText(todo.getTodos());

        return view;
    }
}
