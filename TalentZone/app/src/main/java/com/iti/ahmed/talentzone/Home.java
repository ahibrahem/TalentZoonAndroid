package com.iti.ahmed.talentzone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment  {


    ArrayList<String> arrayList =new ArrayList<>();
    ArrayList<String> arrayList1 =new ArrayList<>();
    ArrayList<Integer> arrayList2 =new ArrayList<>();

    //String arr[]=null; //{"Saturday","Sunday","Mondy","Tuthday","Wensday","Thurthday","Friday","Saturday","Sunday","Mondy","Tuthday"};
    //String arr1[]=null; //{"111","222","333","444","555","666","777","222","333","444","555"};
    //Integer [] imArr=null; //{R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo};
    ListView lv;
    EditText edtxt;
    Button btn;
    View v=null;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        edtxt =(EditText)v.findViewById(R.id.edtxt);
        btn =(Button) v.findViewById(R.id.btn);
        lv=(ListView) v.findViewById (R.id.listView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
                String date = df.format(Calendar.getInstance().getTime());
                String text = edtxt.getText().toString();
                if(text.isEmpty())
                {
                    Toast.makeText(getContext(),"Enter Any thing to share",Toast.LENGTH_SHORT).show();
                }
                else {
                    arrayList.add(text);
                    arrayList1.add(date);
                    arrayList2.add(R.drawable.profile);
                    AdapterClass adapter = new AdapterClass(getContext(), arrayList, arrayList1, arrayList2);
                    lv.setAdapter(adapter);
                    edtxt.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        // ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.listviewlayout,R.id.textView1,arr);


//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), arr[position], Toast.LENGTH_SHORT).show();
//            }
//        });

    }

}
