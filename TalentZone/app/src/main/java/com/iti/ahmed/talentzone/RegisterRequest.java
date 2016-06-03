package com.iti.ahmed.talentzone;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmed on 31/05/2016.
 */



public class RegisterRequest  extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://172.16.2.4:8084//TalentZoneTom/rest/talent/register";
    private Map<String , String> params;

    public RegisterRequest(UserBean userBean,Response.Listener<String> listener)
    {
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("category",userBean.getCat());
        params.put("mobile", userBean.getMobile());
        params.put("pass",userBean.getPass());
        params.put("firstName",userBean.getFirst_name());
        params.put("lastName",userBean.getLast_name());
        params.put("email",userBean.getEmail());

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
