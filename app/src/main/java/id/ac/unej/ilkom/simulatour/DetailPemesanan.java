package id.ac.unej.ilkom.simulatour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Adapters.DetailPesanAdapter;
import id.ac.unej.ilkom.simulatour.Models.DetailPesan;

public class DetailPemesanan extends AppCompatActivity {
    @BindView(R.id.rv_detail_pemesanan)
    RecyclerView rv_detail_pemesanan;
    DetailPesanAdapter adapter;
    List<DetailPesan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan);
        ButterKnife.bind(this);
        rv_detail_pemesanan.setHasFixedSize(true);
        list.add(new DetailPesan("Gunung Ijen", "29 Maret", ""));
        list.add(new DetailPesan("Hotel Ketapang", "29 Maret", ""));
        list.add(new DetailPesan("Air Terjun Jagir", "30 Maret", ""));
        adapter = new DetailPesanAdapter(this, list);
        rv_detail_pemesanan.setAdapter(adapter);
    }
}
