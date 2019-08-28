package project.ahsan.language.com.vocabularyapp.manager;

import java.util.ArrayList;

import project.ahsan.language.com.vocabularyapp.model.WordBundle;

public class DataManager {
    private static DataManager dataManager = new DataManager();

    private int selectedBundle = 0;
    private ArrayList<WordBundle>wordBundles = new ArrayList<>();

    private DataManager() {
    }

    public static DataManager sharedInstance(){
        return dataManager;
    }

    public void setWordBundles(ArrayList<WordBundle> wordBundles) {
        this.wordBundles = wordBundles;
    }

    public WordBundle getWordBundle(){
        if(selectedBundle > wordBundles.size() - 1) return wordBundles.get(0);
        return wordBundles.get(selectedBundle);
    }

    public void setSelectedBundle(int selectedBundle){
        this.selectedBundle = selectedBundle;
    }

    public ArrayList<WordBundle> getWordBundles(){
        return wordBundles;
    }
}
