package id.ac.unej.ilkom.simulatour.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.DetailPemesanan;
import id.ac.unej.ilkom.simulatour.Models.Pemesanan;
import id.ac.unej.ilkom.simulatour.R;

public class PemesananAdapter extends RecyclerView.Adapter<PemesananAdapter.ViewHolder> {
    private Activity activity;
    private List<Pemesanan> list;

    public PemesananAdapter(Activity activity, List<Pemesanan> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.list_pemesanan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Pemesanan pemesanan = list.get(i);
        viewHolder.kodeBoking.setText(pemesanan.getId());
        viewHolder.tanggalBerangkat.setText("Tanggal Berangkat : " + pemesanan.getBerangkat());
        viewHolder.tanggalPulang.setText("Tanggal Pulang : " + pemesanan.getPulang());
        viewHolder.status.setText("Status : " + pemesanan.getStatus());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, DetailPemesanan.class);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.kodeBoking)
        TextView kodeBoking;
        @BindView(R.id.tanggalBerangkat)
        TextView tanggalBerangkat;
        @BindView(R.id.tanggalPulang)
        TextView tanggalPulang;
        @BindView(R.id.status)
        TextView status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
