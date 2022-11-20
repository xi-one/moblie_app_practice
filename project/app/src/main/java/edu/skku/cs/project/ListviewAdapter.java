package edu.skku.cs.project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ListviewAdapter extends BaseAdapter {

    private ArrayList<Recipe> items;
    private Context mContext;

    ListviewAdapter (ArrayList<Recipe> items, Context mContext) {
        this.mContext = mContext;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.sub_layout,viewGroup, false);
        }

        ImageView img = view.findViewById(R.id.imageView2);
        TextView textView = view.findViewById(R.id.textView4);
        float dp =   view.getResources().getDisplayMetrics().density;
        if(items.get(i).getATT_FILE_NO_MAIN() != null) {
            if (items.get(i).getATT_FILE_NO_MAIN().length() != 0)
                Picasso.get().load(items.get(i).getATT_FILE_NO_MAIN()).resize((int) (85 * dp), (int) (85 * dp)).onlyScaleDown().into(img);
        }
        else
        {
            img.setImageResource(R.drawable.food);
        }
        Log.i("api", Integer.toString(i));
        textView.setText(items.get(i).getRCP_NM());
        return view;
    }
}
