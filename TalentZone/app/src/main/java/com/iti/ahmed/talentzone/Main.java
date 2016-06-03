package com.iti.ahmed.talentzone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main extends Activity implements View.OnClickListener{

    Button btnReg , btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /////////// facebook

//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.iti.ahmed.talentzone",
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//
//        } catch (NoSuchAlgorithmException e) {
//
//        }
        //////////////////////////////

        btnReg = (Button)findViewById(R.id.btGoReg);
        btLogin = (Button) findViewById(R.id.btGoLogin);

        btnReg.setOnClickListener(this);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=null;
        if(v.getId()==R.id.btGoReg)
        {
            i=new Intent(Main.this,Registration.class);
            startActivity(i);

        }
        else if(v.getId()==R.id.btGoLogin)
        {
            i=new Intent(Main.this,Login.class);
            startActivity(i);
        }
    }
}
