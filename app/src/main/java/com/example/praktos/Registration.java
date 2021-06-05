package com.example.praktos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    SharedPreferences myPreferences;
    private EditText name;
    private EditText email;
    private EditText pass1;
    private EditText pass2;
    String n = "name";
    String e = "email";
    String p1 = "pass1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = (EditText)findViewById(R.id.editUser);
        email = (EditText)findViewById(R.id.editEmail);
        pass1 = (EditText)findViewById(R.id.editPass);
        pass2 = (EditText)findViewById(R.id.editRepeatPass);
    }

    public boolean NullOrNot() {
        boolean flag;
        if((name.getText().toString().equals(""))&&(email.getText().toString().equals(""))&&(pass1.getText().toString().equals(""))&&(pass2.getText().toString().equals(""))) {
            flag = false;
        }
else {
    flag = true;
        }
return flag;
    }



    public boolean EqCode() {
        boolean flag;
        if(pass1.getText().toString().equals(pass2.getText().toString())) {
            flag = true;
        }
        else {
            flag = false;
        }
        return flag;
    }

    public final static boolean isValidEmail(String target) {
        if (target == null)
            return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean ValEmail() {
        boolean flag = true;
        return flag;
    }

    public void enterAuth() {

        if(NullOrNot()) {


            if(isValidEmail(email.getText().toString())){

                if(EqCode())
                {
                    myPreferences = PreferenceManager.getDefaultSharedPreferences(Registration.this);
                    SharedPreferences.Editor editor = myPreferences.edit();
                    editor.putString(n , name.getText().toString());
                    editor.putString(e, email.getText().toString());
                    editor.putString(p1, pass1.getText().toString());
                    editor.commit();

                }


                else {
                    Toast.makeText(getApplicationContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                }


            }

            else {
                Toast.makeText(getApplicationContext(), "Email введен неправильно", Toast.LENGTH_SHORT).show();
            }

        }

        else {
            Toast.makeText(getApplicationContext(), "Заполните поля", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean compareAuth(EditText name, EditText email, EditText pass1) {
        boolean flag;
        if((name.getText().toString().equals(myPreferences.getString(n, "unknown")))&&(email.getText().toString().equals(myPreferences.getString(e, "unknown")))&&(pass1.getText().toString().equals(myPreferences.getString(p1, "unknown")))) {
            flag = true;
        }

        else {
            flag = false;
        }
        return flag;
    }

    public void SignUp(View view) {
        myPreferences = PreferenceManager.getDefaultSharedPreferences(Registration.this);
        boolean isStart = myPreferences.getBoolean("isStart", false);
        if(isStart) {
            if(compareAuth(name, email, pass1)) {
                Intent intent = new Intent(Registration.this, Authorisation.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Такого пользователя не найдено", Toast.LENGTH_LONG);
            }
        }

        else {
            SharedPreferences.Editor myEditor = myPreferences.edit();
            myEditor.putBoolean("isStart", true);
            myEditor.commit();
            enterAuth();
        }



    }



    public void SignUpText(View view) {


        if(NullOrNot()) {
            if(EqCode())
            {
                if(isValidEmail(email.getText().toString())){
                    Intent intent = new Intent(Registration.this, MainScreen.class);
                    startActivity(intent);
                    SharedPreferences myPreferences
                            = PreferenceManager.getDefaultSharedPreferences(Registration.this);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                }

                else {
                    Toast.makeText(getApplicationContext(), "Email введен неправильно", Toast.LENGTH_SHORT).show();
                }
            }

            else {
                Toast.makeText(getApplicationContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            }

        }

        else {
            Toast.makeText(getApplicationContext(), "Заполните поля", Toast.LENGTH_SHORT).show();
        }
    }




    public void SignIn(View view) {
        Intent intent = new Intent(Registration.this, Authorisation.class);
        startActivity(intent);
    }

    public void SignInText(View view) {
        Intent intent = new Intent(Registration.this, Authorisation.class);
        startActivity(intent);
    }
}