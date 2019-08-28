package project.ahsan.language.com.vocabularyapp.ui.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import project.ahsan.language.com.vocabularyapp.ui.tab.TabAdapter;

public class TabStrip extends RecyclerView {

    ArrayList<String> titleList;
    TabAdapter tabAdapter;

    TabStripCallbacks tabStripCallbacks;
    Context context;

    public TabStrip(@NonNull Context context) {
        super(context);
        init(context);
    }

    public TabStrip(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabStrip(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public void setTabStripCallbacks(TabStripCallbacks tabStripCallbacks) {
        this.tabStripCallbacks = tabStripCallbacks;
    }

    void init(Context context){
        this.context = context;
        tabAdapter = new TabAdapter(context);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("LEARN");
        arrayList.add("PRACTICE");
        arrayList.add("TEST");
        tabAdapter.setTitleList(arrayList);
        tabAdapter.setTabAdapterCallbacks(new TabAdapter.TabAdapterCallbacks() {
            @Override
            public void onClickOnTab(View view, int position) {
                tabAdapter.setSelectedPosition(position);
                //setSelectedItemToMiddle(view);
                if(tabStripCallbacks != null){
                    tabStripCallbacks.onTabClick(position);
                }
                setSelectedItemToMiddle(view);
            }
        });
        this.setAdapter(tabAdapter);
        this.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
    }

    public void setTitleList(ArrayList<String> titleList) {
        this.titleList = titleList;
    }

    private void setSelectedItemToMiddle(View view) {
        int deviceWidth = context.getResources().getDisplayMetrics().widthPixels;
        int center = deviceWidth / 2;
        center = center - (view.getWidth() / 2);

        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int scroll = center - location[0];

        this.smoothScrollBy(-scroll, 0);
    }

    public void setSelectedFragment(int position){
        tabAdapter.setSelectedPosition(position);
        setSelectedItemToMiddle(this.getChildAt(position));
    }

    public interface TabStripCallbacks{
        void onTabClick(int position);
    }
}
