package com.example.prashiksha.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.prashiksha.R;
import com.example.prashiksha.databinding.FragmentHomeBinding;

public class HomeFragment2 extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel2 homeViewModel2 =
                new ViewModelProvider(this).get(HomeViewModel2.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel2.getText().observe(getViewLifecycleOwner(), textView::setText);
        return inflater.inflate(R.layout.fragment_home2, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}