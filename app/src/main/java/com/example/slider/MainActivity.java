package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.slider.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private int randomNumber;
    private int round = 0;
    private int score = 0;
    private int highestScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        round();

        binding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        binding.btHitMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void round(){
        round += 1;
        binding.slider.setValue(50.0f);
        Random random = new Random();
        randomNumber = random.nextInt(101); //(0-100)
        String targetMessage = "Pon el slider lo más cercano al número" + randomNumber;
        binding.tvTarget.setText(targetMessage);

        String roundMessage = "Ronda " + round;
        binding.tvRound.setText(roundMessage);

        String scoreMessage = "Ronda " + score;
        binding.tvScore.setText(scoreMessage);

        String highestScoreMessage = "Puntaje más alto: " + highestScore;
        binding.tvHighestScore.setText(highestScoreMessage);


    }
}