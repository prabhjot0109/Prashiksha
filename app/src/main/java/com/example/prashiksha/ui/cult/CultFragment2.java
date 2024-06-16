package com.example.prashiksha.ui.cult;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.prashiksha.R;
import com.example.prashiksha.databinding.FragmentCultBinding;

public class CultFragment2 extends Fragment {

    private FragmentCultBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CultViewModel2 cultViewModel2 =
                new ViewModelProvider(this).get(CultViewModel2.class);

        binding = FragmentCultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCult;
        cultViewModel2.getText().observe(getViewLifecycleOwner(), textView::setText);
        return inflater.inflate(R.layout.fragment_cult2, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}