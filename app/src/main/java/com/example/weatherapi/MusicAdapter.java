package com.example.weatherapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {
    private List<Music> musicList;

    public MusicAdapter(List<Music> musicList) {
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Créez et retournez une instance de MusicViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reclylerview_music, parent, false);
        return new MusicViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        // Appelez la méthode bind du MusicViewHolder pour lier les données à la vue
        holder.getArtistTextView().setText(musicList.get(position).getArtist());
        holder.getTitleTextView().setText(musicList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        // Retournez le nombre d'éléments dans la liste de musique
        return musicList.size();
    }
}

