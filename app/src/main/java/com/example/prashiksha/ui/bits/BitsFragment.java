package com.example.prashiksha.ui.bits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prashiksha.R;
import com.example.prashiksha.databinding.FragmentBitsBinding;

import java.util.ArrayList;
import java.util.List;

public class BitsFragment extends Fragment {

    private FragmentBitsBinding binding;
    private VideoAdapter videoAdapter;
    private List<Video> videoList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BitsViewModel bitsViewModel =
                new ViewModelProvider(this).get(BitsViewModel.class);

        binding = FragmentBitsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize the RecyclerView
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        // Sample data for videos
        videoList = new ArrayList<>();
        videoList.add(new Video(R.raw.video1));
        videoList.add(new Video(R.raw.video2));
        videoList.add(new Video(R.raw.video3));

        // Initialize the adapter and set it to the RecyclerView
        videoAdapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(videoAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
