package id.ac.unej.ilkom.simulatour.Activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Models.Wisata;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.Networks.BaseApi;
import id.ac.unej.ilkom.simulatour.R;

public class WisataDetailActivity extends AppCompatActivity {
    @BindView(R.id.img)
    NetworkImageView img;

    @BindView(R.id.txtDeskripsi)
    TextView txtDeskripsi;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsing)
    CollapsingToolbarLayout collapsingToolbarLayout;

    private ImageLoader imageLoader=AppController.getInstance().getImageLoader();
    private Wisata wisata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        wisata = (Wisata) getIntent().getSerializableExtra("wisata");
        getSupportActionBar().setTitle(wisata.getNama());
        img.setImageUrl(wisata.getFoto(),imageLoader);

        //Toast.makeText(this,wisata.getFoto(),Toast.LENGTH_LONG).show();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                    finish();
                }
            });
        }
        txtDeskripsi.setText(wisata.getDeskripsi());
    }
}
