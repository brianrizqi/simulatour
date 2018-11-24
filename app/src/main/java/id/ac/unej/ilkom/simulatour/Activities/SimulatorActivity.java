package id.ac.unej.ilkom.simulatour.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Adapters.SimulasiAdapter;
import id.ac.unej.ilkom.simulatour.Models.Simulasi;
import id.ac.unej.ilkom.simulatour.Models.Wisata;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.Networks.BaseApi;
import id.ac.unej.ilkom.simulatour.R;

public class SimulatorActivity extends AppCompatActivity {
    @BindView(R.id.listHome)
    ListView listView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.titleMain)
    Button button;

    private String jumlahHari,jumlahUang;


    private SimulasiAdapter adapter;
    private List<Simulasi> list;
    private ProgressDialog pDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulator);
        ButterKnife.bind(this);

        button.setText("Simulasi");

        jumlahUang = getIntent().getStringExtra("jumlahUang");
        jumlahHari = getIntent().getStringExtra("jumlahHari");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                    finish();
                }
            });
        }
        list = new ArrayList<>();

        adapter = new SimulasiAdapter(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Simulasi m = list.get(i);
                Intent intent = new Intent(SimulatorActivity.this, SimulatorDetailActivity.class);
                intent.putExtra("simulasi",m);
                startActivity(intent);
            }
        });

        getSimulasi(jumlahUang,jumlahHari);


    }

    public void getSimulasi(final String uang, final String hari) {
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        list.clear();


        // Creating volley request obj
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BaseApi.getSimulasi,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(String.valueOf(this), response.toString());
                        hidePDialog();
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray jsonArray = obj.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject objWisata = jsonArray.getJSONObject(i);
                                final Simulasi s = new Simulasi();
                                s.setIdPaket(objWisata.getString("id_paket"));
                                s.setNamaPaket(objWisata.getString("nama_paket"));
                                s.setFoto(BaseApi.imageURL + objWisata.getString("foto"));
                                s.setHarga(objWisata.getString("harga"));
                                s.setDurasi(objWisata.getString("durasi"));
                                s.setDeskripsi(objWisata.getString("deskripsi"));

                                list.add(s);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(String.valueOf(this), "Error: " + error.getMessage());
                hidePDialog();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("id_user", "1");
                map.put("token", "2b6898a282eece7bae4cdb706d4dcb1203433eee69d7ab317eaa081737ee5636");

                map.put("durasi",hari);
                map.put("harga",uang);
                return map;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

}
