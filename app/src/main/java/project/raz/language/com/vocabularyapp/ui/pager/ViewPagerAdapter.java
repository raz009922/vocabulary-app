package project.ahsan.language.com.vocabularyapp.ui.pager;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import project.ahsan.language.com.vocabularyapp.fragment.LearnFragment;
import project.ahsan.language.com.vocabularyapp.fragment.PracticeFragment;
import project.ahsan.language.com.vocabularyapp.fragment.TestFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    LearnFragment learnFragment;
    TestFragment testFragment;
    PracticeFragment practiceFragment;


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        learnFragment = LearnFragment.newInstance();
        practiceFragment = PracticeFragment.newInstance();
        testFragment = TestFragment.newInstance();
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return  learnFragment;
        }else if(position == 1 ){
            return practiceFragment;
        }
        else{
            return testFragment;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return  "LEARN";
        }else if(position == 1 ){
            return "PRACTICE";
        }
        else{
            return "TEST";
        }
    }

    public void onDataFetched(){
        learnFragment.onDataSetFetched();
    }

    public void refreshList(){
        learnFragment.onRefreshList();
    }

}
