package com.example.didpoolfit;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPage_1 extends AppCompatActivity {

    TextView tV_CA;
    Button bt_register;
    EditText ET_FN;
    TextInputLayout TIL_FN;
    EditText ET_EA;
    TextInputLayout TIL_EA;
    EditText ET_P;
    TextInputLayout TIL_P;
    EditText ET_RP;
    TextInputLayout TIL_RP;
    CheckBox chB;

    public boolean allChecked = true;

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

        bt_register = findViewById(R.id.register_bt);
        chB = findViewById(R.id.chBox);

        ET_FN = findViewById(R.id.fullName);
        TIL_FN = findViewById(R.id.fullName_t);
        ET_EA = findViewById(R.id.email);
        TIL_EA = findViewById(R.id.email_t);
        ET_P = findViewById(R.id.password_toggle);
        TIL_P = findViewById(R.id.password_toggle_t);
        ET_RP = findViewById(R.id.repeat_password_toggle);
        TIL_RP = findViewById(R.id.repeat_password_toggle_t);

        Pattern ptEA = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Pattern ptP = Pattern.compile("(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");

        View.OnClickListener oclRegister = v -> {
            Matcher mchEA = ptEA.matcher(ET_EA.getText().toString());
            boolean EA_TRUE = mchEA.matches();
            Matcher mchP = ptP.matcher(ET_P.getText().toString());
            boolean P_SECURE = mchP.matches();

            if (ET_FN.getText().toString().isEmpty()) {
                allChecked = false;
                TIL_FN.setError("Fill in all the fields");
            } else {
                TIL_FN.setError(null);
                allChecked = true;
            }

            if (ET_EA.getText().toString().isEmpty()) {
                allChecked = false;
                TIL_EA.setError("Fill in all the fields");
            } else {
                if (!EA_TRUE) {
                    allChecked = false;
                    TIL_EA.setError("Check that the date is filled in correctly");
                } else {
                    TIL_EA.setError(null);
                    allChecked = true;
                }
            }

            if (ET_P.getText().toString().isEmpty()) {
                allChecked = false;
                TIL_P.setError("Fill in all the fields");
            } else {
                if (!P_SECURE) {
                    allChecked = false;
                    TIL_P.setError("The password is not secure");
                } else {
                    TIL_P.setError(null);
                    allChecked = true;
                }
            }

            if (!ET_P.getText().toString().equals(ET_RP.getText().toString())) {
                allChecked = false;
                TIL_RP.setError("Password don't match");
            } else {
                TIL_RP.setError(null);
                allChecked = true;
            }

            if (!chB.isChecked()) {
                allChecked = false;
            } else {
                allChecked = true;
            }

            if (allChecked) {
                Intent intent = new Intent(getApplicationContext(), RegisterPage_2.class);
                startActivity(intent);
                finish();
            }
        };

        bt_register.setOnClickListener(oclRegister);
    }
}