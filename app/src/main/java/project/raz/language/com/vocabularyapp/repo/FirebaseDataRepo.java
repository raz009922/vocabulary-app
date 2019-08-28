package project.ahsan.language.com.vocabularyapp.repo;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import project.ahsan.language.com.vocabularyapp.application.VocabularyApplication;
import project.ahsan.language.com.vocabularyapp.model.Defination;
import project.ahsan.language.com.vocabularyapp.model.Translation;
import project.ahsan.language.com.vocabularyapp.model.Word;
import project.ahsan.language.com.vocabularyapp.model.WordBundle;
import project.ahsan.language.com.vocabularyapp.util.SharedPreferencesUtils;

public class FirebaseDataRepo {
    private static FirebaseDataRepo firebaseDataRepo = new FirebaseDataRepo();
    private ArrayList<WordBundle> arrayList = new ArrayList<>();

    private FetchListener fetchListener;

    private FirebaseDataRepo() {

    }

    public static FirebaseDataRepo sharedInstance() {
        return firebaseDataRepo;
    }

    public void fetchData(FetchListener fetchListener){
        this.fetchListener = fetchListener;
        startFetchingData();
    }

    private void startFetchingData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long count = dataSnapshot.child("").getChildrenCount();
                Log.d("TAG", "onDataChange: " + count);
                for (DataSnapshot data : dataSnapshot.getChildren()) {

                    String title = data.child("Deck").getValue(String.class);
                    String type = data.child("Type").getValue(String.class);
                    WordBundle wordBundle = new WordBundle(title, type);

                    for (DataSnapshot dataChild : data.child("Words").getChildren()) {

                        String word = dataChild.child("Word").getValue(String.class);
                        String pronunc = dataChild.child("Pronunciation").getValue(String.class);
                        Log.d("TAG", "onDataChange: " + word + " " + pronunc);
                        Word nWord = new Word(word, pronunc);

                        addAllTranslations(dataChild, nWord);

                        for (DataSnapshot dataGran : dataChild.child("Defination").getChildren()) {
                            String mean = dataGran.child("Meaning").getValue(String.class);
                            String exp = dataGran.child("Example").getValue(String.class);
                            String pos = dataGran.child("Part of Speech").getValue(String.class);
                            Log.d("TAG", "onDataChange: " + mean + " + " +  exp + " + " +  pos );
                            Defination defination = new Defination(mean, exp, pos);
                            nWord.addDefination(defination);
                        }
                        Log.d("TAG", "onDataChange: trans " + nWord.getTranslations().size());

                        wordBundle.addWordToList(nWord);
                        if(SharedPreferencesUtils.getWordStatus(VocabularyApplication.getContext(),nWord.getWord())){
                            wordBundle.addWordToRevisionList(nWord);
                        }
                        else{
                            wordBundle.addWordToNewList(nWord);
                        }

                    }

                    arrayList.add(wordBundle);

                }

                fetchListener.onFetchSuccessFull(arrayList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                fetchListener.onFetchFailed();
            }
        });
    }

    private void addAllTranslations(DataSnapshot dataChild, Word nWord) {
        Translation translation;
        String lang = "Arabic";
        String val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Chinese";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Croatian";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Czech";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Danish";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Dutch";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Finnish";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "French";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "German";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Greek";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Italian";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Japanese";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Korean";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Norwegian";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Polish";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Portuguese";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Romanian";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Russian";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Spanish";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Swedish";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Thai";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Turkish";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Ukrainian";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Vietnamese";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Hindi";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
        lang = "Bangali";
        val = dataChild.child(lang).getValue(String.class);
        translation = new Translation(lang, val);
        nWord.addTranslation(translation);
    }

    public interface FetchListener{
        void onFetchSuccessFull(ArrayList<WordBundle>arrayList );
        void onFetchFailed();
    }

}
