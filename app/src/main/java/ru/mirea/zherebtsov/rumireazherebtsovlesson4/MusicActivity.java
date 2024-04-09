package ru.mirea.zherebtsov.rumireazherebtsovlesson4;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import ru.mirea.zherebtsov.rumireazherebtsovlesson4.databinding.ActivityMusicBinding;

public class MusicActivity extends AppCompatActivity {

    private ActivityMusicBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}