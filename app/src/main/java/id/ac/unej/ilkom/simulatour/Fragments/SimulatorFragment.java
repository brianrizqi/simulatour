package id.ac.unej.ilkom.simulatour.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @BindView(R.id.radioPelabuhan)
    RadioButton radioPelabuhan;

    @BindView(R.id.radioTerminal)
    RadioButton radioTerminal;

    @BindView(R.id.radioStasiun)
    RadioButton radioStasiun;

    @BindView(R.id.radioBandara)
    RadioButton radioBandara;

    private String jumlahUang, jumlahHari, transport;

    public SimulatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simulator, container, false);
        ButterKnife.bind(this, view);
        //simulate = (Button) view.findViewById(R.id.simulate);
        simulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahUang = txtJumlahUang.getText().toString().trim();
                jumlahHari = txtJumlahHari.getText().toString().trim();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == radioBandara.getId()) {
                    transport = "1";
                } else if (selectedId == radioStasiun.getId()) {
                    transport = "2";
                } else if (selectedId == radioTerminal.getId()) {
                    transport = "3";
                } else if (selectedId == radioPelabuhan.getId()) {
                    transport = "4";
                }
                Intent i = new Intent(getActivity(), SimulatorActivity.class);

                i.putExtra("jumlahUang", jumlahUang);
                i.putExtra("jumlahHari", jumlahHari);
                i.putExtra("transport", transport);

                startActivity(i);
            }
        });
        return view;
    }

}
