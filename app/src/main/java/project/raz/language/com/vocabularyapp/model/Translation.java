package project.ahsan.language.com.vocabularyapp.model;

public class Translation {
    String language;
    String translation;

    public Translation(String language, String translation) {
        this.language = language;
        this.translation = translation;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
