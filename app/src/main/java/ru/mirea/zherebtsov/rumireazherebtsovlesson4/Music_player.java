package ru.mirea.zherebtsov.rumireazherebtsovlesson4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;



import ru.mirea.zherebtsov.rumireazherebtsovlesson4.databinding.FragmentMusicPlayerBinding;
public class Music_player extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private FragmentMusicPlayerBinding binding;
    public	void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = FragmentMusicPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }



}