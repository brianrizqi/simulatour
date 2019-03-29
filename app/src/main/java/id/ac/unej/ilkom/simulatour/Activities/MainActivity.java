package id.ac.unej.ilkom.simulatour.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import id.ac.unej.ilkom.simulatour.BottomNavigationHelper;
import id.ac.unej.ilkom.simulatour.Fragments.HomeFragment;
import id.ac.unej.ilkom.simulatour.Fragments.PemesananFragment;
import id.ac.unej.ilkom.simulatour.Fragments.ProfileFragment;
import id.ac.unej.ilkom.simulatour.R;
import id.ac.unej.ilkom.simulatour.Fragments.SimulatorFragment;

public class MainActivity extends AppCompatActivity {
    RelativeLayout fragment;
    android.support.v4.app.Fragment home, simulator, pemesanan,profile;

    private BottomNavigationView.OnNavigationItemSelectedListener listener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Bundle data = new Bundle();
            android.support.v4.app.Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = home;
                    if (fragment == null) {
                        home = new HomeFragment();
                    }
                    break;
                case R.id.navigation_simulator:
                    fragment = simulator;
                    if (fragment == null) {
                        simulator = new SimulatorFragment();
                        fragment = simulator;
                    }
                    break;
                case R.id.navigation_pemesanan:
                    fragment = pemesanan;
                    if (fragment == null) {
                        pemesanan = new PemesananFragment();
                        fragment = pemesanan;
                    }
                    break;
                case R.id.navigation_profile:
                    fragment = profile;
                    if (fragment == null) {
                        profile = new ProfileFragment();
                        fragment = profile;
                    }
                    break;
            }
            if (fragment != null)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
            return fragment != null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = (RelativeLayout) findViewById(R.id.fragment);

        HomeFragment homeFragment = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, homeFragment);
        fragmentTransaction.commit();

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        navigationView.setOnNavigationItemSelectedListener(listener);
        BottomNavigationHelper.disableShiftMode(navigationView);
    }
}
