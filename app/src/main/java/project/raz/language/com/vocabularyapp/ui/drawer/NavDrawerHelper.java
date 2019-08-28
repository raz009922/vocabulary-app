package project.ahsan.language.com.vocabularyapp.ui.drawer;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.activity.MoreAppActvity;
import project.ahsan.language.com.vocabularyapp.activity.SettingsActivity;
import project.ahsan.language.com.vocabularyapp.activity.StoreActivity;
import project.ahsan.language.com.vocabularyapp.manager.ADManager;


/**
 * Created by developerios on 7/9/18.
 */

public class NavDrawerHelper {

    private static final String TAG = NavDrawerHelper.class.getSimpleName();

    private FragmentActivity context;
    private DrawerLayout mDrawerLayout;
    private RecyclerView navigationDrawerRecyclerView;
    private NavigationDrawerAdapterView navigationDrawerAdapterView;
    private RelativeLayout tryPremiumTextLayout;
    private ImageView navDrawerHeaderImage;
    private TextView termsTextView;
    private TextView privacyTextView;
    private ArrayList<DrawerItem> drawerItems;

    public NavDrawerHelper(FragmentActivity context, DrawerLayout mDrawerLayout, RecyclerView navigationDrawerRecyclerView, RelativeLayout tryPremiumTextLayout,
                           ImageView navDrawerHeaderImage, TextView termsTextView, TextView privacyTextView) {
        this.context = context;
        this.mDrawerLayout = mDrawerLayout;
        this.navigationDrawerRecyclerView = navigationDrawerRecyclerView;
        this.tryPremiumTextLayout = tryPremiumTextLayout;
        this.navDrawerHeaderImage = navDrawerHeaderImage;
        this.termsTextView = termsTextView;
        this.privacyTextView = privacyTextView;
        initPremiumText();
        initNavigationItemList();
        initRecyclerView();
        initDrawerHeaderImage();
        initTermsAndPrivacyText();
    }

    private void initNavigationItemList() {
        DrawerItem drawerItem = new DrawerItem(1, R.drawable.ic_email_svg, R.string.string_contact);
        DrawerItem drawerItem1 = new DrawerItem(2, R.drawable.ic_rate_svg, R.string.string_rate_us);
        DrawerItem drawerItem5 = new DrawerItem(3, R.drawable.ic_group_svg, R.string.string_join_us);
        DrawerItem drawerItem2 = new DrawerItem(4, R.drawable.ic_more_svg, R.string.string_more_apps);
        DrawerItem drawerItem3 = new DrawerItem(5, R.drawable.ic_gift_svg, R.string.string_gift);
        DrawerItem drawerItem4 = new DrawerItem(6, R.drawable.ic_settings_svg, R.string.string_settings);
        DrawerItem drawerItem6 = new DrawerItem(7, R.drawable.ic_info_svg, R.string.string_about);
        drawerItems = new ArrayList<>();
        drawerItems.add(drawerItem);
        drawerItems.add(drawerItem1);
        drawerItems.add(drawerItem5);
        drawerItems.add(drawerItem2);
        drawerItems.add(drawerItem3);
        drawerItems.add(drawerItem4);
        drawerItems.add(drawerItem6);
    }

