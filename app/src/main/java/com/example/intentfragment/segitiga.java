package com.example.intentfragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class segitiga extends AppCompatActivity {

    private EditText textAlas, textTinggi;
    private TextView textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segitiga);
        textAlas = findViewById(R.id.TextAlas);
        textTinggi = findViewById(R.id.TextTinggi);
        textHasil = findViewById(R.id.TextHasil);
        Button Button3 = findViewById(R.id.button3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button3.setOnClickListener(v -> hitungLuas());
    }
    private void hitungLuas() {
        String inputAlas = textAlas.getText().toString();
        String inputTinggi = textTinggi.getText().toString();
        if (inputAlas.isEmpty()) {
            Toast.makeText(this, "Masukan Alas", Toast.LENGTH_SHORT).show();
            if (inputTinggi.isEmpty()){
                Toast.makeText(this, "Masukan Tinggi", Toast.LENGTH_SHORT).show();
            }
        }
        try {
            double Alas = Double.parseDouble(inputAlas);
            double Tinggi = Double.parseDouble(inputTinggi);
            double luas = 0.5 * Alas * Tinggi;
            textHasil.setText(""+luas);
        }catch (NumberFormatException e) {
            Toast.makeText(this, "Input Tidak Valid", Toast.LENGTH_SHORT).show();
        }
    }
}