package edu.skku.cs.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recipe_Activity extends AppCompatActivity implements MyContract.ContractForView {
    private ImageView img;
    private TextView name;
    private TextView info1;
    private TextView info2;
    private TextView info3;
    private TextView ingredients;
    private ListView method_list;
    private RecipeAdapter recipeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        img = findViewById(R.id.imageView3);
        name = findViewById(R.id.textView5);
        info1 = findViewById(R.id.textView46);
        info2 = findViewById(R.id.textView48);
        info3 = findViewById(R.id.textView50);
        ingredients = findViewById(R.id.textView14);
        method_list = findViewById(R.id.list_method);

        MyPresenter presenter = new MyPresenter(this, new MyModel());

        presenter.setviews(getIntent());



    }

    @Override
    public void makeToastMessage(String text) {

    }

    @Override
    public void StartActivity(Intent intent) {
        startActivity(intent);
    }


    @Override
    public void setAdapter(ArrayList<Recipe> items) {
    }


    @Override
    public void setrecipeinfo(Recipe item) {
        if(item.getATT_FILE_NO_MK() == null)
        {
            img.setImageResource(R.drawable.food);
        }
        else {
            Picasso.get().load(item.getATT_FILE_NO_MK()).into(img);
        }
        name.setText(item.getRCP_NM());
        info1.setText(item.getRCP_WAY2());
        info2.setText(item.getINFO_WGT());
        info3.setText(item.getINFO_ENG() + " kcal");
        ingredients.setText(item.getRCP_PARTS_DTLS());


    }

    @Override
    public void setmethodlist(ArrayList<Ways> items) {
        recipeAdapter = new RecipeAdapter(items, getApplicationContext());
        method_list.setAdapter(recipeAdapter);
    }

    @Override
    public void setusername(String user) {

    }

    @Override
    public Recipe getrecipeinfo() {
        return null;
    }

    @Override
    public void finishview() {

    }
    @Override
    public boolean setListViewHeightBasedOnItems() {

        ListAdapter listAdapter = method_list.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, method_list);
                float px = 500 * (method_list.getResources().getDisplayMetrics().density);
                item.measure(View.MeasureSpec.makeMeasureSpec((int) px, View.MeasureSpec.AT_MOST), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = method_list.getDividerHeight() *
                    (numberOfItems - 1);
            // Get padding
            int totalPadding = method_list.getPaddingTop() + method_list.getPaddingBottom();

            // Set list height.
            ViewGroup.LayoutParams params = method_list.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight + totalPadding;
            method_list.setLayoutParams(params);
            method_list.requestLayout();
            //setDynamicHeight(listView);
            return true;

        } else {
            return false;
        }
    }



    }