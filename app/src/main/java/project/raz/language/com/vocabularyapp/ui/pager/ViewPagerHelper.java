package project.ahsan.language.com.vocabularyapp.ui.pager;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import project.ahsan.language.com.vocabularyapp.ui.tab.TabStrip;

public class ViewPagerHelper {

    ViewPager viewPager;
    FragmentManager manager;
    ViewPagerAdapter viewPagerAdapter;
    TabStrip tabStrip;

    public ViewPagerHelper(ViewPager viewPager, TabStrip tabStrip, FragmentManager fragmentManager) {
        this.viewPager = viewPager;
        this.manager = fragmentManager;
        this.tabStrip = tabStrip;
        init();
    }

    private void init() {
        viewPagerAdapter = new ViewPagerAdapter(manager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabStrip.setSelectedFragment(position);
            }
        });
        tabStrip.setTabStripCallbacks(new TabStrip.TabStripCallbacks() {
            @Override
            public void onTabClick(int position) {
                viewPager.setCurrentItem(position);
            }
        });

    }

    public void onDataSetFetched(){
        viewPagerAdapter.onDataFetched();
    }

    public void refreshList(){
        viewPagerAdapter.refreshList();
    }
}
