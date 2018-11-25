package id.ac.unej.ilkom.simulatour.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Models.Simulasi;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.R;

public class SimulatorDetailActivity extends AppCompatActivity {
    @BindView(R.id.img)
    NetworkImageView img;

    @BindView(R.id.txtDeskripsi)
    TextView txtDeskripsi;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private Simulasi simulasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulator_detail);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        simulasi = (Simulasi) getIntent().getSerializableExtra("simulasi");

        getSupportActionBar().setTitle(simulasi.getNama());
        img.setImageUrl(simulasi.getFoto(),imageLoader);
        //txtDeskripsi.setText(Html.fromHtml(simulasi.getDeskripsi()));

        //Toast.makeText(this,wisata.getFoto(),Toast.LENGTH_LONG).show();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                    finish();
                }
            });
        }
    }
}
