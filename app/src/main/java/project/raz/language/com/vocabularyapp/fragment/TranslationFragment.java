package project.ahsan.language.com.vocabularyapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.model.Translation;

public class TranslationFragment extends BaseFragment {

    Translation translation;

    TextView titleTextView;
    TextView translationTextView;

    public TranslationFragment() {
    }

    public static TranslationFragment newInstance(Translation translation){
        TranslationFragment fragment = new TranslationFragment();
        fragment.translation = translation;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_translation, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        titleTextView = view.findViewById(R.id.tran_title_text_view);
        translationTextView = view.findViewById(R.id.trans_text_view);
        titleTextView.setText("Meaning in " + translation.getLanguage());
        translationTextView.setText(translation.getTranslation());
    }


}
