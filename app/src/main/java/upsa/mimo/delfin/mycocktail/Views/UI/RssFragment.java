package upsa.mimo.delfin.mycocktail.Views.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import upsa.mimo.delfin.mycocktail.ViewModels.BO.Article;
import upsa.mimo.delfin.mycocktail.ViewModels.BO.ArticlesAdapter;
import upsa.mimo.delfin.mycocktail.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RssFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RssFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RssFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rss_recycler_view;

    private OnFragmentInteractionListener mListener;

    public RssFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RssFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RssFragment newInstance(String param1, String param2) {
        RssFragment fragment = new RssFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rss, container, false);
        // Inflate the layout for this fragment

        rss_recycler_view = view.findViewById(R.id.recycle_view_rss);

        ArrayList<Article> articles = this.createRandomData();

        ArticlesAdapter articlesAdapter = new ArticlesAdapter(getContext(), articles);

        rss_recycler_view.setAdapter(articlesAdapter);
        rss_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    private ArrayList<Article> createRandomData() {
        ArrayList<Article> articles = new ArrayList<>();
        Article a = new Article("https://www.google.org/assets/static/images/logo_googledotorg-171e7482e5523603fc0eed236dd772d8.svg",
                "Title of the article 1",
                "Description of the artivle 1");

        Article b = new Article("https://www.google.org/assets/static/images/logo_googledotorg-171e7482e5523603fc0eed236dd772d8.svg",
                "Title of the article 2",
                "Description of the artivle 2");


        Article c = new Article("https://www.google.org/assets/static/images/logo_googledotorg-171e7482e5523603fc0eed236dd772d8.svg",
                "Title of the article 3",
                "Description of the artivle 3");

        articles.add(a);
        articles.add(b);
        articles.add(c);

        return articles;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context, "RssFragment attached", Toast.LENGTH_LONG);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
