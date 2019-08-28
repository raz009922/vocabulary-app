package project.ahsan.language.com.vocabularyapp.model;

public class Defination {
    String meaning;
    String example;
    String partOfSpeech;

    public Defination(String meaning, String example, String partOfSpeech) {
        this.meaning = meaning;
        this.example = example;
        this.partOfSpeech = partOfSpeech;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
}
