package project.ahsan.language.com.vocabularyapp.manager;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class ADManager {
    private static ADManager adManager = new ADManager();

    private static final String FULLSCREEN_AD_ID = "ca-app-pub-3940256099942544/1033173712";
    private   static String MOBILE_ADD_ID = "ca-app-pub-3940256099942544~3347511713";


    private Context context;
    InterstitialAd mInterstitialAd;

    private ADManager(){

    }

    public static ADManager sharedInstance(){
        return adManager;
    }

    public void setContext(Context context){
        this.context = context;
        initAD(context);
    }


    private void initAD(Context context){
        MobileAds.initialize(context, MOBILE_ADD_ID);
    }

    public void initFullScreenAD(){

        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(FULLSCREEN_AD_ID);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.

            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

    }

    public void showFullScreenAD(){
        if(!mInterstitialAd.isLoaded()) return;
        //Timber.d("error " +  "showFullScreenAD called");
//        /**/Log.d("TAG", "showFullScreenAD: called");
        mInterstitialAd.show();
    }


}
