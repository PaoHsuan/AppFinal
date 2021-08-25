package com.example.loginsqlite.ui.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginsqlite.HomeActivity;
import com.example.loginsqlite.MainActivity;
import com.example.loginsqlite.MusicTypeActivity;
import com.example.loginsqlite.R;


public class MenuFragment extends Fragment {

    private MenuViewModel MenuViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MenuViewModel =
                new ViewModelProvider(this).get(MenuViewModel.class);

        //binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        //final TextView textView = root.findViewById(R.id.text_menu);
        /*MenuViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        Button btnChinese = (Button)root.findViewById(R.id.chinese);
        Button btnEnglish = (Button)root.findViewById(R.id.english);
        Button btnKorean = (Button)root.findViewById(R.id.korean);
        Button btnJapanese = (Button)root.findViewById(R.id.japanese);
        Button btnClassical = (Button)root.findViewById(R.id.classical);
        Button btnElectronic = (Button)root.findViewById(R.id.electronic);

        btnChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String message = "1";
                        Intent intent = new Intent(MenuFragment.this.getContext(), MusicTypeActivity.class);
                        //intent.setClass(MenuFragment.this, MusicTypeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("MESSAGE", message);
                        Log.d("1: ",message);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String message = "2";
                        Intent intent = new Intent(MenuFragment.this.getContext(), MusicTypeActivity.class);
                        //intent.setClass(MenuFragment.this, MusicTypeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("MESSAGE", message);
                        Log.d("1: ",message);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });
        btnKorean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String message = "3";
                        Intent intent = new Intent(MenuFragment.this.getContext(), MusicTypeActivity.class);
                        //intent.setClass(MenuFragment.this, MusicTypeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("MESSAGE", message);
                        Log.d("1: ",message);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });
        btnJapanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String message = "4";
                        Intent intent = new Intent(MenuFragment.this.getContext(), MusicTypeActivity.class);
                        //intent.setClass(MenuFragment.this, MusicTypeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("MESSAGE", message);
                        Log.d("1: ",message);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });
        btnClassical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String message = "5";
                        Intent intent = new Intent(MenuFragment.this.getContext(), MusicTypeActivity.class);
                        //intent.setClass(MenuFragment.this, MusicTypeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("MESSAGE", message);
                        Log.d("1: ",message);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });
        btnElectronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String message = "6";
                        Intent intent = new Intent(MenuFragment.this.getContext(), MusicTypeActivity.class);
                        //intent.setClass(MenuFragment.this, MusicTypeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("MESSAGE", message);
                        Log.d("1: ",message);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }, 1000);
            }
        });

        return root;
    }


}