    private void initRecyclerView() {
        LinearLayoutManager navigationDrawerLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        navigationDrawerRecyclerView.setLayoutManager(navigationDrawerLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(navigationDrawerRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(navigationDrawerRecyclerView.getContext(), R.drawable.drawer_item_divider));
        navigationDrawerRecyclerView.addItemDecoration(dividerItemDecoration);

        navigationDrawerAdapterView = new NavigationDrawerAdapterView(context, new ArrayList<DrawerItem>());
        navigationDrawerAdapterView.setNavigationAdapterCallbacks(new NavigationDrawerAdapterView.NavigationAdapterCallbacks() {
            @Override
            public void navigationItemClicked(int position) {
                myLogD("navigationDrawerAdapterView : " + position);
                if(position != -1){
                    mDrawerLayout.closeDrawers();
                }

                if (position == 0) { // contact
                    contactUs(context);

                } else if (position == 1) { // rate us
                    rateUs(context);

                } else if(position == 2){ // join us


                } else if (position == 3) { // more
                    goToMoreApp();

                } else if (position == 4) { // gift
                    showAD();

                } else if (position == 5) { // settings
                    goToSettings();

                }
                else if( position == 6){

                }

            }
        });
        navigationDrawerRecyclerView.setAdapter(navigationDrawerAdapterView);

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                checkPurchaseAndUpdateUI();
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                checkPurchaseAndUpdateUI();
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void goToMoreApp() {
        Intent intent = new Intent(context, MoreAppActvity.class);
        context.startActivity(intent);
    }

    private void goToSettings(){
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }

    private void initPremiumText() {
        checkPurchaseAndUpdateUI();
        tryPremiumTextLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AppFragmentManager.sharedInstance().setAnimation(R.anim.slide_in_left, R.anim.slide_out_right);
//                AppFragmentManager.sharedInstance().addFragmentToBackStack(new PurchaseFragment(), PurchaseFragment.class.getName());
                goToStore();

//                Bundle bundle = BundleUtils.doubleKeyString(AnalyticsConstants.SCREEN_NAME, AnalyticsConstants.NAVIGATION_DRAWER, AnalyticsConstants.BUTTON_NAME, AnalyticsConstants.TRY_PREMIUM);
//                EventTracker.eventLog(AnalyticsConstants.CLICKED, bundle);

                mDrawerLayout.closeDrawers();
            }
        });
    }

    private void goToStore() {
        Intent intent = new Intent(context, StoreActivity.class);
        context.startActivity(intent);
    }

    private void initDrawerHeaderImage(){
//        Glide.with(context).load(R.drawable.bg_nav_banner_).into(navDrawerHeaderImage);
    }

    private void initTermsAndPrivacyText(){
        termsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTermsConditionPageKITE(context);
                mDrawerLayout.closeDrawers();
            }
        });
        privacyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPrivacyPageKITE(context);
                mDrawerLayout.closeDrawers();
            }
        });
    }

    private void showAD(){
        ADManager.sharedInstance().showFullScreenAD();
    }



    private void rateUs(FragmentActivity activity) {
        final String appPackageName = activity.getPackageName(); // getPackageName() from Context or Activity object
        try {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (ActivityNotFoundException anfe) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    private void contactUs(FragmentActivity activity) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to[] = {""};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        intent.setType("message/rfc822");

        final PackageManager pm = activity.getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
        String className = null;
        for (final ResolveInfo info : matches) {
            if (info.activityInfo.packageName.equals("com.google.android.gm")) {
                className = info.activityInfo.name;

                if (className != null && !className.isEmpty()) {
                    break;
                }
            }
        }

        intent.setClassName("com.google.android.gm", className);
        activity.startActivity(intent);

    }


    private void goToTermsConditionPageKITE(FragmentActivity activity) {
//        Uri uri = Uri.parse("https://sites.google.com/view/kgspolicy/terms-conditions");
//        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
//
//        likeIng.setPackage("com.instagram.android");
//
//        try {
//            activity.startActivity(likeIng);
//        } catch (ActivityNotFoundException e) {
//            activity.startActivity(new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("http://instagram.com/kitegamesstudio/")));
//        }
    }

    private void goToPrivacyPageKITE(FragmentActivity activity) {
//        Uri uri = Uri.parse("https://sites.google.com/view/kgspolicy/privacy-policy");
//        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
//
        //likeIng.setPackage("com.instagram.android");

//        try {
//            activity.startActivity(likeIng);
//        } catch (ActivityNotFoundException e) {
//            activity.startActivity(new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("http://instagram.com/kitegamesstudio/")));
//        }
    }

    private void checkPurchaseAndUpdateUI() {
//        if (isAllItemPurchased()) {
//            tryPremiumTextLayout.setVisibility(View.GONE);
//        }
    }

//    private boolean isAllItemPurchased() {
//        final Context appContext = ColorPopApplication.getContext();
//
//        boolean allItemPurchased = PurchaseController.isUnlockAllPurchased(appContext)
//                || PurchaseController.isPremiumSubscriptionPurchased(appContext);
//
//        boolean allItemPurchasedIndividually = PurchaseController.isAllFilterPurchased(appContext)
//                && PurchaseController.isRecolorPurchased(appContext)
//                && PurchaseController.isWatermarkPurchased(appContext);
//
//        return allItemPurchased || allItemPurchasedIndividually;
//    }

    public void setDataSetToRecyclerView() {
        navigationDrawerAdapterView.setDataSet(drawerItems);
    }

    private void myLogD(String text) {
        Log.d(TAG, text);
    }

}
