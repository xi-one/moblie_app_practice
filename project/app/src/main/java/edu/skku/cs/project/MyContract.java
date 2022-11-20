package edu.skku.cs.project;

import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.util.ArrayList;

public interface MyContract {




    interface ContractForView{
        void makeToastMessage(String text);
        void StartActivity(Intent intent);
        void setAdapter(ArrayList<Recipe> items);
        void setrecipeinfo(Recipe item);
        void setmethodlist(ArrayList<Ways> items);
        void setusername(String user);
        Recipe getrecipeinfo();
        void finishview();
        boolean setListViewHeightBasedOnItems();

    }

    interface ContractForModel{
        boolean PostID (String type, String id, String pw);
        Intent ChangeActivity(Context from, Class to, String user);
        apiData getfromAPI(String name);
        Intent makerecipeIntent(Context from, Class to, Recipe item);
        apiData getfromAWSbyuser(String user);
        apiData getfromAWSbyname(String name);
        boolean deleteRecipe(String user, String name);
        boolean addtoAWS(Recipe data);

    }

    interface ContractForPresenter{
        boolean onLoginButtonTouched(String id, String pw, Context context);
        boolean onSingupButtonTouched(String id, String pw);
        void onSearchButtonTouched(String name);
        void onListviewTouched(ListviewAdapter listviewAdapter, int i, Context context);
        void setviews(Intent intent);
        void onSettingButtonTouced(Intent intent, Context context);
        void onAddButtonTouched(Intent intent, Context context);
        void setuserinfo(Intent intent);
        void onAddmyrecipeButtonTouched(Context context);
        void deleterecipedata(String user, String name);
        void onMyrecipelistviewTouched(MyrecipeAdapter myrecipeAdapter, int i, Context context);



    }

}
