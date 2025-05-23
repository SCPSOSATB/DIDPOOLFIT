package com.example.didpoolfit;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPage_1 extends AppCompatActivity {

    TextView tV_CA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page1);

        int[] color = {Color.parseColor("#CC8FED"), Color.parseColor("#6B50F6")};
        float[] position = {0, 1};
        Shader.TileMode tile_mode = Shader.TileMode.REPEAT;
        Shader shader_gradient = new LinearGradient(0, 0, 0, 35, color, position, tile_mode);
        tV_CA = findViewById(R.id.createAccountText);
        tV_CA.getPaint().setShader(shader_gradient);
    }
}