package com.example.didpoolfit;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class WelcomeScreen extends AppCompatActivity {

    TextView tV_WT;
    TextView tV_Debug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        int[] color = {Color.parseColor("#CC8FED"), Color.parseColor("#6B50F6")};
        float[] position = {0, 1};
        Shader.TileMode tile_mode = Shader.TileMode.REPEAT;
        Shader shader_gradient = new LinearGradient(0, 0, 0, 35, color, position, tile_mode);
        tV_WT = findViewById(R.id.welcomeText);
        tV_WT.getPaint().setShader(shader_gradient);

        Intent intent = new Intent(this, RegisterPage_1.class);

        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                tV_Debug.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
            }

            public void onFinish() {
                tV_Debug.setText("DONE");
                startActivity(intent);
                finish();
            }
        }.start();
    }
}