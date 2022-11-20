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

class Ways {
    public String img;
    public String way;

    Ways(String img, String way)
    {
        this.img = img;
        this.way = way;
    }


}

public class RecipeAdapter extends BaseAdapter {

    ArrayList<Ways> items;
    Context mContext;

    RecipeAdapter(ArrayList<Ways> items, Context mContext)
    {
        this.items = items;
        this.mContext = mContext;
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
            if(items.get(i).img.length() == 0)
                view = layoutInflater.inflate(R.layout.way2_layout,viewGroup, false);
            else
                view = layoutInflater.inflate(R.layout.way_layout,viewGroup, false);
        }

        if(items.get(i).img.length() == 0)
        {
            TextView step = view.findViewById(R.id.textView15);
            TextView way = view.findViewById(R.id.textView16);
            step.setText("Step " + Integer.toString(i + 1));
            if(items.get(i).way.length() != 0)
                way.setText(items.get(i).way);
        }
        else {
            ImageView img = view.findViewById(R.id.imageView4);
            TextView step = view.findViewById(R.id.textView6);
            TextView way = view.findViewById(R.id.textView7);


            if (items.get(i).img.length() != 0)
                Picasso.get().load(items.get(i).img).into(img);


            step.setText("Step " + Integer.toString(i + 1));
            if (items.get(i).way.length() != 0)
                way.setText(items.get(i).way);
        }




        return view;
    }
}
