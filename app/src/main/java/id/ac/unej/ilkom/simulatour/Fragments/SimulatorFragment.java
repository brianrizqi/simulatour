package id.ac.unej.ilkom.simulatour.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Activities.SimulatorActivity;
import id.ac.unej.ilkom.simulatour.Activities.SimulatorDetailActivity;
import id.ac.unej.ilkom.simulatour.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimulatorFragment extends Fragment {
    @BindView(R.id.simulate)
    Button simulate;

    @BindView(R.id.jumlahHari)
    TextView txtJumlahHari;

    @BindView(R.id.jumlahUang)
    TextView txtJumlahUang;

    private String jumlahUang,jumlahHari;

    public SimulatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simulator, container, false);
        ButterKnife.bind(this,view);
        //simulate = (Button) view.findViewById(R.id.simulate);
        simulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahUang = txtJumlahUang.getText().toString().trim();
                jumlahHari = txtJumlahHari.getText().toString().trim();
                Intent i = new Intent(getActivity(), SimulatorActivity.class);

                i.putExtra("jumlahUang",jumlahUang);
                i.putExtra("jumlahHari",jumlahHari);

                startActivity(i);
            }
        });
        return view;
    }

}
