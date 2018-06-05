package upsa.mimo.delfin.mycocktail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticlesAdapter extends ArrayAdapter<Article> {

    private Context context;
    private ArrayList<Article> articles;

    public ArticlesAdapter(@NonNull Context context, ArrayList<Article> articles) {
        super(context, R.layout.article_view, articles);
        this.context = context;
        this.articles = articles;
    }

    public void ArticlesAdapter(Context context, ArrayList articles){
        this.context = context;
        this.articles = articles;
    }
    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Article getItem(int i) {
        return articles.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater articlesInflater = LayoutInflater.from(getContext());

        View customView = articlesInflater.inflate(R.layout.article_view, viewGroup, false);

        Article article = (Article) getItem(i);

        String title = article.getTitle();
        String description = article.getDescription();

        String urlImage = article.getArticleImage();

        ImageView imageView = (ImageView) view.findViewById(R.id.article_image);
        TextView articleTitle = (TextView) view.findViewById(R.id.article_title);
        TextView articleDesc = (TextView) view.findViewById(R.id.article_description);



        return customView;
    }


}
