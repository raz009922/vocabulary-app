package project.ahsan.language.com.vocabularyapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.model.Word;
import project.ahsan.language.com.vocabularyapp.ui.pager.DefinationPagerAdapter;
import project.ahsan.language.com.vocabularyapp.ui.pager.TranslationPagerAdapter;

public class WordFragment extends BaseFragment {

    private Word word;

    private TextView  wordTextView;
    private TextView  pronounceTextView;
    private ViewPager definationViewPager;
    private ViewPager translationViewPager;
    private DefinationPagerAdapter definationPagerAdapter;
    private TranslationPagerAdapter translationPagerAdapter;

    public WordFragment(){

    }

    public static WordFragment newInstance(Word word){
        WordFragment wordFragment = new WordFragment();
        wordFragment.word = word;
        return wordFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        initViews(view);
        init();
        initDefinationViewPager(view);
        initTranslationViewPager(view);
        return view;
    }

    private void initTranslationViewPager(View view) {
        translationViewPager = view.findViewById(R.id.translation_view_pager);
        translationPagerAdapter = new TranslationPagerAdapter(getActivity().getSupportFragmentManager(), word.getTranslations());
        translationViewPager.setAdapter(translationPagerAdapter);
    }

    private void initDefinationViewPager(View view) {
        definationViewPager = view.findViewById(R.id.defination_view_pager);
        definationPagerAdapter = new DefinationPagerAdapter(getActivity().getSupportFragmentManager(),word.getDefinations());
        definationViewPager.setAdapter(definationPagerAdapter);
    }

    private void initViews(View view) {
        wordTextView = view.findViewById(R.id.word_text_view);
        pronounceTextView = view.findViewById(R.id.pronouce_text_view);
    }

    void init(){
        wordTextView.setText(word.getWord());
        pronounceTextView.setText(word.getPronounciation());
    }


}
