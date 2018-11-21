package id.ac.unej.ilkom.simulatour.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.ilkom.simulatour.Adapters.WisataAdapter;
import id.ac.unej.ilkom.simulatour.Models.mWisata;
import id.ac.unej.ilkom.simulatour.R;

public class WisataActivity extends AppCompatActivity {
    private ListView listView;
    private WisataAdapter adapter;
    private List<mWisata> list;
    private String detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listHome);
        list.add(new mWisata("1", "", "Judul1","10000"));
        adapter = new WisataAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mWisata m = list.get(i);
                Intent ii = new Intent(getApplicationContext(),WisataDetailActivity.class);
                startActivity(ii);
            }
        });
    }
}
