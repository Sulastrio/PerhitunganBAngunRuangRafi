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

public class Lingkaran extends AppCompatActivity {

    private EditText textJari;
    private TextView textHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lingkaran);
        textJari = findViewById(R.id.TextJari);
        textHasil = findViewById(R.id.TextHasil);
        Button Button6 = findViewById(R.id.button6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button6.setOnClickListener(view -> hitungLuas());
    }
    private void hitungLuas() {
        String inputJari = textJari.getText().toString();
        if (inputJari.isEmpty()) {
            Toast.makeText(this, "Masukan panjang sisi", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double jari = Double.parseDouble(inputJari);
            double luas = Math.PI * jari * jari;
            textHasil.setText(""+luas);
        }catch (NumberFormatException e) {
            Toast.makeText(this, "Input Tidak Valid", Toast.LENGTH_SHORT).show();
        }
    }
}