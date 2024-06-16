package com.example.prashiksha.ui.fix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.prashiksha.R;
import com.example.prashiksha.databinding.FragmentFixBinding;

public class FixFragment2 extends Fragment {

    private FragmentFixBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FixViewModel2 fixViewModel2 =
                new ViewModelProvider(this).get(FixViewModel2.class);

        binding = FragmentFixBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFix;
        fixViewModel2.getText().observe(getViewLifecycleOwner(), textView::setText);
        return inflater.inflate(R.layout.fragment_fix2, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}