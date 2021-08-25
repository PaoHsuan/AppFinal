package com.example.loginsqlite.ui.User;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginsqlite.DBHelper;
import com.example.loginsqlite.MainActivity;
import com.example.loginsqlite.R;

import java.util.ArrayList;


public class UserFragment extends Fragment {

    private com.example.loginsqlite.ui.User.UserViewModel UserViewModel;
    DBHelper DB;
    ArrayList<String>name_c,pwd_c,sex_c,birth_c,nick_c,type_c;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserViewModel =
                new ViewModelProvider(this).get(UserViewModel.class);

        //binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = inflater.inflate(R.layout.fragment_user, container, false);

        //final TextView textView = root.findViewById(R.id.text_user);
        /*UserViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Bundle bundle = getActivity().getIntent().getExtras();
                String name = bundle.getString("MESSAGE");
                Log.d("user",name);
            }
        });*/

        DB = new DBHelper(this.getActivity());
        /*name_c = new ArrayList<>();
        pwd_c  = new ArrayList<>();
        sex_c = new ArrayList<>();
        birth_c = new ArrayList<>();
        nick_c = new ArrayList<>();
        type_c = new ArrayList<>();
        storeDataInArrays();*/
        /*TextView name_d = (TextView) root.findViewById(R.id.name_d);
        TextView sex_d = (TextView) root.findViewById(R.id.sex_d);
        TextView birth_d = (TextView) root.findViewById(R.id.birth_d);
        TextView nick_d = (TextView) root.findViewById(R.id.nick_d);
        TextView type_d = (TextView) root.findViewById(R.id.type_d);*/

        return root;
    }
    /*void storeDataInArrays(){
        Cursor cursor = DB.readAllData();

        if(cursor.getCount() == 0){
            Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                name_c.add(cursor.getString(0));
                pwd_c.add(cursor.getString(1));
                sex_c.add(cursor.getString(2));
                birth_c.add(cursor.getString(3));
                nick_c.add(cursor.getString(4));
                type_c.add(cursor.getString(5));
            }
        }
    }*/
    public void readAllData(View view){
        DBHelper dbHelper =  new DBHelper(getActivity());
        Cursor result = dbHelper.readAllData();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        DBHelper dbHelper =  new DBHelper(getActivity());
        SQLiteDatabase MyDB = dbHelper.getWritableDatabase();
        TextView name_d = (TextView) getView().findViewById(R.id.name_d);
        TextView sex_d = (TextView) getView().findViewById(R.id.sex_d);
        TextView birth_d = (TextView) getView().findViewById(R.id.birth_d);
        TextView nick_d = (TextView) getView().findViewById(R.id.nick_d);
        TextView type_d = (TextView) getView().findViewById(R.id.type_d);

        Bundle bundle = getActivity().getIntent().getExtras();
        String name = bundle.getString("MESSAGE");
        Log.d("user2",name);


        Cursor c=MyDB.rawQuery("SELECT * FROM users WHERE username = '"+name+"'", null);
        if(c.moveToNext())
        {
            Log.d("username",name);
            name_d.setText(c.getString(0));
            sex_d.setText(c.getString(2));
            birth_d.setText(c.getString(3));
            nick_d.setText(c.getString(4));
            type_d.setText(c.getString(5));
        }
        else
        {
            Toast.makeText(getActivity(), "There was an error in compiling", Toast.LENGTH_SHORT).show();
        }
    }

}
