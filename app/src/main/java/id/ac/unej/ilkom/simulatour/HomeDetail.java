package id.ac.unej.ilkom.simulatour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.ilkom.simulatour.Adapter.HomeAdapter;
import id.ac.unej.ilkom.simulatour.Model.mHome;

public class HomeDetail extends AppCompatActivity {
    private ListView listView;
    private HomeAdapter adapter;
    private List<mHome> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listHome);
        list.add(new mHome("1","","Judul1"));
        list.add(new mHome("1","","Judul2"));
        adapter = new HomeAdapter(getApplicationContext(),list);
        listView.setAdapter(adapter);
    }
}
