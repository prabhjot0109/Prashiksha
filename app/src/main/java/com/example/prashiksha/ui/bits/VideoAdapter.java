package com.example.prashiksha.ui.bits;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prashiksha.R;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videoList;
    private SimpleExoPlayer currentPlayer;

    public VideoAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videoList.get(position);
        holder.bind(video);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public void releasePlayer() {
        if (currentPlayer != null) {
            currentPlayer.release();
            currentPlayer = null;
        }
    }

    public void playVideoAtPosition(RecyclerView recyclerView, int position) {
        if (position >= 0 && position < videoList.size()) {
            // Release any previous player
            releasePlayer();

            // Get the ViewHolder at the specified position
            RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
            if (viewHolder instanceof VideoViewHolder) {
                VideoViewHolder videoViewHolder = (VideoViewHolder) viewHolder;

                // Initialize ExoPlayer for the new position
                currentPlayer = new SimpleExoPlayer.Builder(recyclerView.getContext()).build();
                videoViewHolder.playerView.setPlayer(currentPlayer);

                Uri videoUri = Uri.parse(videoList.get(position).getVideoUrl());
                MediaItem mediaItem = MediaItem.fromUri(videoUri);
                currentPlayer.setMediaItem(mediaItem);
                currentPlayer.prepare();
                currentPlayer.play();
            }
        }
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {

        private PlayerView playerView;
        private ImageButton btnLike, btnComment, btnShare;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            playerView = itemView.findViewById(R.id.playerView);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnComment = itemView.findViewById(R.id.btnComment);
            btnShare = itemView.findViewById(R.id.btnShare);
        }

        public void bind(Video video) {
            // No need to initialize the player here
        }
    }
}
