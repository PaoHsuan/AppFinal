package com.example.loginsqlite.ui.User;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginsqlite.DBHelper;
import com.example.loginsqlite.R;


public class UserFragment extends Fragment {

    private com.example.loginsqlite.ui.User.UserViewModel UserViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserViewModel =
                new ViewModelProvider(this).get(UserViewModel.class);

        //binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = inflater.inflate(R.layout.fragment_user, container, false);

        final TextView textView = root.findViewById(R.id.text_user);
        UserViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


                textView.setText(s);
            }
        });
        TextView name_d = (TextView) root.findViewById(R.id.name_d);
        TextView sex_d = (TextView) root.findViewById(R.id.sex_d);
        TextView birth_d = (TextView) root.findViewById(R.id.birth_d);
        TextView nick_d = (TextView) root.findViewById(R.id.nick_d);
        TextView type_d = (TextView) root.findViewById(R.id.type_d);

        return root;
    }

    /*public void readAllData(View view){
        DBHelper dbHelper =  new DBHelper(this);
        Cursor result = dbHelper.readAllData();
    }*/
}
