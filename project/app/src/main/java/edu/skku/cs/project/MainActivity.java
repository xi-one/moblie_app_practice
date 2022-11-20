package edu.skku.cs.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyContract.ContractForView{

    private MyPresenter presenter;
    private Button btn;
    private Button btn2;
    private EditText editText1;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        presenter = new MyPresenter(this, new MyModel());

        btn.setOnClickListener(view -> {

            presenter.onLoginButtonTouched(editText1.getText().toString(), editText2.getText().toString(), MainActivity.this);

        });

        btn2.setOnClickListener(view -> {
            presenter.onSingupButtonTouched(editText1.getText().toString(), editText2.getText().toString());
        });
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