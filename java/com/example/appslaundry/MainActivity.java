package com.example.appslaundry;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appslaundry.layanan.LayananActivity;
import com.example.appslaundry.pelanggan.PelangganActivity;

public class MainActivity extends AppCompatActivity {

    String username;
    CardView cvLaundry, cvLayanan, cvPelanggan, cvPromo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Kenalkan widget
        cvLaundry = (CardView) findViewById(R.id.CVLaundry);
        cvLayanan = (CardView) findViewById(R.id.CVLayanan);
        cvPelanggan = (CardView) findViewById(R.id.CVPlanggan);
        cvPromo = (CardView) findViewById(R.id.CVPromo);

        // event handler ketika cardview laundry di click
        cvLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LaundryActivity.class);
                startActivity(intent);
            }
        });

        // event handler ketika cardview Layanan di click
        cvLayanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ganti dengan Intent yang sesuai untuk layanan
                Intent intent = new Intent(MainActivity.this, LayananActivity.class);
                startActivity(intent);
            }
        });

        // event handler ketika cardview Pelanggan di click
        cvPelanggan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ganti dengan Intent yang sesuai untuk pelanggan
                Intent intent = new Intent(MainActivity.this, PelangganActivity.class);
                startActivity(intent);
            }
        });

        // event handler ketika cardview Promo di click
        cvPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ganti dengan Intent yang sesuai untuk promo
                Intent intent = new Intent(MainActivity.this, PromoActivity.class);
                startActivity(intent);
            }
        });

        username = getIntent().getStringExtra("username");
        Toast.makeText(this, "" + username, Toast.LENGTH_SHORT).show();
    }
}