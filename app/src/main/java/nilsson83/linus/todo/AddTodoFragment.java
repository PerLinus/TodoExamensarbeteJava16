package nilsson83.linus.todo;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import nilsson83.linus.todo.models.Todo;
import nilsson83.linus.todo.viewModels.AddTodoViewModel;


public class AddTodoFragment extends Fragment implements View.OnClickListener {

    View view;
    private EditText title;
    private EditText content;

    private AddTodoViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_todo, container, false);

        //This makes the GUI adjust correctly when you use the keyboard
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        title = view.findViewById(R.id.editTextTitle);
        content = view.findViewById(R.id.editTextContent);

        view.findViewById(R.id.addTodoButton).setOnClickListener(this);

        viewModel = ViewModelProviders.of(getActivity()).get(AddTodoViewModel.class);
        return view;
    }

    /**
     * Responds on button clicks and adds todos.
     * @param view
     */

    @Override
    public void onClick(View view) {
        if (title.getText() == null || content.getText() == null) {
            Toast.makeText(getActivity(), "Missing fields!", Toast.LENGTH_SHORT).show();
        } else {
            viewModel.addTodo(new Todo(
                    title.getText().toString(),
                    content.getText().toString()
            ));
            title.getText().clear();
            content.getText().clear();
            Toast.makeText(getActivity(), "Added Todo!", Toast.LENGTH_SHORT).show();
        }
    }
}
