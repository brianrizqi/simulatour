package id.ac.unej.ilkom.simulatour.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import id.ac.unej.ilkom.simulatour.Adapters.DestinasiFavAdapter;
import id.ac.unej.ilkom.simulatour.Adapters.MakananFavAdapter;
import id.ac.unej.ilkom.simulatour.Adapters.PenginapanFavAdapter;
import id.ac.unej.ilkom.simulatour.DetailList;
import id.ac.unej.ilkom.simulatour.Models.DestinasiFav;
import id.ac.unej.ilkom.simulatour.Models.MakananFav;
import id.ac.unej.ilkom.simulatour.Models.PenginapanFav;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.Networks.BaseApi;
import id.ac.unej.ilkom.simulatour.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.wisataLengkap)
    TextView wisataLengkap;
    @BindView(R.id.penginapanLengkap)
    TextView penginapanLengkap;
    @BindView(R.id.rv_des_fav)
    RecyclerView rv_des_fav;
    @BindView(R.id.rv_penginapan_fav)
    RecyclerView rv_penginapan_fav;
    @BindView(R.id.rv_makanan_fav)
    RecyclerView rv_makanan_fav;
    DestinasiFavAdapter adapter;
    List<DestinasiFav> list;
    PenginapanFavAdapter penginapanAdapter;
    List<PenginapanFav> listPenginapan;
    MakananFavAdapter makananAdapter;
    List<MakananFav> listMakanan = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        rv_des_fav.setHasFixedSize(true);
        rv_penginapan_fav.setHasFixedSize(true);
        rv_makanan_fav.setHasFixedSize(true);

        wisataLengkap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DetailList.class);
                i.putExtra("title", "Wisata");
                startActivity(i);
            }
        });

        penginapanLengkap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DetailList.class);
                i.putExtra("title", "Penginapan");
                startActivity(i);
            }
        });

        list = new ArrayList<>();
        listPenginapan = new ArrayList<>();

        list_des_fav();
        adapter = new DestinasiFavAdapter(getActivity(), list);
        rv_des_fav.setAdapter(adapter);

        list_penginapan_fav();
        penginapanAdapter = new PenginapanFavAdapter(getActivity(), listPenginapan);
        rv_penginapan_fav.setAdapter(penginapanAdapter);

        list_makanan_fav();
        return view;
    }

    private void list_makanan_fav() {
        listMakanan.add(new MakananFav(R.drawable.forest, "Sego Tempong"));
        listMakanan.add(new MakananFav(R.drawable.forest, "Sego Tempong"));
        listMakanan.add(new MakananFav(R.drawable.forest, "Sego Tempong"));
        makananAdapter = new MakananFavAdapter(getActivity(), listMakanan);
        rv_makanan_fav.setAdapter(makananAdapter);
    }

    private void list_des_fav() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BaseApi.getAllWisata,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray jsonArray = obj.getJSONArray("data");
                            for (int i = 0; i < 4; i++) {
                                JSONObject objWisata = jsonArray.getJSONObject(i);
                                final DestinasiFav w = new DestinasiFav();
                                w.setTitle(objWisata.getString("nama"));
                                w.setImg(BaseApi.imageURL + objWisata.getString("foto"));
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


    private void list_penginapan_fav() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BaseApi.getAllPenginapan,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray jsonArray = obj.getJSONArray("data");
                            for (int i = 0; i < 4; i++) {
                                JSONObject objPenginapan = jsonArray.getJSONObject(i);
                                final PenginapanFav p = new PenginapanFav();
                                p.setTitle(objPenginapan.getString("nama"));
                                p.setImg(BaseApi.imageURL + objPenginapan.getString("foto"));
                                listPenginapan.add(p);
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
