package com.example.prashiksha.ui.bits;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.google.android.exoplayer2.MediaItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prashiksha.R;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videoList;

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
            // Initialize ExoPlayer and set the video resource ID
            SimpleExoPlayer player = new SimpleExoPlayer.Builder(itemView.getContext()).build();
            playerView.setPlayer(player);

            // Create a URI for the video resource
            Uri videoUri = Uri.parse("android.resource://" + itemView.getContext().getPackageName() + "/" + video.getResourceId());

            // Create a MediaItem for the video URI
            MediaItem mediaItem = MediaItem.fromUri(videoUri);

            // Set the media item to the player
            player.setMediaItem(mediaItem);

            // Prepare the player
            player.prepare();

            // Start playback
            player.play();

            // Set click listeners for like, comment, and share
            btnLike.setOnClickListener(v -> {
                // Handle like action
            });

            btnComment.setOnClickListener(v -> {
                // Handle comment action
            });

            btnShare.setOnClickListener(v -> {
                // Handle share action
            });
        }
    }
}
