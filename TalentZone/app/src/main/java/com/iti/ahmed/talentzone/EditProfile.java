package com.iti.ahmed.talentzone;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfile extends Fragment implements View.OnClickListener{

   ImageView imgView;
    View  v;

    EditText ed_fname,ed_lname,ed_mob,ed_email,ed_talen_url;


    UserBean uBean ;
    public EditProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        return  v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        uBean =new UserBean();
        imgView =(ImageView) v.findViewById(R.id.imv);
        ed_fname=(EditText)v.findViewById(R.id.ed_first_name);
        ed_lname=(EditText)v.findViewById(R.id.ed_last_name);
        ed_mob=(EditText)v.findViewById(R.id.ed_mobile);
        ed_email=(EditText)v.findViewById(R.id.ed_email);
        ed_talen_url=(EditText)v.findViewById(R.id.ed_talent_url);

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        uBean=(UserBean)bundle.getSerializable("value");

        ed_fname.setText(uBean.getFirst_name());
        ed_lname.setText(uBean.getLast_name());
        ed_mob.setText(uBean.getMobile());
        ed_email.setText(uBean.getEmail());



        imgView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
         if(v.getId() == R.id.imv)
         {
             Toast.makeText(getContext(),"In Actitivty" , Toast.LENGTH_SHORT).show();
             Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
             startActivityForResult(i,0 );
         }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            imgView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }
}
