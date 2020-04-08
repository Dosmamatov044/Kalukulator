package com.example.kalukulator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView res;
    String savedString;

    static int KEY=4;
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
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedString", res.getText().toString());
    }



    public void toCalculator(View view) {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivityForResult(intent , KEY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4 && resultCode == RESULT_OK) {
            String result = data.getStringExtra("resultat");
            res.setText(result);
        }
    }

    public void shareToTelegram(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, res.getText().toString());
        intent.setType("text/plain");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}