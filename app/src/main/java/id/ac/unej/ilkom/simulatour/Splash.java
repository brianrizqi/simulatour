package id.ac.unej.ilkom.simulatour;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.FadingCircle;

import id.ac.unej.ilkom.simulatour.Activities.MainActivity;

public class Splash extends AppCompatActivity {
    private static int splashInterval = 3000;
    ProgressBar progressBar;
    private Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar) findViewById(R.id.spin_kit);
        FadingCircle foldingCube = new FadingCircle();
        progressBar.setIndeterminateDrawable(foldingCube);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, splashInterval);

    }
}
