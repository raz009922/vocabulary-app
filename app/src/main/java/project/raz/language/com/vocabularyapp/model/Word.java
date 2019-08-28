package project.ahsan.language.com.vocabularyapp.model;

import java.util.ArrayList;

public class Word {
    ArrayList<Translation> translations = new ArrayList<>();
    ArrayList<Defination> definations = new ArrayList<>();
    String word;
    String pronounciation;

    public Word(String word, String pronounciation) {
        this.word = word;
        this.pronounciation = pronounciation;
    }

    public void addTranslation(Translation translation){
        translations.add(translation);
    }

    public void addDefination(Defination defination){
        definations.add(defination);
    }

    public ArrayList<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(ArrayList<Translation> translations) {
        this.translations = translations;
    }

    public ArrayList<Defination> getDefinations() {
        return definations;
    }

    public void setDefinations(ArrayList<Defination> definations) {
        this.definations = definations;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronounciation() {
        return pronounciation;
    }

    public void setPronounciation(String pronounciation) {
        this.pronounciation = pronounciation;
    }
}
