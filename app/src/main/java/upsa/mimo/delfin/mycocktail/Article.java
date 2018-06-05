package upsa.mimo.delfin.mycocktail;

import android.widget.ImageView;

class Article {

    private String articleImageURL;
    private String title;
    private String description;


    public String getArticleImage() {
        return articleImageURL;
    }

    public void setArticleImage(String articleImageURL) {
        this.articleImageURL = articleImageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
