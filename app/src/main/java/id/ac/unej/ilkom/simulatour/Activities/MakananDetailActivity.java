package id.ac.unej.ilkom.simulatour.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Models.Makanan;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.R;

public class MakananDetailActivity extends AppCompatActivity {
    @BindView(R.id.img)
    NetworkImageView img;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtDeskripsi)
    TextView txtDeskripsi;

    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private Makanan makanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        makanan = (Makanan) getIntent().getSerializableExtra("makanan");
        getSupportActionBar().setTitle(makanan.getNama());
        img.setImageUrl(makanan.getFoto(), imageLoader);
        txtDeskripsi.setText(makanan.getNama()+" mempunyai alamat di "+ makanan.getAlamat()+". Makanan Khas dari " + makanan.getNama() + " adalah " + makanan.getMenuKhas());
        getSupportActionBar().setTitle(makanan.getNama());
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
    }
}
