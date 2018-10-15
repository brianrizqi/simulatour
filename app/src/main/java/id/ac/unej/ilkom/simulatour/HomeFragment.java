package id.ac.unej.ilkom.simulatour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    CardView wisata, penginapan, transport, makanan, sewa;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        wisata = (CardView) view.findViewById(R.id.wisata);
        penginapan = (CardView) view.findViewById(R.id.penginapan);
        transport = (CardView) view.findViewById(R.id.transportasi);
        makanan = (CardView) view.findViewById(R.id.makanan);
        sewa = (CardView) view.findViewById(R.id.sewa);
        wisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), HomeDetail.class);
                startActivity(i);
            }
        });
        penginapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), HomeDetail.class);
                startActivity(i);
            }
        });
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), HomeDetail.class);
                startActivity(i);
            }
        });
        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), HomeDetail.class);
                startActivity(i);
            }
        });
        sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), HomeDetail.class);
                startActivity(i);
            }
        });
        return view;
    }

}
