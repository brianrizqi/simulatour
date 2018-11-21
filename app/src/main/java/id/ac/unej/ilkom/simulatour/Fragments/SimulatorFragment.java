package id.ac.unej.ilkom.simulatour.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.ac.unej.ilkom.simulatour.Activities.SimulatorDetail;
import id.ac.unej.ilkom.simulatour.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimulatorFragment extends Fragment {
    Button simulate;

    public SimulatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simulator, container, false);
        simulate = (Button) view.findViewById(R.id.simulate);
        simulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SimulatorDetail.class);
                startActivity(i);
            }
        });
        return view;
    }

}
