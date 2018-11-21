package id.ac.unej.ilkom.simulatour.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.ilkom.simulatour.Adapters.HomeAdapter;
import id.ac.unej.ilkom.simulatour.Models.mHome;
import id.ac.unej.ilkom.simulatour.R;

public class Sewa extends AppCompatActivity {
    private ListView listView;
    private HomeAdapter adapter;
    private List<mHome> list;
    private String detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa);
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listHome);
        list.add(new mHome("1", "", "Judul1","10000"));
        adapter = new HomeAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);

    }
}
