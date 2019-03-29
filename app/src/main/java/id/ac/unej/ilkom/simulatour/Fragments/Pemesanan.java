package id.ac.unej.ilkom.simulatour.Fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Activities.MainActivity;
import id.ac.unej.ilkom.simulatour.Adapters.PemesananAdapter;
import id.ac.unej.ilkom.simulatour.R;

public class Pemesanan extends AppCompatActivity {
    @BindView(R.id.btnOke)
    Button btnOke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);
        ButterKnife.bind(this);
        btnOke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pemesanan.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
