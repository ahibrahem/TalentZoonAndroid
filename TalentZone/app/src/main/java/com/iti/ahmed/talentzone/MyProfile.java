package com.iti.ahmed.talentzone;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfile extends Fragment {


    TextView name , email , mobile, cat;

    View v;
    private WebView wv1;

    UserBean userBean;


    public MyProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_my_profile, container, false);
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        name =(TextView) v.findViewById(R.id.pname);
        email =(TextView) v.findViewById(R.id.pemail);
        mobile =(TextView) v.findViewById(R.id.pmob);
        cat =(TextView) v.findViewById(R.id.pcat);

        userBean =new UserBean();
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        userBean=(UserBean)bundle.getSerializable("value");

        // set data from object
        name.setText(userBean.getFirst_name() + " " + userBean.getLast_name());
        cat.setText(userBean.getCat());
        mobile.setText(userBean.getMobile());
        email.setText(userBean.getEmail());

        wv1 = (WebView) v.findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());

                String url = "http://www.gettyimages.pt/gi-resources/images/Homepage/Hero/PT/PT_hero_42_153645159.jpg";
                wv1.setVisibility(View.VISIBLE);
                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
               // wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl(url);
            }



    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
