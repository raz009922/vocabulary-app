package project.ahsan.language.com.vocabularyapp.application;

import android.app.Application;
import android.content.Context;

import com.google.firebase.database.FirebaseDatabase;

import project.ahsan.language.com.vocabularyapp.repo.FirebaseDataRepo;

public class VocabularyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this.getApplicationContext();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    public static Context getContext(){
        return context;
    }
}
