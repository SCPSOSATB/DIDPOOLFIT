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

import java.util.regex.Pattern;

public class RegisterPage_3_1 extends AppCompatActivity {

    TextView tv_TP;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt_confirm;

    public boolean bt1_ch = true;
    public boolean bt2_ch = false;
    public boolean bt3_ch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page3_1);

        int[] color = {Color.parseColor("#CC8FED"), Color.parseColor("#6B50F6")};
        float[] position = {0, 1};
        Shader.TileMode tile_mode = Shader.TileMode.REPEAT;
        Shader shader_gradient = new LinearGradient(0, 0, 0, 35, color, position, tile_mode);
        tv_TP = findViewById(R.id.textTop);
        tv_TP.getPaint().setShader(shader_gradient);

        bt1 = findViewById(R.id.bt_1);
        bt2 = findViewById(R.id.bt_2);
        bt3 = findViewById(R.id.bt_3);
        bt_confirm = findViewById(R.id.bt_confirm);

        View.OnClickListener oclChooseBt1 = v -> {

            if (!bt1_ch) {
                bt1.setBackgroundColor(Color.parseColor("#6B50F6"));
                bt2.setBackgroundColor(Color.parseColor("#60595656"));
                bt3.setBackgroundColor(Color.parseColor("#60595656"));
                bt1_ch = true;
                bt2_ch = false;
                bt3_ch = false;
            }
        };

        View.OnClickListener oclChooseBt2 = v -> {
            if (!bt2_ch) {
                bt2.setBackgroundColor(Color.parseColor("#6B50F6"));
                bt1.setBackgroundColor(Color.parseColor("#60595656"));
                bt3.setBackgroundColor(Color.parseColor("#60595656"));
                bt2_ch = true;
                bt1_ch = false;
                bt3_ch = false;
            }
        };

        View.OnClickListener oclChooseBt3 = v -> {

            if (!bt3_ch) {
                bt3.setBackgroundColor(Color.parseColor("#6B50F6"));
                bt1.setBackgroundColor(Color.parseColor("#60595656"));
                bt2.setBackgroundColor(Color.parseColor("#60595656"));
                bt3_ch = true;
                bt1_ch = false;
                bt2_ch = false;
            }
        };

        View.OnClickListener oclConfirm = v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        };

        bt1.setOnClickListener(oclChooseBt1);
        bt2.setOnClickListener(oclChooseBt2);
        bt3.setOnClickListener(oclChooseBt3);

        bt_confirm.setOnClickListener(oclConfirm);
    }
}