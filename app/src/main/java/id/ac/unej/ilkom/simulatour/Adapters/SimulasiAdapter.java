package id.ac.unej.ilkom.simulatour.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import id.ac.unej.ilkom.simulatour.Models.Simulasi;
import id.ac.unej.ilkom.simulatour.Models.Wisata;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.R;

public class SimulasiAdapter extends BaseAdapter {
    private Context context;
    private List<Simulasi> list;
    private LayoutInflater inflater;

 /*   @BindView(R.id.imgHome)
    NetworkImageView imgHome;

    @BindView(R.id.txtJudul)
    TextView txtJudul;

    @BindView(R.id.txtHarga)
    TextView txtHarga;*/
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public SimulasiAdapter(Context context, List<Simulasi> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.list_simulasi, null);
        Simulasi m = list.get(i);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.list_simulasi, null);
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView imgHome = (NetworkImageView) v.findViewById(R.id.imgHome);
        TextView txtJudul = (TextView) v.findViewById(R.id.txtJudul);
        TextView txtHarga = (TextView) v.findViewById(R.id.txtHarga);
        TextView txtJenis = (TextView) v.findViewById(R.id.txtJenis);
        TextView txtKet = (TextView)v.findViewById(R.id.keterangan);

        txtHarga.setText(formatRupiah.format(Double.parseDouble(m.getHarga())));
        imgHome.setImageUrl(m.getFoto(), imageLoader);
        txtJudul.setText(m.getNama());
        txtJenis.setText(m.getJenis());
        txtKet.setText(m.getKeterangan());
        if (txtKet.getText().length()>0){
            txtKet.setVisibility(View.VISIBLE);
        }
        //v.setTag(m.getIdPaket());
        return v;
    }
}
