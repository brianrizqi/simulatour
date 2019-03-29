package id.ac.unej.ilkom.simulatour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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
import id.ac.unej.ilkom.simulatour.Adapters.DetailListAdapter;
import id.ac.unej.ilkom.simulatour.Models.DestinasiFav;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.Networks.BaseApi;

public class DetailList extends AppCompatActivity {
    @BindView(R.id.rv_detail_list)
    RecyclerView rv_detail_list;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    List<DestinasiFav> list = new ArrayList<>();
    DetailListAdapter adapter;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);
        ButterKnife.bind(this);
        title = getIntent().getStringExtra("title");
        txtTitle.setText(title);
        rv_detail_list.setHasFixedSize(true);
        getAll();
        adapter = new DetailListAdapter(this, list);
        rv_detail_list.setAdapter(adapter);
    }

    private void getAll() {
        String baseApi;
        if (title.equalsIgnoreCase("wisata")) {
            baseApi = BaseApi.getAllWisata;
        } else {
            baseApi = BaseApi.getAllPenginapan;
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, baseApi,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray jsonArray = obj.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject objWisata = jsonArray.getJSONObject(i);
                                final DestinasiFav w = new DestinasiFav();
                                w.setTitle(objWisata.getString("nama"));
                                w.setImg(BaseApi.imageURL + objWisata.getString("foto"));
                                if (title.equalsIgnoreCase("wisata")) {
                                    w.setHarga(objWisata.getString("harga_tiket"));
                                } else {
                                    w.setHarga(objWisata.getString("harga"));
                                }
                                list.add(w);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DetailList.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
}
