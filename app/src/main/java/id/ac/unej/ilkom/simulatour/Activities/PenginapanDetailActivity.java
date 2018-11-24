package id.ac.unej.ilkom.simulatour.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Models.Penginapan;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.R;

public class PenginapanDetailActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.img)
    NetworkImageView img;

    private ImageLoader imageLoader=AppController.getInstance().getImageLoader();
    private Penginapan penginapan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penginapan_detail);
        ButterKnife.bind(this);

        penginapan = (Penginapan) getIntent().getSerializableExtra("penginapan");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(penginapan.getNama());
        img.setImageUrl(penginapan.getFoto(),imageLoader);

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
