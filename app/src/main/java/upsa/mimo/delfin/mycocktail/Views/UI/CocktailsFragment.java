package upsa.mimo.delfin.mycocktail.Views.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import upsa.mimo.delfin.mycocktail.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CocktailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CocktailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CocktailsFragment extends Fragment
        implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public CocktailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CocktailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CocktailsFragment newInstance(String param1, String param2) {
        CocktailsFragment fragment = new CocktailsFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cocktails, container, false);

        if(view != null){
            View toolBar = view.findViewById(R.id.tool_bar_cocktails);
            toolBar.getBackground().setAlpha(40);
        }


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @SuppressLint("ShowToast")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(getContext(), "Cocktails Fragments Created", Toast.LENGTH_LONG);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        //android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        //android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (view.getId()){
            case R.id.ginsSection:
                //transaction.replace(R.id.container, new CocktailsSectionDetailFragment()).commit();
                break;
            case R.id.rumsSection:
                break;
            case R.id.whiskysSection:
                break;
            case R.id.othersSection:
                break;
            default:
                break;
        }
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
