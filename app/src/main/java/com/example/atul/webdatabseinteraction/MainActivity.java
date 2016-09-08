package com.example.atul.webdatabseinteraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String url="http://serverexample12.coolpage.biz/Myinsert12.php";
    EditText name,email,password;
    Button btnRegister;
    RequestQueue requestQueue;
    String user_name,user_mail,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name = name.getText().toString();
                user_mail = email.getText().toString();
                pass = password.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(MainActivity.this, "Registration Successfull !!", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, "There is some isssue in registration please try again !!!", Toast.LENGTH_SHORT).show();

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> myvalues = new HashMap<String, String>();
                        myvalues.put("user_name",user_name);
                        myvalues.put("user_password",pass);
                        myvalues.put("user_email",user_mail);
                        return myvalues;

                    }
                };
                requestQueue.add(stringRequest);
            }
        }
        );

    }
}
