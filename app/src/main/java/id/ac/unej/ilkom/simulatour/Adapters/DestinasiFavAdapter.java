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

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.simulatour.Activities.DetailItem;
import id.ac.unej.ilkom.simulatour.Models.DestinasiFav;
import id.ac.unej.ilkom.simulatour.R;

public class DestinasiFavAdapter extends RecyclerView.Adapter<DestinasiFavAdapter.ViewHolder> {
    private Activity activity;
    private List<DestinasiFav> list;

    public DestinasiFavAdapter(Activity activity, List<DestinasiFav> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(activity).inflate(R.layout.list_destinasi_fav, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DestinasiFav fav = list.get(i);
        viewHolder.txtFav.setText(fav.getTitle());
        Glide.with(activity)
                .load(fav.getImg())
                .into(viewHolder.imgFav);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, DetailItem.class);
                i.putExtra("title", fav.getTitle());
                i.putExtra("img", fav.getImg());
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgFav)
        ImageView imgFav;
        @BindView(R.id.txtFav)
        TextView txtFav;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
