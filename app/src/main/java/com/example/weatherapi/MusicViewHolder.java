package com.example.weatherapi;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapi.databinding.ActivityMainBinding;
import com.example.weatherapi.databinding.ReclylerviewMusicBinding;


public class MusicViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;
    private TextView artistTextView;

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);
        this.titleTextView = itemView.findViewById(R.id.titre);
        this.artistTextView = itemView.findViewById(R.id.artist);

    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getArtistTextView() {
        return artistTextView;
    }
}

