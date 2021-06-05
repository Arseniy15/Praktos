package com.example.praktos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class AuthorisationMain extends AppCompatActivity {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    TextView txtNum1;
    TextView txtNum2;
    TextView txtNum3;
    TextView txtNum4;
    TextView txtNum5;
    TextView txtNum6;
    TextView txtNum7;
    TextView txtNum8;
    TextView txtNum9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorisation_main);

        txtNum1 = (TextView)findViewById(R.id.txtNum1);
        txtNum2 = (TextView)findViewById(R.id.txtNum2);
        txtNum3 = (TextView)findViewById(R.id.txtNum3);
        txtNum4 = (TextView)findViewById(R.id.txtNum4);
        txtNum5 = (TextView)findViewById(R.id.txtNum5);
        txtNum6 = (TextView)findViewById(R.id.txtNum6);
        txtNum7 = (TextView)findViewById(R.id.txtNum7);
        txtNum8 = (TextView)findViewById(R.id.txtNum8);
        txtNum9 = (TextView)findViewById(R.id.txtNum9);

        GridLayout gridLayout;
        gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        GridLayout.LayoutParams gridPar = new GridLayout.LayoutParams();
    }

    public void Back(View view) {
        Intent intent = new Intent(AuthorisationMain.this, Authorisation.class);
        startActivity(intent);
    }

    public void numClick(View view) {
        int k;
            Random r = new Random();
            k = r.nextInt(8);
            txtNum1.setText(nums[k]);
        k = r.nextInt(8);
        txtNum2.setText(nums[k]);
        k = r.nextInt(8);
        txtNum3.setText(nums[k]);
        k = r.nextInt(8);
        txtNum4.setText(nums[k]);
        k = r.nextInt(8);
        txtNum5.setText(nums[k]);
        k = r.nextInt(8);
        txtNum6.setText(nums[k]);
        k = r.nextInt(8);
        txtNum7.setText(nums[k]);
        k = r.nextInt(8);
        txtNum8.setText(nums[k]);
        k = r.nextInt(8);
        txtNum9.setText(nums[k]);

    }
}