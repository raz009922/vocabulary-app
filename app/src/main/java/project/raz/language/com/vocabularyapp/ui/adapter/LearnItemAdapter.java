package project.ahsan.language.com.vocabularyapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import project.ahsan.language.com.vocabularyapp.R;
import project.ahsan.language.com.vocabularyapp.activity.LearnActivity;
import project.ahsan.language.com.vocabularyapp.activity.MainActivity;
import project.ahsan.language.com.vocabularyapp.manager.DataManager;
import project.ahsan.language.com.vocabularyapp.model.WordBundle;

public class LearnItemAdapter extends RecyclerView.Adapter<LearnItemAdapter.Holder> {

    ArrayList<WordBundle> wordBundles = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public LearnItemAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setWordBundles(ArrayList<WordBundle>wordBundles){
        this.wordBundles = wordBundles;
        Log.d("TAG", "setWordBundles: " + wordBundles.size());
        notifyDataSetChanged();
    }

    public void refreshList(){
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_word_bundle, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        String title = wordBundles.get(position).getTitle();
        holder.titleTextView.setText(title);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataManager.sharedInstance().setSelectedBundle(position);
                context.startActivity(new Intent(context,LearnActivity.class));
            }
        });
        holder.progressBar.setMax(wordBundles.get(position).getWordArrayList().size());
        holder.progressBar.setProgress(wordBundles.get(position).getRevisionList().size());
    }


    @Override
    public int getItemCount() {
        return wordBundles.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView secondaryTextView;
        TextView descriptionTextView;
        TextView symbolTextView;
        ProgressBar progressBar;
        TextView progressTextView;
        View view;

        public Holder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            titleTextView = itemView.findViewById(R.id.text_title);
            secondaryTextView = itemView.findViewById(R.id.text_secondary);
            descriptionTextView = itemView.findViewById(R.id.text_details);
            symbolTextView = itemView.findViewById(R.id.text_symbol);
            progressBar = itemView.findViewById(R.id.progress_bundle);
            progressTextView = itemView.findViewById(R.id.progress_text);
//            init();
        }

//        private void init(){
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    context.startActivity(new Intent(context,LearnActivity.class));
//                }
//            });
//        }


    }

}
