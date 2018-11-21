package id.ac.unej.ilkom.simulatour.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import id.ac.unej.ilkom.simulatour.Adapters.WisataAdapter;
import id.ac.unej.ilkom.simulatour.Models.Wisata;
import id.ac.unej.ilkom.simulatour.Models.mWisata;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.Networks.BaseApi;
import id.ac.unej.ilkom.simulatour.R;

public class WisataActivity extends AppCompatActivity {
       @BindView(R.id.listHome)
       ListView listView;

    private WisataAdapter adapter;
    private List<Wisata> list;
    private String detail;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);
        ButterKnife.bind(this);
        list = new ArrayList<>();

        /*listView = (ListView) findViewById(R.id.listHome);*/
        /*list.add(new Wisata("10000", "1", "ijen", "ijen.jpg"));
        list.add(new Wisata("15000", "2", "kawah bulan sabit", "kawah-bulan-sabit.jpg"));*/
        adapter = new WisataAdapter(this, list);
        listView.setAdapter(adapter);
        getWisata();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Wisata m = list.get(i);
                Intent intent = new Intent(WisataActivity.this, WisataDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getWisata() {
        pDialog = new ProgressDialog(getApplicationContext());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
//        pDialog.show();
        list.clear();


        // Creating volley request obj
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BaseApi.getAllWisata,
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
                                final Wisata w = new Wisata();
                                w.setIdWisata(objWisata.getString("id_wisata"));
                                w.setNama(objWisata.getString("nama"));
                                w.setFoto(BaseApi.imageURL + objWisata.getString("foto"));
                                w.setHargaTiket(objWisata.getString("harga_tiket"));
                                w.setJenisObyekWisata(objWisata.getString("jenis_obyek_wisata"));
                                w.setDeskripsi(objWisata.getString("deskripsi"));
                                w.setAkses(objWisata.getString("akses"));
                                list.add(w);
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
