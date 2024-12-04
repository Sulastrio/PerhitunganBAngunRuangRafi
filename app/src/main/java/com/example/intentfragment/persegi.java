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

public class persegi extends AppCompatActivity {

    private EditText inputPersegi;
    private TextView textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_persegi);
        inputPersegi = findViewById(R.id.input_persegi);
        textHasil = findViewById(R.id.texthasil);
        Button buttonHitung = findViewById(R.id.buttonhitung);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonHitung.setOnClickListener(v -> hitungLuas());
    }
    private void hitungLuas(){
        String sisiText = inputPersegi.getText().toString();
        if (sisiText.isEmpty()){
            Toast.makeText(this, "Masukan panjang sisi", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double sisi = Double.parseDouble(sisiText);
            double luas = sisi * sisi;
            textHasil.setText(""+luas);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Input Tidak Valid", Toast.LENGTH_SHORT).show();
        }
    }
}