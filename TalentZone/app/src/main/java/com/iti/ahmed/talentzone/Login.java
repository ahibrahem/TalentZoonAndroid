package com.iti.ahmed.talentzone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;

public class Login extends AppCompatActivity {

     Button btnLogin;
     EditText edUserName,edPass;
     String uName,pass;

    UserBean userBean;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userBean =new UserBean();
        btnLogin = (Button) findViewById(R.id.btLogin);
        edUserName = (EditText) findViewById(R.id.eduNamelogin);
        edPass = (EditText) findViewById(R.id.edPasswordlogin);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uName = edUserName.getText().toString();
                pass = edPass.getText().toString();


                if(Validation.ckeckEmpty(uName) && Validation.ckeckEmpty(pass))
                {

                    //final ProgressDialog   progressDialog =ProgressDialog.show(getApplicationContext(),"Loading Data","Please wait...",false,false);
                    Response.Listener<String> stringListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                Log.d("result", response);

                                JSONObject jsonObject = new JSONObject(response);

                                boolean success = jsonObject.getBoolean("status");
                                // String error = jsonObject.getString("error_msg");
                                if (success) {
                                    //progressDialog.dismiss();
                                    JSONObject jsonArray = jsonObject.getJSONObject("result");
                                    JSONObject jsonArray1 = jsonArray.getJSONObject("talent");
                                    Toast.makeText(getApplicationContext(), "Login Done", Toast.LENGTH_SHORT).show();
                                    userBean.setFirst_name(jsonArray1.getString("firstName"));
                                    userBean.setLast_name(jsonArray1.getString("lastName"));
                                    userBean.setMobile(jsonArray1.getString("mobile"));
                                    // userBean.setPass(jsonArray1.getString(3));
                                    userBean.setCat(jsonArray.getString("categoryName"));
                                    userBean.setEmail(jsonArray1.getString("email"));

                                    Intent i = new Intent(Login.this, Profile.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("value", userBean);
                                    i.putExtras(bundle);
                                    startActivity(i);
                                } else {
                                    //progressDialog.dismiss();
                                    String error = jsonObject.getString("error_msg");
                                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }



                    };


                    LoginRequest loginRequest =new LoginRequest(uName,pass,stringListener);
                    RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
                    requestQueue.add(loginRequest);
                }
                else
                {
                    Toast.makeText(Login.this,"Fill All Fields" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
