package com.example.praktos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Authorisation extends AppCompatActivity {
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorisation);
        name = (EditText)findViewById(R.id.edtxtUser);
    }

    public boolean ValName(EditText name) {
        boolean flag;
        if(name.getText().toString().equals(""))
            flag = false;
        else flag = true;
        return flag;
    }

    public void AuthSignInText(View view) {
        if(ValName(name)) {
            Intent intent = new Intent(Authorisation.this, AuthorisationMain.class);
            startActivity(intent);
        }
       else {}
    }

    public void AuthSignIn(View view) {
        if(ValName(name)) {
            Intent intent = new Intent(Authorisation.this, AuthorisationMain.class);
            startActivity(intent);
        }
        else {}
    }

    public void AuthSignUp(View view) {
        if(ValName(name)) {
            Intent intent = new Intent(Authorisation.this, Registration.class);
            startActivity(intent);
        }
        else {}

    }

    public void AuthSignUpText(View view) {
        if(ValName(name)) {
            Intent intent = new Intent(Authorisation.this, Registration.class);
            startActivity(intent);
        }
        else {}
    }
}