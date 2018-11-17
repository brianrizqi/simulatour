package id.ac.unej.ilkom.simulatour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.ilkom.simulatour.Adapter.HomeAdapter;
import id.ac.unej.ilkom.simulatour.Model.mHome;

public class HomeDetail extends AppCompatActivity {
    private ListView listView;
    private HomeAdapter adapter;
    private List<mHome> list;
    private String detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
//        detail = getIntent().getStringExtra("detail");
//        Toast.makeText(this, detail, Toast.LENGTH_SHORT).show();
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listHome);
//        if (detail.equalsIgnoreCase("wisata")) {
//            list.add(new mHome("1", "", "Kawah Ijen"));
//            list.add(new mHome("1", "", "Air Terjun Kedung Angin"));
//        } else if (detail.equalsIgnoreCase("transport")) {
//            list.add(new mHome("1", "", "Judul1"));
//            list.add(new mHome("1", "", "Judul2"));
//        } else if (detail.equalsIgnoreCase("makanan")) {
//            list.add(new mHome("1", "", "Ijen Shelter"));
//            list.add(new mHome("1", "", "Bebek Gembeng"));
//        } else if (detail.equalsIgnoreCase("penginapan")) {
//            list.add(new mHome("1", "", "Jiwa Jawa"));
//            list.add(new mHome("1", "", "Ijen Resort"));
//        } else if (detail.equalsIgnoreCase("sewa")) {
//            list.add(new mHome("1", "", "Sepeda Motor"));
//            list.add(new mHome("1", "", "Mobil"));
//        } else {
//            list.add(new mHome("1", "", "Judul1"));
//            list.add(new mHome("1", "", "Judul2"));
//        }
        list.add(new mHome("1", "", "Judul1"));
        list.add(new mHome("1", "", "Judul2"));
        adapter = new HomeAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);

    }
}
