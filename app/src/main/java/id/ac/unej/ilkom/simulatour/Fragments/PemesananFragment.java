package id.ac.unej.ilkom.simulatour.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Adapters.PemesananAdapter;
import id.ac.unej.ilkom.simulatour.Models.Pemesanan;
import id.ac.unej.ilkom.simulatour.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PemesananFragment extends Fragment {
    @BindView(R.id.rv_pemesanan)
    RecyclerView rv_pemesanan;
    PemesananAdapter adapter;
    List<Pemesanan> list = new ArrayList<>();

    public PemesananFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pemesanan, container, false);
        ButterKnife.bind(this, view);
        rv_pemesanan.setHasFixedSize(true);
        list.add(new Pemesanan("#00001", "29 Maret 2019", "30 Maret 2019", "Sudah Bayar"));
        adapter = new PemesananAdapter(getActivity(), list);
        rv_pemesanan.setAdapter(adapter);
        return view;
    }

}
