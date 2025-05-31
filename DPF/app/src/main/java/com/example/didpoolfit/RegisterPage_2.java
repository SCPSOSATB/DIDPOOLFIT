package com.example.didpoolfit;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class RegisterPage_2 extends AppCompatActivity {

    TextView tV_CT;
    Button btNext;
    EditText ET_CG;
    TextInputLayout TIL_CG;
    EditText ET_DOB;
    TextInputLayout TIL_DOB;
    EditText ET_YW;
    TextInputLayout TIL_YW;
    EditText ET_YH;
    TextInputLayout TIL_YH;

    public boolean allChecked = true;

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

        btNext = findViewById(R.id.bt_next);

        ET_CG = findViewById(R.id.chooseGender);
        TIL_CG = findViewById(R.id.chooseGender_t);
        ET_DOB = findViewById(R.id.date_of_birth);
        TIL_DOB = findViewById(R.id.date_of_birth_t);
        ET_YW = findViewById(R.id.your_weight);
        TIL_YW = findViewById(R.id.your_weight_t);
        ET_YH = findViewById(R.id.your_height);
        TIL_YH = findViewById(R.id.your_height_t);

        View.OnClickListener oclNext = v -> {
            if (ET_CG.getText().toString().isEmpty()) {
                allChecked = false;
                TIL_CG.setError("Fill in all the fields");
            } else {
                TIL_CG.setError(null);
            }

            if (ET_DOB.getText().toString().isEmpty()) {
                allChecked = false;
                TIL_DOB.setError("Fill in all the fields");
            } else {
                TIL_DOB.setError(null);
            }

            if (ET_YW.getText().toString().isEmpty()) {
                allChecked = false;
                TIL_YW.setError("Fill in all the fields");
            } else {
                TIL_YW.setError(null);
            }

            if (ET_YH.getText().toString().isEmpty()) {
                allChecked = false;
                TIL_YH.setError("Fill in all the fields");
            } else {
                TIL_YH.setError(null);
            }

            if (allChecked) {
                Intent intent = new Intent(getApplicationContext(), RegisterPage_3_1.class);
                startActivity(intent);
                finish();
            }
        };

        btNext.setOnClickListener(oclNext);
    }
}