package project.ahsan.language.com.vocabularyapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.model.WordBundle;

public class TestItemAdapter extends RecyclerView.Adapter<TestItemAdapter.Holder> {

    ArrayList<WordBundle> wordBundles = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public TestItemAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_test_bundle, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
