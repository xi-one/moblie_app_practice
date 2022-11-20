package edu.skku.cs.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyrecipeAdapter extends BaseAdapter {

    private ArrayList<Recipe> items;
    private Context mContext;
    private MyPresenter presenter;

    MyrecipeAdapter (ArrayList<Recipe> items, Context mContext, MyPresenter presenter) {
        this.mContext = mContext;
        this.items = items;
        this.presenter = presenter;
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
            view = layoutInflater.inflate(R.layout.myrecipe_sublayout,viewGroup, false);
        }

        TextView recpiename = view.findViewById(R.id.textView9);
        Button checkbtn = view.findViewById(R.id.button6);
        Button deletebtn = view.findViewById(R.id.button4);

        recpiename.setText(items.get(i).getRCP_NM());

        checkbtn.setOnClickListener(v -> {
            presenter.onMyrecipelistviewTouched(this, i ,viewGroup.getContext());
        });

        deletebtn.setOnClickListener(v -> {
            presenter.deleterecipedata(items.get(i).getMaker(), items.get(i).getRCP_NM());
            items.remove(i);
            this.notifyDataSetChanged();

               // 서버에 데이터베이스에 있는 값도 삭제하는 거 요청
        });

        return view;
    }
}
