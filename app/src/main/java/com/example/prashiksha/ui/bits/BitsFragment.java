package com.example.prashiksha.ui.bits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prashiksha.R;
import com.example.prashiksha.databinding.FragmentBitsBinding;

import java.util.ArrayList;
import java.util.List;

public class BitsFragment extends Fragment {

    private FragmentBitsBinding binding;
    private VideoAdapter videoAdapter;
    private List<Video> videoList;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BitsViewModel bitsViewModel =
                new ViewModelProvider(this).get(BitsViewModel.class);

        binding = FragmentBitsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        // Sample data for videos
        videoList = new ArrayList<>();
        videoList.add(new Video("https://www.youtube.com/shorts/nwaFReaoU0s"));
        videoList.add(new Video("https://www.youtube.com/shorts/SDuQXckfST4"));
        videoList.add(new Video("https://www.youtube.com/shorts/nW0l8wp8QX4"));

        videoAdapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(videoAdapter);

        // Set up PagerSnapHelper for snapping behavior
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);

        // Add scroll listener to manage video playback
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int position = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    videoAdapter.playVideoAtPosition(recyclerView, position);
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        videoAdapter.releasePlayer();
        binding = null;
    }
}
