package project.ahsan.language.com.vocabularyapp.ui.pager;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import project.ahsan.language.com.vocabularyapp.fragment.DefinationFragment;
import project.ahsan.language.com.vocabularyapp.fragment.TranslationFragment;
import project.ahsan.language.com.vocabularyapp.model.Defination;
import project.ahsan.language.com.vocabularyapp.model.Translation;

public class TranslationPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Translation>translations = new ArrayList<>();
    ArrayList<TranslationFragment> fragments = new ArrayList<>();


    public TranslationPagerAdapter(FragmentManager fm, ArrayList<Translation>translations) {
        super(fm);
        this.translations = translations;
        init();
    }

    void init(){
        for(Translation trans:translations){
            TranslationFragment fragment = TranslationFragment.newInstance(trans);
            fragments.add(fragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return translations.size();
    }
}
