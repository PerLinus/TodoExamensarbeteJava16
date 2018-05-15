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
 * This class is used to handle displaying the lists in the app.
 */

public class TodoListRecyclerViewAdapter extends RecyclerView.Adapter<TodoListRecyclerViewAdapter.TodoListAdapterViewHolder> {

    private List<Todo> todos;

    private View.OnClickListener clickHandler;

    /**
     * Constructor sets the list of todos and adds a clickhandler.
     * @param todos
     * @param clickHandler
     */
    public TodoListRecyclerViewAdapter(List<Todo> todos, View.OnClickListener clickHandler) {

        this.todos = todos;
        this.clickHandler = clickHandler;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
     * @param viewGroup
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public TodoListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new TodoListAdapterViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.todo_list_item, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position. Sets a tag
     * on the todo so other parts of the application can find it.
     * @param holder
     * @param position
     */
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

    /**
     * Describes the todo and its place in the list of todos.
     */
    public class TodoListAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTodoListItem;

        TodoListAdapterViewHolder(View itemView) {
            super(itemView);
            textViewTodoListItem = (TextView) itemView.findViewById(R.id.textViewTodoListItem);
        }
    }

}
