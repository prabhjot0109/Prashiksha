package com.example.prashiksha.ui.bits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.prashiksha.databinding.FragmentBitsBinding;

public class BitsFragment extends Fragment {

    private FragmentBitsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BitsViewModel bitsViewModel =
                new ViewModelProvider(this).get(BitsViewModel.class);

        binding = FragmentBitsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBits;
        bitsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}