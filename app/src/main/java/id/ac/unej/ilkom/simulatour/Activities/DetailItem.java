package id.ac.unej.ilkom.simulatour.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.R;

public class DetailItem extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.imgDetail)
    ImageView imgDetail;

    @BindView(R.id.txtTitleDetail)
    TextView txtTitle;

    @BindView(R.id.txtDescDetail)
    TextView txtDesc;

    @BindView(R.id.btnMap)
    Button btnMap;

    String title, img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        ButterKnife.bind(this);

        title = getIntent().getStringExtra("title");
        img = getIntent().getStringExtra("img");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        Glide.with(this)
                .load(img)
                .into(imgDetail);
//        imgDetail.setImageResource(img);
        txtTitle.setText(title);
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

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                //lat,long
                Uri gmmIntentUri = Uri.parse("geo:-8.0588232,114.2352035");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
