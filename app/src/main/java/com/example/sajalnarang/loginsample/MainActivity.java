package com.example.sajalnarang.loginsample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<GsonModels.UserDetails> {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Username is required", Toast.LENGTH_SHORT).show();
                } else {
                    RetrofitInterface retrofitInterface = ServiceGenerator.createService(RetrofitInterface.class);
                    retrofitInterface.getUserDetails(username, password).enqueue(MainActivity.this);
                }
            }
        });
    }

    @Override
    public void onResponse(Call<GsonModels.UserDetails> call, Response<GsonModels.UserDetails> response) {
        if (response.isSuccessful()) {
            GsonModels.UserDetails userDetails = response.body();
            Toast.makeText(MainActivity.this, userDetails.getName() + userDetails.getEmail() + userDetails.getRollno(), Toast.LENGTH_SHORT).show();
            //Use the userDetails
        } else {
            Toast.makeText(MainActivity.this, "Response Code: " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<GsonModels.UserDetails> call, Throwable t) {
        Toast.makeText(MainActivity.this, "onFailure called" + t.toString(), Toast.LENGTH_LONG).show();
    }
}
