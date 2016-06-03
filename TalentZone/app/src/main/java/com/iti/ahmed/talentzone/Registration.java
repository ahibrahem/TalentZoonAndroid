package com.iti.ahmed.talentzone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registration extends AppCompatActivity {


    Button btReg;
    EditText edName, edPass, edMobile, edlastName;
    String fname, pass, lname, mobile, email;
    //String cat;

    UserBean userBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btReg = (Button) findViewById(R.id.btNext);
        edName = (EditText) findViewById(R.id.edFirstName);
        edMobile = (EditText) findViewById(R.id.edMobile);
        edPass = (EditText) findViewById(R.id.edPass);
        edlastName = (EditText) findViewById(R.id.edlastName);

        userBean=new UserBean();


        btReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = edName.getText().toString();
                pass = edPass.getText().toString();
                lname = edlastName.getText().toString();
                mobile = edMobile.getText().toString();
                email = "test2";
               // cat = "1";

                if (Validation.ckeckEmpty(fname) && Validation.ckeckEmpty(pass) && Validation.ckeckEmpty(lname) && Validation.ckeckEmpty(mobile)) {
                    if (Validation.checkLengthName(fname) && Validation.checkLengthName(lname)) {


                        if (Validation.checkLengthPass(pass)) {

                            userBean.setFirst_name(fname);
                            userBean.setEmail(email);
                            userBean.setPass(pass);
                            //userBean.setCat(cat);
                            userBean.setLast_name(lname);
                            userBean.setMobile(mobile);

//                            Response.Listener<String> stringListener =new Response.Listener<String>()
//                            {
//
//
//                                @Override
//                                public void onResponse(String response) {
//                                    try {
//                                        JSONObject jsonObject =new JSONObject(response);
//                                        boolean success = jsonObject.getBoolean("status");
//                                        if(success)
//                                        {
//                                            Toast.makeText(getApplicationContext(),"Reg Done",Toast.LENGTH_SHORT).show();
//                                        }
//                                        else
//                                        {
//                                            Toast.makeText(getApplicationContext(),"Reg Faile",Toast.LENGTH_SHORT).show();
//
//                                        }
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
//
//                                }
//                            };
//
//                            RegisterRequest registerRequest =new RegisterRequest(userBean,stringListener);
//                            RequestQueue requestQueue = Volley.newRequestQueue(Registration.this);
//                            requestQueue.add(registerRequest);


                            // Toast.makeText(Registration.this, "Success", Toast.LENGTH_SHORT).show();
                          //  new MyAsyncTask_Regist().execute();
                            Intent i=new Intent(Registration.this,Categories.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("v", userBean);
                            i.putExtras(bundle);
                            startActivity(i);
                            //  registerUser();
                        } else {
                            Toast.makeText(Registration.this, "password must be 6 chars", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(Registration.this, "enter valid name \n Name must greater than 2 chars", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registration.this, "Fill All Fields", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    // Registration Method


}
