package project.ahsan.language.com.vocabularyapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.fragment.LearnFragment;
import project.ahsan.language.com.vocabularyapp.fragment.WordFragment;
import project.ahsan.language.com.vocabularyapp.manager.DataManager;
import project.ahsan.language.com.vocabularyapp.model.Word;
import project.ahsan.language.com.vocabularyapp.model.WordBundle;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class LearnActivity extends AppCompatActivity {

    WordBundle wordBundle = DataManager.sharedInstance().getWordBundles().get(0);
    WordFragment wordFragment;

    RelativeLayout nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        initButton();
    }

    void initButton(){
        nextButton = findViewById(R.id.layout_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wordBundle.getNewWordList().size() <= 1){
                    finish();
                    return;
                }
                Word word = wordBundle.getNewWordList().get(0);
                wordBundle.getNewWordList().remove(word);
                wordBundle.getRevisionList().add(word);
                removeFragmentFromContainer();
                addFragmentToContainer(wordBundle.getNewWordList().get(0));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        wordBundle = DataManager.sharedInstance().getWordBundle();
        addFragmentToContainer(wordBundle.getNewWordList().get(0));
    }

    private void addFragmentToContainer(Word word){
        wordFragment = WordFragment.newInstance(word);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_container, wordFragment, WordFragment.class.getName())
                .setCustomAnimations(R.animator.slide_in,R.animator.slide_out)
                .commit();

    }

    private void removeFragmentFromContainer(){
        getSupportFragmentManager().beginTransaction().remove(wordFragment).commit();
    }


}
