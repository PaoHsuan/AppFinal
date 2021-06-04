package com.example.loginsqlite.ui.Menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginsqlite.R;
import com.example.loginsqlite.databinding.FragmentNotificationsBinding;

public class MenuFragment extends Fragment {

    private MenuViewModel MenuViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MenuViewModel =
                new ViewModelProvider(this).get(MenuViewModel.class);

        //binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        final TextView textView = root.findViewById(R.id.text_menu);
        MenuViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}