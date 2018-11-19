package id.ac.unej.ilkom.simulatour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    CardView wisata, penginapan, transport, makanan, sewa,about;
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private LinearLayout mLinearLayout;
    private SliderView sliderView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = (SliderView) view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        wisata = (CardView) view.findViewById(R.id.wisata);
        penginapan = (CardView) view.findViewById(R.id.penginapan);
        transport = (CardView) view.findViewById(R.id.transportasi);
        makanan = (CardView) view.findViewById(R.id.makanan);
        sewa = (CardView) view.findViewById(R.id.sewa);
        about = (CardView) view.findViewById(R.id.about);
        setupSlider();
        wisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Wisata.class);
                startActivity(i);
            }
        });
        penginapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Penginapan.class);
                startActivity(i);
            }
        });
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Transportasi.class);
                startActivity(i);
            }
        });
        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Makanan.class);
                startActivity(i);
            }
        });
        sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Sewa.class);
                startActivity(i);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),About.class);
                startActivity(i);
            }
        });
        return view;
    }
    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(SliderFragment.newInstance("http://helloworlds.me/simulatour/images.png"));
        fragments.add(SliderFragment.newInstance("http://helloworlds.me/simulatour/images2.jpg"));
        fragments.add(SliderFragment.newInstance("http://helloworlds.me/simulatour/images3.jpg"));
        fragments.add(SliderFragment.newInstance("http://helloworlds.me/simulatour/images4.jpg"));

        mAdapter = new SliderPagerAdapter(getChildFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_slider);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

}
