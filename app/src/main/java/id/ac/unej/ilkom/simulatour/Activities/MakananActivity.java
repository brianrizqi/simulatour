package id.ac.unej.ilkom.simulatour.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.ilkom.simulatour.Adapters.MakananAdapter;
import id.ac.unej.ilkom.simulatour.Models.mMakanan;
import id.ac.unej.ilkom.simulatour.R;

public class MakananActivity extends AppCompatActivity {
    private ListView listView;
    private MakananAdapter adapter;
    private List<mMakanan> list;
    private String detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listHome);
        list.add(new mMakanan("1", "", "Judul1","10000"));
        adapter = new MakananAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);
    }
}
