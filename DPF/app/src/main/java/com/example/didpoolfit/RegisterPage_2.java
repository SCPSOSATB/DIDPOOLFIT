package com.example.didpoolfit;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPage_2 extends AppCompatActivity {

    TextView tV_CT;
    Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page2);

        int[] color = {Color.parseColor("#CC8FED"), Color.parseColor("#6B50F6")};
        float[] position = {0, 1};
        Shader.TileMode tile_mode = Shader.TileMode.REPEAT;
        Shader shader_gradient = new LinearGradient(0, 0, 0, 35, color, position, tile_mode);
        tV_CT = findViewById(R.id.completeText);
        tV_CT.getPaint().setShader(shader_gradient);

        View.OnClickListener oclNext = v -> {
            Intent intent = new Intent(getApplicationContext(), RegisterPage_3_1.class);
            startActivity(intent);
            finish();
        };

        btNext = findViewById(R.id.bt_next);
        btNext.setOnClickListener(oclNext);
    }
}