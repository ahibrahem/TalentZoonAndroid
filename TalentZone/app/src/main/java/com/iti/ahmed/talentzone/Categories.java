package com.iti.ahmed.talentzone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Categories extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ArrayList<String> arrayList =new ArrayList<>();
    ListView ls;

    UserBean userBean;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        setTitle("Categories List");
        userBean = new UserBean();


        // Web service
        Response.Listener<String > stringListener=new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonObject1=jsonObject.getJSONArray("result");
                    for (int i =0 ;i<jsonObject1.length();i++)
                    {
                        String cat_name=(String)jsonObject1.getJSONObject(i).get("name");
                        //String cat_name =(String) jsonObject2.get("name");
                        arrayList.add(cat_name);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        CategoryRequest categoryRequest =new CategoryRequest(stringListener);
        RequestQueue requestQueue = Volley.newRequestQueue(Categories.this);
        requestQueue.add(categoryRequest);


        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        userBean=(UserBean)bundle.getSerializable("v");
        ls=(ListView)findViewById(R.id.ls);



        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.cat_listview,R.id.CatTxt,arrayList);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(this);

        Toast.makeText(this,userBean.getLast_name() +":" + userBean.getFirst_name()+":" + userBean.getMobile() ,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int i=position+1;
        userBean.setCat(""+i);

        Response.Listener<String> stringListener =new Response.Listener<String>()
        {


            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject =new JSONObject(response);
                    boolean success = jsonObject.getBoolean("status");
                    if(success)
                    {
                        JSONObject jsonArray = jsonObject.getJSONObject("result");
                        //JSONObject jsonArray1 = jsonArray.getJSONObject("talent");
                        userBean.setCat(jsonArray.getString("categoryName"));
                        Intent i=new Intent(Categories.this,Profile.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("value", userBean);
                        i.putExtras(bundle);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(),"Reg Done",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        String error = jsonObject.getString("error_msg");
                        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        RegisterRequest registerRequest =new RegisterRequest(userBean,stringListener);
        RequestQueue requestQueue = Volley.newRequestQueue(Categories.this);
        requestQueue.add(registerRequest);



    }
}
