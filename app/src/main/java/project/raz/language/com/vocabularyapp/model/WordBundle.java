package project.ahsan.language.com.vocabularyapp.model;

import java.util.ArrayList;

public class WordBundle {
        String title;
        String type;
        String description;
        String symbol;
        ArrayList<Word>wordArrayList = new ArrayList<>();
        ArrayList<Word>newWordList = new ArrayList<>();
        ArrayList<Word>revisionList = new ArrayList<>();

    public WordBundle(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public void addWordToList(Word word){
        wordArrayList.add(word);
    }

    public void addWordToNewList(Word word){
        newWordList.add(word);
    }

    public void addWordToRevisionList(Word word){
        revisionList.add(word);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Word> getWordArrayList() {
        return wordArrayList;
    }

    public void setWordArrayList(ArrayList<Word> wordArrayList) {
        this.wordArrayList = wordArrayList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Word> getNewWordList() {
        return newWordList;
    }

    public void setNewWordList(ArrayList<Word> newWordList) {
        this.newWordList = newWordList;
    }

    public ArrayList<Word> getRevisionList() {
        return revisionList;
    }

    public void setRevisionList(ArrayList<Word> revisionList) {
        this.revisionList = revisionList;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
