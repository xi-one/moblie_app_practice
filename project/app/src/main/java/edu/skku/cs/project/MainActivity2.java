package edu.skku.cs.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements MyContract.ContractForView {

    private MyPresenter presenter;
    private ListView listview;
    private ListviewAdapter listviewadapter;
    private ImageButton setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        presenter = new MyPresenter(this, new MyModel());

        listview = findViewById(R.id.listview);
        ImageButton btn1 = findViewById(R.id.search_Button);
        ImageButton btn2 = findViewById(R.id.setting_Button);
        EditText editText = findViewById(R.id.editText3);
        setting = findViewById(R.id.setting_Button);

        btn1.setOnClickListener(view -> {
            presenter.onSearchButtonTouched(editText.getText().toString());
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.onListviewTouched(listviewadapter, i, MainActivity2.this);
            }
        });

        setting.setOnClickListener(view -> {
            presenter.onSettingButtonTouced(getIntent(),MainActivity2.this);
        });

        Log.i("debug", "m1username " + getIntent().getStringExtra("user"));


    }

    @Override
    public void makeToastMessage(String text) {
        Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void StartActivity(Intent intent) {
        startActivity(intent);
    }




    @Override
    public void setAdapter(ArrayList<Recipe> items) {
        listviewadapter = new ListviewAdapter(items, getApplicationContext());
        listview.setAdapter(listviewadapter);
    }


    @Override
    public void setrecipeinfo(Recipe item) {

    }

    @Override
    public void setmethodlist(ArrayList<Ways> items) {

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
        return false;
    }


}