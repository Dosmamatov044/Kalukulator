package com.example.kalukulator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Intent.EXTRA_TEXT;

public class Main2Activity extends AppCompatActivity {
    TextView res;
    String savedString;

    static int KEY = 4;
    private Button share_button;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        res = findViewById(R.id.result2);
        if (savedInstanceState != null) {
            savedString = savedInstanceState.getString("savedString");
            res.setText(savedString);
            Log.d("Something", "-----" + savedString);
        }


        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);

        adapter = new MainAdapter();
        history = new ArrayList<>();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedString", res.getText().toString());
    }



    public void toCalculator(View view) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivityForResult(intent, KEY);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4 && resultCode == RESULT_OK) {
            history.add(0,data.getStringExtra("Результат"));
         adapter.upDate(history);

        }
    }

    public void shareToTelegram(View view) {

        if(history.toString()!=null){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(EXTRA_TEXT, history.toString());
        intent.setType("text/plain");
        startActivity(intent);
        }}
    }





