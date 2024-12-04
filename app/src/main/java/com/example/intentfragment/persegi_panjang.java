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

public class persegi_panjang extends AppCompatActivity {

    private EditText textPanjang, textHasil;
    private TextView textLebar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_persegi_panjang);
        textPanjang = findViewById(R.id.Text_Panjang);
        textLebar = findViewById(R.id.TextLebar);
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
        String sisiText1 = textPanjang.getText().toString();
        String sisiText2 = textLebar.getText().toString();
        if (sisiText1.isEmpty()){
            Toast.makeText(this, "Masukan panjang sisi", Toast.LENGTH_SHORT).show();
            if (sisiText2.isEmpty()){
                Toast.makeText(this, "Masukan panjang sisi", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        try {
            double sisi1 = Double.parseDouble(sisiText1);
            double sisi2 = Double.parseDouble(sisiText2);
            double luas = sisi1 * sisi2;
            textHasil.setText(""+luas);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Input Tidak Valid", Toast.LENGTH_SHORT).show();
        }
    }
}