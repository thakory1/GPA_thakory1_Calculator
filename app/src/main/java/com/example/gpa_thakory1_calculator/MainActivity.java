package com.example.gpa_thakory1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    TextView myTextView;
    int grade1;
    int grade2;
    int grade3;
    int grade4;
    int grade5;

    int count = 0;
    int sum;
    int average;
    int numOfCourses = 5;
    String msg = "\n" +average;
    EditText grade1Input;
    EditText grade2Input;
    EditText grade3Input;
    EditText grade4Input;
    EditText grade5Input;

    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView=(TextView)findViewById(R.id.textView7);
        grade1Input = (EditText) findViewById(R.id.grade1Input);
        grade2Input = (EditText) findViewById(R.id.grade2Input);
        grade3Input = (EditText) findViewById(R.id.grade3Input);
        grade4Input = (EditText) findViewById(R.id.grade4Input);
        grade5Input = (EditText) findViewById(R.id.grade5Input);

        myButton = (Button)findViewById(R.id.button);


       // myButton.setOnClickListener(new MyListenerForEventHandling());
        //msg+="OnCreate is called \n";
        //Log.i(TAG, "OnCreate is called");
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grade1 = Integer.valueOf(grade1Input.getText().toString());
                grade2 = Integer.valueOf(grade2Input.getText().toString());
                grade3 = Integer.valueOf(grade3Input.getText().toString());
                grade4 = Integer.valueOf(grade4Input.getText().toString());
                grade5 = Integer.valueOf(grade5Input.getText().toString());

                if (count % 2 == 0) {
                    if (grade1Input.getText().toString().equals("") ||
                            grade2Input.getText().toString().equals("") ||
                            grade3Input.getText().toString().equals("") ||
                            grade4Input.getText().toString().equals("") ||
                            grade5Input.getText().toString().equals("")) {
                        myTextView.setText("Enter a grade in all fields");
                    } else {
                        sum = grade1 + grade2 + grade3 + grade4 + grade5;
                        average = sum / numOfCourses;
                        if (average < 60) {
                            myTextView.setText(Integer.toString(average));
                            myTextView.setBackgroundColor(Color.RED);
                        } else if (average > 60 && average < 80) {
                            myTextView.setText(Integer.toString(average));
                            myTextView.setBackgroundColor(Color.YELLOW);
                        } else if (average > 79 && average < 101) {
                            myTextView.setText(Integer.toString(average));
                            myTextView.setBackgroundColor(Color.GREEN);
                        }
                        count++;
                        myButton.setText("Clear Form");
                    }

                } else {
                    grade1Input.setText("");
                    grade2Input.setText("");
                    grade3Input.setText("");
                    grade4Input.setText("");
                    grade5Input.setText("");
                    myTextView.setText("GPA will be shown here");
                    myTextView.setBackgroundColor(Color.WHITE);
                    myButton.setText("Compute GPA");
                    count++;
                }
            }
        });
    };
}