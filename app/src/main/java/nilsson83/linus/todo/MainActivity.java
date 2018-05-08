package nilsson83.linus.todo;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nilsson83.linus.todo.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        findViewById(R.id.todoButton).setOnClickListener(this);
        findViewById(R.id.shoppingButton).setOnClickListener(this);
        findViewById(R.id.passwordButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.todoButton) {
            Intent intent = new Intent(MainActivity.this, TodoListActivity.class);
            startActivity(intent);
        } else if (i == R.id.shoppingButton) {
            Intent intent = new Intent(MainActivity.this, TodoListActivity.class);
            startActivity(intent);
        } else if (i == R.id.passwordButton) {
            Intent intent = new Intent(MainActivity.this, TodoListActivity.class);
            startActivity(intent);
        }

    }

}
