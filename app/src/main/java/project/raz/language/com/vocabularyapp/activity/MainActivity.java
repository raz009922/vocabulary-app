package project.ahsan.language.com.vocabularyapp.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.manager.ADManager;
import project.ahsan.language.com.vocabularyapp.manager.DataManager;
import project.ahsan.language.com.vocabularyapp.model.WordBundle;
import project.ahsan.language.com.vocabularyapp.repo.FirebaseDataRepo;
import project.ahsan.language.com.vocabularyapp.ui.drawer.NavDrawerHelper;
import project.ahsan.language.com.vocabularyapp.ui.pager.ViewPagerHelper;
import project.ahsan.language.com.vocabularyapp.ui.tab.TabStrip;

public class MainActivity extends AppCompatActivity {


    // Drawer

    DrawerLayout mDrawerLayout;
    RecyclerView navigationDrawerRecyclerView;
    ImageView drawerHeaderImageView;
    TextView termsTextView;
    TextView privacyTextView;
    RelativeLayout navigationIcon;
    RelativeLayout tryPremiumTextLayout;

    // ViewPager
    ViewPager viewPager;
    TabStrip tabStrip;


    private NavDrawerHelper navDrawerHelper;
    private ViewPagerHelper viewPagerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initNavDrawerHelper();
        initToolBar();
        initPager();
        initAD();
        initFetcher();
    }



    @Override
    protected void onStart() {
        super.onStart();

        navDrawerHelper.setDataSetToRecyclerView();
        //initFetcher();
        //viewPagerHelper.refreshList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //viewPagerHelper.refreshList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Log.d("TAG", "onDestroy: " );
    }

    private void initFetcher() {
        if(DataManager.sharedInstance().getWordBundles().size() > 0 ) return;
        FirebaseDataRepo.sharedInstance().fetchData(new FirebaseDataRepo.FetchListener() {
            @Override
            public void onFetchSuccessFull(ArrayList<WordBundle> arrayList) {
                DataManager.sharedInstance().setWordBundles(arrayList);
                viewPagerHelper.onDataSetFetched();
            }

            @Override
            public void onFetchFailed() {

            }
        });
    }

    private void initViews(){
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationDrawerRecyclerView = findViewById(R.id.recyler_view_navigation_drawer);
        drawerHeaderImageView = findViewById(R.id.image_drawer_header);
        termsTextView = findViewById(R.id.text_terms);
        privacyTextView = findViewById(R.id.text_privacy);
        navigationIcon = findViewById(R.id.layout_menu);
        tryPremiumTextLayout = findViewById(R.id.layout_try_premium);

        viewPager = findViewById(R.id.viewpager);
        tabStrip = findViewById(R.id.tabstrip);
    }

    private void initPager(){
        viewPagerHelper = new ViewPagerHelper(viewPager, tabStrip ,getSupportFragmentManager());
        OverScrollDecoratorHelper.setUpOverScroll(tabStrip, OverScrollDecoratorHelper.ORIENTATION_HORIZONTAL);
    }

    private void initNavDrawerHelper() {
        navDrawerHelper = new NavDrawerHelper(this, mDrawerLayout, navigationDrawerRecyclerView,
                tryPremiumTextLayout, drawerHeaderImageView, termsTextView, privacyTextView);
        OverScrollDecoratorHelper.setUpOverScroll(navigationDrawerRecyclerView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }


    void initToolBar() {
        navigationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void initAD() {
        ADManager.sharedInstance().setContext(getApplicationContext());
        ADManager.sharedInstance().initFullScreenAD();
    }

}
