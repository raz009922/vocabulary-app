package project.ahsan.language.com.vocabularyapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.model.Defination;

public class DefinationFragment extends BaseFragment {


    Defination defination;

    TextView posTextView;
    TextView meaningTextView;
    TextView exampleTextView;


    public static DefinationFragment newInstance(Defination defination){
        DefinationFragment fragment = new DefinationFragment();
        fragment.defination = defination;
        return fragment;
    }

    public DefinationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_defination, container, false);
        initTexts(view);
        return view;
    }

    private void initTexts(View view) {
        posTextView = view.findViewById(R.id.pos_text_view);
        meaningTextView = view.findViewById(R.id.meaning_text_view);
        exampleTextView = view.findViewById(R.id.example_text_view);
        posTextView.setText(defination.getPartOfSpeech());
        meaningTextView.setText(defination.getMeaning());
        exampleTextView.setText(defination.getExample());
    }
}
