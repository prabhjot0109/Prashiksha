package com.example.prashiksha.ui.fix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.prashiksha.databinding.FragmentFixBinding;

public class FixFragment extends Fragment {

    private FragmentFixBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FixViewModel fixViewModel =
                new ViewModelProvider(this).get(FixViewModel.class);

        binding = FragmentFixBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFix;
        fixViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}