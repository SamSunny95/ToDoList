package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    // initializing all view elements
    private Button addBtn;
    private EditText textBox;
    private ListView listView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning view elements with their id
        textBox = findViewById(R.id.textBox);
        addBtn = findViewById(R.id.addBtn);
        listView = findViewById(R.id.listView);

        // creates an Arraylist with the list of tasks saved.
        list = FileStream.readFromFile(this);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        // populates list view with saved items.
        listView.setAdapter(adapter);

        addBtn.setOnClickListener(this);

        listView.setOnItemClickListener(this);


    }

    // onClick function for the ADD button
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.addBtn:
                String item = textBox.getText().toString();
                adapter.add(item);
                textBox.setText("");

                // Saves the list to a file
                FileStream.writeToFile(list, this);

                // Toast method for "Item Added" notification
                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    // onClink function for each element in the list.
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        list.remove(i);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Item Deleted", Toast.LENGTH_SHORT).show();

    }
}