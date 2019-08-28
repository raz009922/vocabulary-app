package project.ahsan.language.com.vocabularyapp.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import project.ahsan.language.com.vocabularyapp.R;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.Holder> {

    ArrayList<String> titleList = new ArrayList<>();
    Context context;
    LayoutInflater inflater;
    TabAdapterCallbacks tabAdapterCallbacks;

    private int selectedPosition = 0;

    public TabAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setTitleList(ArrayList<String> titleList) {
        this.titleList = titleList;
        notifyDataSetChanged();
    }

    public void setTabAdapterCallbacks(TabAdapterCallbacks tabAdapterCallbacks) {
        this.tabAdapterCallbacks = tabAdapterCallbacks;
    }

    public void setSelectedPosition(int index){
        this.selectedPosition = index;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_tab, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        if(position == selectedPosition){
               holder.layout.setBackground(context.getResources().getDrawable(R.drawable.bg_tab_background_selected));
        }
        else{
            holder.layout.setBackground(context.getResources().getDrawable(R.drawable.bg_tab_background));
        }
        holder.textView.setText(titleList.get(position));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tabAdapterCallbacks != null){
                    tabAdapterCallbacks.onClickOnTab(view, position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return titleList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        RelativeLayout layout;
        TextView textView;
        View view;

        public Holder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            layout = itemView.findViewById(R.id.layout);
            textView = itemView.findViewById(R.id.title);
        }
    }

    public interface TabAdapterCallbacks{
        void onClickOnTab(View view, int position);
    }
}
