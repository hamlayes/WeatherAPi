package com.example.weatherapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapi.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private TextView temp;
    EditText ville;
    private RecyclerView music;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ville = findViewById(R.id.editTextVille);
        music = findViewById(R.id.music);

        ville.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                String location = ville.getText().toString().trim();

                if (!location.isEmpty()) {
                    OpenWeatherServices service =
                            RetrofitClientInstance.getRetrofitInstance().create(OpenWeatherServices.class);
                    String apiKey= "e075a0b59517e88cc46940bb262add13";
                    Call<ForecastData> call = service.getForecast(location,apiKey,"metric");




                    List<Music> recommendedSongs = filterSongsByTemperature();
                    MusicAdapter musicAdapter = new MusicAdapter(recommendedSongs);
                    music.setAdapter(musicAdapter);
                    music.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                    call.enqueue(new Callback<ForecastData>() {
                        @Override
                        public void onResponse(Call<ForecastData> call, Response<ForecastData> response) {
                            if (response.isSuccessful()) {
                                ForecastData donnee = response.body();
                                binding.temp.setText(String.valueOf(donnee.getPrevisions().get(0).weather.getTemp()));
                            } else {
                                // Gérez les erreurs de réponse, par exemple, affichez un message d'erreur
                                Log.e("MainActivity", "Erreur de réponse de l'API. Code : " + response.code());
                                Toast.makeText(MainActivity.this, "Erreur de réponse de l'API", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ForecastData> call, Throwable t) {
                            // Gérez les erreurs lors de l'appel à l'API
                            Log.e("MainActivity", "Erreur lors de l'appel à l'API", t);

                            Toast.makeText(MainActivity.this, "Une erreur est survenue !", Toast.LENGTH_SHORT).show();
                        }

                    });
                }
                return true; // Indique que l'événement a été traité
            }
            return false; // Indique que l'événement n'a pas été traité
        });

    }

    private List<Music> filterSongsByTemperature() {
        List<Music> allSongs = new ArrayList<>();
        allSongs.add(new Music("Capri", "Kekra",10));
        allSongs.add(new Music("Bolide Allemand", "SDM", 32));
        allSongs.add(new Music("Never going home", "Kungs", 9));

        List<Music> recommendedSongs = new ArrayList<>();
        for (Music music : allSongs) {
            if (music.getDegre()>=20 && music.getDegre()< 40) {
                recommendedSongs.add(music);
            }
            else if (music.getDegre()>10 && music.getDegre()< 20) {
                recommendedSongs.add(music);
            }
            else {
                recommendedSongs.add(music);
            }
        }
        return recommendedSongs;
    }

}

