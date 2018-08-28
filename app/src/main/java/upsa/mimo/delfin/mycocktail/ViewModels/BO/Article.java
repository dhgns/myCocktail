package upsa.mimo.delfin.mycocktail.ViewModels.BO;

public class Article {

    private String articleImageURL;
    private String title;
    private String description;

    public Article(String url, String title, String desc){
        this.articleImageURL = url;
        this.title = title;
        this.description = desc;
    }


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
