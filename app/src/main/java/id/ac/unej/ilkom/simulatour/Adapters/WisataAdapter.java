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

import butterknife.BindView;
import id.ac.unej.ilkom.simulatour.Models.Wisata;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.Models.mWisata;
import id.ac.unej.ilkom.simulatour.R;

public class WisataAdapter extends BaseAdapter {
    private Context context;
    private List<Wisata> list;
    private LayoutInflater inflater;

 /*   @BindView(R.id.imgHome)
    NetworkImageView imgHome;

    @BindView(R.id.txtJudul)
    TextView txtJudul;

    @BindView(R.id.txtHarga)
    TextView txtHarga;*/
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public WisataAdapter(Context context, List<Wisata> list) {
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
        View v = View.inflate(context, R.layout.list_home_detail, null);
        Wisata m = list.get(i);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.list_home_detail, null);
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView imgHome = (NetworkImageView) v.findViewById(R.id.imgHome);
        TextView txtJudul = (TextView) v.findViewById(R.id.txtJudul);
        TextView txtHarga = (TextView) v.findViewById(R.id.txtHarga);

        txtHarga.setText(formatRupiah.format(Double.parseDouble(m.getHargaTiket())));
        imgHome.setImageUrl(m.getFoto(), imageLoader);
        txtJudul.setText(m.getNama());
        v.setTag(m.getIdWisata());
        return v;
    }
}
