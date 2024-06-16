package com.example.prashiksha.ui.resources;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.prashiksha.R;
import com.example.prashiksha.databinding.FragmentResourcesBinding;

public class ResourcesFragment2 extends Fragment {

    private FragmentResourcesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ResourcesViewModel2 resourcesViewModel2 =
                new ViewModelProvider(this).get(ResourcesViewModel2.class);

        binding = FragmentResourcesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textResources;
        resourcesViewModel2.getText().observe(getViewLifecycleOwner(), textView::setText);
        return inflater.inflate(R.layout.fragment_resources2, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}