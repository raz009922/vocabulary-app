package project.ahsan.language.com.vocabularyapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.manager.DataManager;
import project.ahsan.language.com.vocabularyapp.ui.adapter.LearnItemAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LearnFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LearnFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearnFragment extends BaseFragment {

    RecyclerView recyclerView;
    LearnItemAdapter learnItemAdapter;

    private OnFragmentInteractionListener mListener;

    public LearnFragment() {
        // Required empty public constructor
    }


    public static LearnFragment newInstance() {
        LearnFragment fragment = new LearnFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        init();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        learnItemAdapter.refreshList();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public void onDataSetFetched(){
        if(learnItemAdapter == null) return;
        learnItemAdapter.setWordBundles(DataManager.sharedInstance().getWordBundles());
    }

    public void onRefreshList(){
        //learnItemAdapter.refreshList();
    }

    private void init() {
        learnItemAdapter = new LearnItemAdapter(getContext());
        recyclerView.setAdapter(learnItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        learnItemAdapter.setWordBundles(DataManager.sharedInstance().getWordBundles());
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

        void onFragmentInteraction(Uri uri);
    }
}
