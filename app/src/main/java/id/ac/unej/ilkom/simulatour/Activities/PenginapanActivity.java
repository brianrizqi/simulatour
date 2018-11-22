package id.ac.unej.ilkom.simulatour.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Adapters.PenginapanAdapter;
import id.ac.unej.ilkom.simulatour.Models.mPenginapan;
import id.ac.unej.ilkom.simulatour.R;

public class PenginapanActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.titleMain)
    Button button;
    private ListView listView;
    private PenginapanAdapter adapter;
    private List<mPenginapan> list;
    private String detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penginapan);
        ButterKnife.bind(this);
        button.setText("Penginapan");
        setSupportActionBar(toolbar);
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
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listHome);
        list.add(new mPenginapan("1", "", "Judul1","10000"));
        adapter = new PenginapanAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);
    }
}
