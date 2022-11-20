package edu.skku.cs.project;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MyPresenter implements MyContract.ContractForPresenter {

    private MyContract.ContractForView view;
    private MyContract.ContractForModel model;

    public MyPresenter(MyContract.ContractForView view, MyContract.ContractForModel model)
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public boolean onLoginButtonTouched(String id, String pw, Context context)  {

        if(model.PostID("login", id, pw))
        {
            view.StartActivity(model.ChangeActivity(context, MainActivity2.class,id));
        }
        else
        {
            view.makeToastMessage("Failed");
        }

        return model.PostID("login", id, pw);

    }

    @Override
    public boolean onSingupButtonTouched(String id, String pw)  {

        if(model.PostID("adduser", id, pw))
        {
            view.makeToastMessage("Success");
        }
        else
        {
            view.makeToastMessage("Failed");
        }
        return model.PostID("adduser", id, pw);
    }



    @Override
    public void onSearchButtonTouched(String name) {
        apiData data = model.getfromAPI(name);
        ArrayList<Recipe> items = new ArrayList<>();

        if(!data.getCOOKRCP01().getTotal_count().equals("0"))
        {
            for (int i = 0; i < data.getCOOKRCP01().getRow().length; i++) {
                items.add(data.getCOOKRCP01().getRow()[i]);
            }
        }

        apiData data2 = model.getfromAWSbyname(name);

        if(!data2.getCOOKRCP01().getTotal_count().equals("0"))
        {
            for (int i = 0; i < data2.getCOOKRCP01().getRow().length; i++) {
                items.add(data2.getCOOKRCP01().getRow()[i]);
            }
        }

        view.setAdapter(items);

        if(data.getCOOKRCP01().getTotal_count().equals("0") && data2.getCOOKRCP01().getTotal_count().equals("0"))
        {
            view.makeToastMessage("레시피 정보가 없습니다.");
        }



    }

    @Override
    public void onListviewTouched(ListviewAdapter listviewAdapter, int i, Context context) {
        final Recipe item = (Recipe) listviewAdapter.getItem(i);
        view.StartActivity(model.makerecipeIntent(context, Recipe_Activity.class, item));

    }

    @Override
    public void setviews(Intent intent) {
        Recipe item = (Recipe) intent.getSerializableExtra("item");
        view.setrecipeinfo(item);
        ArrayList<Ways> items = new ArrayList<Ways>();


        Log.i("test", "manual is " + item.getMANUAL05() + "img is " + item.getMANUAL_IMG05());
        if(item.getMANUAL01() != null || item.getMANUAL_IMG01() != null) {
            if (item.getMANUAL01().length() != 0 || item.getMANUAL_IMG01().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG01(), item.getMANUAL01());
                items.add(way);
            }
        }
        if(item.getMANUAL02() != null || item.getMANUAL_IMG02() != null) {
            if (item.getMANUAL02().length() != 0 || item.getMANUAL_IMG02().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG02(), item.getMANUAL02());
                items.add(way);
            }
        }
        if(item.getMANUAL03() != null || item.getMANUAL_IMG03() != null) {
            if (item.getMANUAL03().length() != 0 || item.getMANUAL_IMG03().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG03(), item.getMANUAL03());
                items.add(way);
            }
        }

        if(item.getMANUAL04() != null || item.getMANUAL_IMG04() != null) {
            if (item.getMANUAL04().length() != 0 || item.getMANUAL_IMG04().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG04(), item.getMANUAL04());
                items.add(way);
            }
        }
        if(item.getMANUAL05() != null || item.getMANUAL_IMG05() != null) {
            if (item.getMANUAL05().length() != 0 || item.getMANUAL_IMG05().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG05(), item.getMANUAL05());
                items.add(way);
            }
        }
        if(item.getMANUAL06() != null || item.getMANUAL_IMG06() != null) {
            if (item.getMANUAL06().length() != 0 || item.getMANUAL_IMG06().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG06(), item.getMANUAL06());
                items.add(way);
            }
        }
        if(item.getMANUAL07() != null || item.getMANUAL_IMG07() != null) {
            if (item.getMANUAL07().length() != 0 || item.getMANUAL_IMG07().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG07(), item.getMANUAL07());
                items.add(way);
            }
        }
        if(item.getMANUAL08() != null || item.getMANUAL_IMG08() != null) {
            if (item.getMANUAL08().length() != 0 || item.getMANUAL_IMG08().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG08(), item.getMANUAL08());
                items.add(way);
            }
        }
        if(item.getMANUAL09() != null || item.getMANUAL_IMG09() != null) {
            if (item.getMANUAL09().length() != 0 || item.getMANUAL_IMG09().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG09(), item.getMANUAL09());
                items.add(way);
            }
        }
        if(item.getMANUAL10() != null || item.getMANUAL_IMG10() != null) {
            if (item.getMANUAL10().length() != 0 || item.getMANUAL_IMG10().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG10(), item.getMANUAL10());
                items.add(way);
            }
        }
        if(item.getMANUAL11() != null || item.getMANUAL_IMG11() != null) {
            if (item.getMANUAL11().length() != 0 || item.getMANUAL_IMG11().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG11(), item.getMANUAL11());
                items.add(way);
            }
        }
        if(item.getMANUAL12() != null || item.getMANUAL_IMG12() != null) {
            if (item.getMANUAL12().length() != 0 || item.getMANUAL_IMG12().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG12(), item.getMANUAL12());
                items.add(way);
            }
        }
        if(item.getMANUAL13() != null || item.getMANUAL_IMG13() != null) {
            if (item.getMANUAL13().length() != 0 || item.getMANUAL_IMG13().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG13(), item.getMANUAL13());
                items.add(way);
            }
        }
        if(item.getMANUAL14() != null || item.getMANUAL_IMG14() != null) {
            if (item.getMANUAL14().length() != 0 || item.getMANUAL_IMG14().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG14(), item.getMANUAL14());
                items.add(way);
            }
        }
        if(item.getMANUAL15() != null || item.getMANUAL_IMG15() != null) {
            if (item.getMANUAL15().length() != 0 || item.getMANUAL_IMG15().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG15(), item.getMANUAL15());
                items.add(way);
            }
        }
        if(item.getMANUAL16() != null || item.getMANUAL_IMG16() != null) {
            if (item.getMANUAL16().length() != 0 || item.getMANUAL_IMG16().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG16(), item.getMANUAL16());
                items.add(way);
            }
        }
        if(item.getMANUAL17() != null || item.getMANUAL_IMG17() != null) {
            if (item.getMANUAL17().length() != 0 || item.getMANUAL_IMG17().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG17(), item.getMANUAL17());
                items.add(way);
            }
        }
        if(item.getMANUAL18() != null || item.getMANUAL_IMG18() != null) {
            if (item.getMANUAL18().length() != 0 || item.getMANUAL_IMG18().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG18(), item.getMANUAL18());
                items.add(way);
            }
        }
        if(item.getMANUAL19() != null || item.getMANUAL_IMG19() != null) {
            if (item.getMANUAL19().length() != 0 || item.getMANUAL_IMG19().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG19(), item.getMANUAL19());
                items.add(way);
            }
        }
        if(item.getMANUAL20() != null || item.getMANUAL_IMG20() != null) {
            if (item.getMANUAL20().length() != 0 || item.getMANUAL_IMG20().length() != 0) {
                Ways way = new Ways(item.getMANUAL_IMG20(), item.getMANUAL20());
                items.add(way);
            }
        }
        view.setmethodlist(items);
        view.setListViewHeightBasedOnItems();
    }

    @Override
    public void onSettingButtonTouced(Intent intent, Context context) {

        view.StartActivity(model.ChangeActivity(context, setting_Activity.class,intent.getStringExtra("user")));
    }

    @Override
    public void onAddButtonTouched(Intent intent, Context context) {
        String user = intent.getStringExtra("user");
        view.finishview();
        view.StartActivity(model.ChangeActivity(context, Add_Recipe_Activty.class,user));

    }

    @Override
    public void setuserinfo(Intent intent) {
        String user = intent.getStringExtra("user");
        view.setusername(user);
        Log.i("debug", user);
        apiData data = model.getfromAWSbyuser(user);

        if(!data.getCOOKRCP01().getTotal_count().equals("0"))
        {

            ArrayList<Recipe> items = new ArrayList<>();

            for (int i = 0; i < data.getCOOKRCP01().getRow().length; i++) {
                items.add(data.getCOOKRCP01().getRow()[i]);
            }

            view.setAdapter(items);
        }


    }

    @Override
    public void onAddmyrecipeButtonTouched(Context context) {
        Recipe data = view.getrecipeinfo();

        boolean success = model.addtoAWS(data);

        if(success)
        {
            view.finishview();
            view.StartActivity(model.ChangeActivity(context, setting_Activity.class, data.getMaker()));
        }
        else
        {
            view.makeToastMessage("failed");
        }


    }

    @Override
    public void deleterecipedata(String user, String name) {
        model.deleteRecipe(user, name);
    }

    @Override
    public void onMyrecipelistviewTouched(MyrecipeAdapter myrecipeAdapter, int i, Context context) {
        final Recipe item = (Recipe) myrecipeAdapter.getItem(i);
        view.StartActivity(model.makerecipeIntent(context, Recipe_Activity.class, item));
    }
}
