package edu.skku.cs.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class setting_Activity extends AppCompatActivity implements MyContract.ContractForView{

    private MyPresenter presenter;
    private TextView name;
    private Button addbtn;
    private ListView myrecipe;
    private MyrecipeAdapter myrecipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        presenter = new MyPresenter(this, new MyModel());
        name = findViewById(R.id.textView8);
        addbtn = findViewById(R.id.button3);
        myrecipe = findViewById(R.id.myrecipe);

        presenter.setuserinfo(getIntent());
        addbtn.setOnClickListener(view -> {
            presenter.onAddButtonTouched(getIntent(), setting_Activity.this );
        });
        Log.i("debug", "setting username " + getIntent().getStringExtra("user"));


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
        myrecipeAdapter = new MyrecipeAdapter(items, getApplicationContext(),presenter);
        myrecipe.setAdapter(myrecipeAdapter);
    }


    @Override
    public void setrecipeinfo(Recipe item) {

    }

    @Override
    public void setmethodlist(ArrayList<Ways> items) {

    }

    @Override
    public void setusername(String user) {
        name.setText("Chef. " + user);
    }

    @Override
    public Recipe getrecipeinfo() {
        return null;
    }

    @Override
    public void finishview() {
        this.finish();
    }

    @Override
    public boolean setListViewHeightBasedOnItems() {
        return false;
    }
}