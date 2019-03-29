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

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Models.DestinasiFav;
import id.ac.unej.ilkom.simulatour.R;

public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.ViewHolder> {
    private Context context;
    private List<DestinasiFav> list;

    public DetailListAdapter(Context context, List<DestinasiFav> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(context).inflate(R.layout.list_detail_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        final DestinasiFav fav = list.get(i);
        viewHolder.txtTitleList.setText(fav.getTitle());
        viewHolder.txtPriceList.setText(formatRupiah.format(Double.parseDouble(fav.getHarga())));
        Glide.with(context)
                .load(fav.getImg())
                .into(viewHolder.imgList);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgList)
        ImageView imgList;
        @BindView(R.id.txtTitleList)
        TextView txtTitleList;
        @BindView(R.id.txtPriceList)
        TextView txtPriceList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
