package project.ahsan.language.com.vocabularyapp.ui.pager;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import project.ahsan.language.com.vocabularyapp.fragment.DefinationFragment;
import project.ahsan.language.com.vocabularyapp.model.Defination;

public class DefinationPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Defination>definations = new ArrayList<>();
    ArrayList<DefinationFragment> fragments = new ArrayList<>();


    public DefinationPagerAdapter(FragmentManager fm, ArrayList<Defination>definations) {
        super(fm);
        this.definations = definations;
        init();
    }

    void init(){
        for(Defination def:definations){
            DefinationFragment fragment = DefinationFragment.newInstance(def);
            fragments.add(fragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return definations.size();
    }
}
