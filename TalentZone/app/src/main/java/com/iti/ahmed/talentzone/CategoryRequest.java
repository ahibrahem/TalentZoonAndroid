package com.iti.ahmed.talentzone;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmed on 01/06/2016.
 */
public class CategoryRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://172.16.2.4:8084/TalentZoneTom/rest/category/all";
    //private Map<String , String> params;

    public CategoryRequest(Response.Listener<String> listener)
    {
        super(Method.GET,REGISTER_REQUEST_URL,listener,null);

    }
}
