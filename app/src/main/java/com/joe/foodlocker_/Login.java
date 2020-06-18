package com.joe.foodlocker_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login extends AppCompatActivity {
    TextInputLayout mail_tv, password_tv;
    MaterialButton login_btn;
    final String url_login = "http://v2.foodlocker.com.ng//action=login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail_tv = findViewById(R.id.mail_tv);
        login_btn = findViewById(R.id.login_btn);
        password_tv = findViewById(R.id.signin_password_tv);
        final String password = password_tv.getEditText().getText().toString();
        final String email = mail_tv.getEditText().getText().toString();


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verifyfields(email,password)){

                }
            }
        });

    }
    boolean verifyfields(String mail,String password){
        if (TextUtils.isEmpty(mail)) {
            mail_tv.setError("Ops! you forgot to add your Email");
            return false;
        } else {
            mail_tv.setErrorEnabled(false);
        }
        if (TextUtils.isEmpty(password)) {
            password_tv.setError("Ops! you forgot to add your Email");
            return false;
        } else {
            password_tv.setErrorEnabled(false);
        }
        return true;

    }

    public class LoginUser extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String email = strings[0];
            String password = strings[1];
            OkHttpClient client = new OkHttpClient();
            RequestBody formbody = new FormBody.Builder()
                    .add("user_id", email)
                    .add("user_password", password)
                    .build();

            Request request = new Request.Builder()
                    .url(url_login)
                    .post(formbody)
                    .build();
            Response response = null;
            try{
                response = client.newCall(request).execute();
                if(response.isSuccessful()){
                    String result = response.body().string();
                  if(result.equalsIgnoreCase("login")){

                  }
                  else{
                      Toast.makeText(Login.this, "Email or password Mismatch",
                              Toast.LENGTH_LONG);
                  }
                }
            }catch(Exception e){

            }
return null;
        }
    }
}
