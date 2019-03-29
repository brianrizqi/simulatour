package id.ac.unej.ilkom.simulatour.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Models.Simulasi;
import id.ac.unej.ilkom.simulatour.Networks.AppController;
import id.ac.unej.ilkom.simulatour.R;

public class SimulasiAdapter extends RecyclerView.Adapter<SimulasiAdapter.ViewHolder> {
    private Context context;
    private List<Simulasi> list;
    private LayoutInflater inflater;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public SimulasiAdapter(Context context, List<Simulasi> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(context).inflate(R.layout.list_simulasi, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Simulasi m = list.get(i);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        viewHolder.imgHome.setImageUrl(m.getFoto(), imageLoader);
        viewHolder.txtJudul.setText(m.getNama());
        viewHolder.txtJenis.setText(m.getJenis());
        viewHolder.txtHarga.setText(formatRupiah.format(Double.parseDouble(m.getHarga())));
        viewHolder.txtKet.setText(m.getKeterangan());
        if (viewHolder.txtKet.getText().length() > 0) {
            viewHolder.txtKet.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgHome)
        NetworkImageView imgHome;
        @BindView(R.id.txtJudul)
        TextView txtJudul;
        @BindView(R.id.txtHarga)
        TextView txtHarga;
        @BindView(R.id.txtJenis)
        TextView txtJenis;
        @BindView(R.id.keterangan)
        TextView txtKet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
