package ru.mirea.zherebtsov.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import ru.mirea.zherebtsov.data_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	=	ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.textView.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.textView.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.textView.setText("runn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.textView.postDelayed(runn3, 2000);
                    binding.textView.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}