package edu.skku.cs.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_Recipe_Activty extends AppCompatActivity implements MyContract.ContractForView{

    private EditText title;
    private EditText method;
    private EditText wgt;
    private EditText cal;
    private EditText ingredient;
    private EditText step1;
    private EditText step2;
    private EditText step3;
    private EditText step4;
    private EditText step5;
    private EditText step6;
    private EditText step7;
    private EditText step8;
    private EditText step9;
    private EditText step10;
    private EditText step11;
    private EditText step12;
    private EditText step13;
    private EditText step14;
    private EditText step15;
    private EditText step16;
    private EditText step17;
    private EditText step18;
    private EditText step19;
    private EditText step20;
    private Button add;
    private MyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        title = findViewById(R.id.editText4);
        method = findViewById(R.id.editText5);
        wgt = findViewById(R.id.editText6);
        cal = findViewById(R.id.editText7);
        ingredient = findViewById(R.id.editText8);
        step1 = findViewById(R.id.editText9);
        step2 = findViewById(R.id.editText10);
        step3 = findViewById(R.id.editText11);
        step4 = findViewById(R.id.editText12);
        step5 = findViewById(R.id.editText13);
        step6 = findViewById(R.id.editText14);
        step7 = findViewById(R.id.editText15);
        step8 = findViewById(R.id.editText16);
        step9 = findViewById(R.id.editText17);
        step10 = findViewById(R.id.editText18);
        step11 = findViewById(R.id.editText19);
        step12 = findViewById(R.id.editText20);
        step13 = findViewById(R.id.editText21);
        step14 = findViewById(R.id.editText22);
        step15 = findViewById(R.id.editText23);
        step16 = findViewById(R.id.editText24);
        step17 = findViewById(R.id.editText25);
        step18 = findViewById(R.id.editText26);
        step19 = findViewById(R.id.editText27);
        step20 = findViewById(R.id.editText28);
        add = findViewById(R.id.button5);
        presenter = new MyPresenter(this, new MyModel());


        add.setOnClickListener(view -> {
            presenter.onAddmyrecipeButtonTouched(Add_Recipe_Activty.this);
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

        Recipe data = new Recipe();
        data.setMaker(getIntent().getStringExtra("user"));
        data.setRCP_NM(title.getText().toString());
        data.setRCP_WAY2(method.getText().toString());
        data.setINFO_WGT(wgt.getText().toString());
        data.setINFO_ENG(cal.getText().toString());
        data.setRCP_PARTS_DTLS(ingredient.getText().toString());
        data.setMANUAL01(step1.getText().toString());
        data.setMANUAL02(step2.getText().toString());
        data.setMANUAL03(step3.getText().toString());
        data.setMANUAL04(step4.getText().toString());
        data.setMANUAL05(step5.getText().toString());
        data.setMANUAL06(step6.getText().toString());
        data.setMANUAL07(step7.getText().toString());
        data.setMANUAL08(step8.getText().toString());
        data.setMANUAL09(step9.getText().toString());
        data.setMANUAL10(step10.getText().toString());
        data.setMANUAL11(step11.getText().toString());
        data.setMANUAL12(step12.getText().toString());
        data.setMANUAL13(step13.getText().toString());
        data.setMANUAL14(step14.getText().toString());
        data.setMANUAL15(step15.getText().toString());
        data.setMANUAL16(step16.getText().toString());
        data.setMANUAL17(step17.getText().toString());
        data.setMANUAL18(step18.getText().toString());
        data.setMANUAL19(step19.getText().toString());
        data.setMANUAL20(step20.getText().toString());

        return data;
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