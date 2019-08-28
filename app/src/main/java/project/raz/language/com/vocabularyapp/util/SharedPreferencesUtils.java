package project.ahsan.language.com.vocabularyapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import javax.security.auth.PrivateCredentialPermission;

public class SharedPreferencesUtils {

    public static String WORD_TRACKING = "word_tracking_APP_VOC";
    public static String WORD_FETCHING = "word_fetching_APP_VOC";

    public static void setWordTracking(Context context, String word){
        SharedPreferences preferences = context.getSharedPreferences(WORD_TRACKING, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(word, true);
        editor.apply();
    }

    public static boolean getWordStatus(Context context, String word){
        SharedPreferences preferences = context.getSharedPreferences(WORD_TRACKING, Context.MODE_PRIVATE);
        return preferences.getBoolean(word, false);
    }

    public static void setWordFetching(Context context, boolean status){
        SharedPreferences preferences = context.getSharedPreferences(WORD_FETCHING, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(WORD_FETCHING, status);
        editor.apply();
    }

    public static boolean getFetchingStatus(Context context){
        SharedPreferences preferences = context.getSharedPreferences(WORD_FETCHING, Context.MODE_PRIVATE);
        return preferences.getBoolean(WORD_FETCHING, false);
    }

}
