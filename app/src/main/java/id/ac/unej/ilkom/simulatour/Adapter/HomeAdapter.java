package id.ac.unej.ilkom.simulatour.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import id.ac.unej.ilkom.simulatour.AppController;
import id.ac.unej.ilkom.simulatour.Model.mHome;
import id.ac.unej.ilkom.simulatour.R;

public class HomeAdapter extends BaseAdapter {
    private Context context;
    private List<mHome> list;
    private LayoutInflater inflater;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public HomeAdapter(Context context, List<mHome> list) {
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
        mHome m = list.get(i);

        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.list_home_detail, null);
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView imgHome = (NetworkImageView) view.findViewById(R.id.imgHome);
        TextView txtJudul = (TextView) view.findViewById(R.id.txtJudul);

        imgHome.setImageUrl(m.getImg(), imageLoader);
        txtJudul.setText(m.getJudul());
        v.setTag(m.getId());
        return v;
    }
}
