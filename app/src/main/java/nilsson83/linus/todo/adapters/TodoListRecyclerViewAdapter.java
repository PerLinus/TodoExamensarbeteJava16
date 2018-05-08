package nilsson83.linus.todo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nilsson83.linus.todo.R;
import nilsson83.linus.todo.models.Todo;

/**
 * Created by Linus on 2018-05-05.
 */

public class TodoListRecyclerViewAdapter extends RecyclerView.Adapter<TodoListRecyclerViewAdapter.TodoListAdapterViewHolder> {

    private List<Todo> todos;

    private View.OnClickListener clickHandler;

    public TodoListRecyclerViewAdapter(List<Todo> todos, View.OnClickListener clickHandler) {

        this.todos = todos;
        this.clickHandler = clickHandler;
    }

    @NonNull
    @Override
    public TodoListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new TodoListAdapterViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.todo_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoListRecyclerViewAdapter.TodoListAdapterViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.textViewTodoListItem.setText(todo.getName());
        holder.itemView.setTag(todo);
        holder.itemView.setOnClickListener(clickHandler);
    }

    @Override
    public int getItemCount() {
        if (todos == null) {
            return 0;
        }
        return todos.size();
    }

    public void addItems(List<Todo> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    public class TodoListAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTodoListItem;

        TodoListAdapterViewHolder(View itemView) {
            super(itemView);
            textViewTodoListItem = (TextView) itemView.findViewById(R.id.textView_todo_list_item);
        }
    }

}
