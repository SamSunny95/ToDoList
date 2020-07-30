package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addBtn;
    private EditText textBox;
    private ListView listView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox = findViewById(R.id.textBox);
        addBtn = findViewById(R.id.addBtn);
        listView = findViewById(R.id.listView);

        addBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.addBtn:
                String item = textBox.getText().toString();
                adapter.add(item);
                textBox.setText("");
                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}