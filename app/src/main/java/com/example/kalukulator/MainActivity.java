package com.example.kalukulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    MainAdapter adapter;
   RecyclerView recyclerView;

    TextView result;
    Double firstValues, secondValues, result_op;
    String operation;

    private static final String FIRST = "FISRT";
    private static final String SECOND = "SECOND";
    private static final String OPERATION = "OPERATION";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_field1);

    }






    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mykey", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mykey", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mykey", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("mykey", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mykey", "onDestroy");
    }

    public void onNumberClick(View view) {
      try {
          switch (view.getId()) {
              case R.id.seven:
                  result.append("7");
                  break;
              case R.id.eight:
                  result.append("8");
                  break;
              case R.id.nine:
                  result.append("9");
                  break;
              case R.id.four:
                  result.append("4");
                  break;
              case R.id.five:
                  result.append("5");
                  break;
              case R.id.six:
                  result.append("6");
                  break;
              case R.id.one:
                  result.append("1");
                  break;
              case R.id.two:
                  result.append("2");
                  break;
              case R.id.three:
                  result.append("3");
                  break;
              case R.id.zero:
                  result.append("0");
                  break;
              case R.id.clear:
                  result.setText("");
                  break;
              case R.id.dot:
                  String string = (result.getText().toString().trim());
                  if (string.length() > 0) {
                      result.setText(string + ".");
                      break;
                  }
          }
      }catch (Exception e){}
    }
    public void onOperationClick(View view) {
      try {
          switch (view.getId()) {
              case R.id.plus:
                  firstValues = Double.valueOf(result.getText().toString());
                  result.setText(firstValues + "+");
                  operation = "+";
                  break;
              case R.id.moduloDivision:
                  firstValues = Double.valueOf(result.getText().toString());
                  result.setText(firstValues + "/");
                  operation = "/";
                  break;
              case R.id.minus:
                  firstValues = Double.valueOf(result.getText().toString());
                  result.setText(firstValues + "-");
                  operation = "-";
                  break;
              case R.id.multiply:
                  firstValues = Double.valueOf(result.getText().toString());
                  result.setText(firstValues + "*");
                  operation = "*";
                  break;
              case R.id.equal:
                  if (operation != null) {
                      String two = result.getText().toString().replace(firstValues.toString() + operation, "");
                      secondValues = Double.valueOf(two);
                      switch (operation) {
                          case "+":
                              plusOperation();
                              break;
                          case "/":
                              divisionOperation();
                              break;
                          case "-":
                              minusOperation();
                              break;
                          case "*":
                              multiplicationOperation();
                              break;
                      }
                  }

          }
      }catch (Exception c){}
    }

    public void plusOperation() {

          result_op = firstValues + secondValues;

        result.setText(result_op.toString());
    }

    public void divisionOperation() {
        result_op = firstValues / secondValues;
        result.setText(result_op.toString());

    }

    public void minusOperation() {
        result_op = firstValues - secondValues;
        result.setText(result_op.toString());
    }

    public void multiplicationOperation() {
        result_op = firstValues * secondValues;
        result.setText(result_op.toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (firstValues != null) {
            outState.putDouble(FIRST, firstValues);
        }
        if (secondValues != null) {
            outState.putDouble(SECOND, secondValues);
        }
        if (operation != null) {
            outState.putString(OPERATION, operation);
        } }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            firstValues = savedInstanceState.getDouble(FIRST);
            secondValues = savedInstanceState.getDouble(SECOND);
            operation = savedInstanceState.getString(OPERATION);}


    }

    public void Save(View view) {
        String text =result.getText().toString();
        Intent intent= new Intent();
        intent.putExtra("Результат",text);
        setResult(RESULT_OK, intent);
        finish();


    }




}