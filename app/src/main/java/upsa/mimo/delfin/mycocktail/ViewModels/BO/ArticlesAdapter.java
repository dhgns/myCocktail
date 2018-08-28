package upsa.mimo.delfin.mycocktail.ViewModels.BO;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import upsa.mimo.delfin.mycocktail.R;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArcticlesAdapterHolder> {

    private Context context;
    private ArrayList<Article> articles;
    private RecyclerView rv;

    public ArticlesAdapter(Context context, ArrayList<Article> articles){
        this.context = context;
        this.articles = articles;
    }

    @Override
    public void onAttachedToRecyclerView( RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.rv = recyclerView;
    }


    @Override
    public ArcticlesAdapterHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View articleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_row_view, parent, false);

        ArcticlesAdapterHolder arcticlesAdapterHolder = new ArcticlesAdapterHolder(articleView);

        return arcticlesAdapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArcticlesAdapterHolder holder, int position) {
        Article article = articles.get(position);

        //Add the context here if you need to includ som libraries from the app to rendder the article
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ArcticlesAdapterHolder extends RecyclerView.ViewHolder {

        private ImageView articleImage;
        private TextView articleTitle;
        private TextView articleDescription;

        public ArcticlesAdapterHolder(View itemView) {
            super(itemView);

            articleImage = itemView.findViewById(R.id.article_image);
            articleTitle = itemView.findViewById(R.id.article_title);
            articleDescription = itemView.findViewById(R.id.article_description);

        }

        public void bind (Article article){
            articleDescription.setText(article.getDescription());
            articleTitle.setText(article.getTitle());
            Picasso.get().load(article.getArticleImage()).into(articleImage);
        }
    }

}
