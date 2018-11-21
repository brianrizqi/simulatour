package id.ac.unej.ilkom.simulatour.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.ilkom.simulatour.Adapters.TransportasiAdapter;
import id.ac.unej.ilkom.simulatour.Models.mTransportasi;
import id.ac.unej.ilkom.simulatour.R;

public class TransportasiActivity extends AppCompatActivity {
    private ListView listView;
    private TransportasiAdapter adapter;
    private List<mTransportasi> list;
    private String detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportasi);
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listHome);
        list.add(new mTransportasi("1", "", "Judul1","10000"));
        adapter = new TransportasiAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);
    }
}
