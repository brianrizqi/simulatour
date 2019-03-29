package id.ac.unej.ilkom.simulatour.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Models.DetailPesan;
import id.ac.unej.ilkom.simulatour.R;

public class DetailPesanAdapter extends RecyclerView.Adapter<DetailPesanAdapter.ViewHolder> {
    private Context context;
    private List<DetailPesan> list;

    public DetailPesanAdapter(Context context, List<DetailPesan> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(context).inflate(R.layout.list_detail_pemesanan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DetailPesan pesan = list.get(i);
        viewHolder.txtTitle.setText(pesan.getTitle());
        viewHolder.txtTanggal.setText(pesan.getTanggal());
//        Glide.with(context)
//                .load(pesan.getImg())
//                .into(viewHolder.imgDetail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgDetail)
        ImageView imgDetail;
        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.txtTanggal)
        TextView txtTanggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
