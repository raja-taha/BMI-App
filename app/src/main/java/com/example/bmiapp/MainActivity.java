package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);
        EditText edtHeightFt = (EditText) findViewById(R.id.edtHeightFt);
        EditText edtHeightIn = (EditText) findViewById(R.id.edtHeightIn);
        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        TextView txtResult = (TextView) findViewById(R.id.txtResult);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(edtWeight.getText().toString());
                int heightFt = Integer.parseInt(edtHeightFt.getText().toString());
                int heightIn= Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = heightFt * 12 + heightIn;
                double totalCm = totalIn * 2.53;
                double totalMeters = totalCm / 100;

                double bmi = weight / (totalMeters * totalMeters);

                if (bmi > 25) {
                    txtResult.setText("You're Overweight");
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.color_over));
                }
                else if (bmi < 18) {
                    txtResult.setText("You're Underweight");
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.color_under));
                }
                else {
                    txtResult.setText("You're Healthy");
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.color_normal));
                }
            }
        });
    }
}