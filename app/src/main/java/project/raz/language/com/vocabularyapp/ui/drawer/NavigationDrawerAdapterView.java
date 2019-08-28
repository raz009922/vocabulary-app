package project.ahsan.language.com.vocabularyapp.ui.drawer;

import android.content.Context;
import android.content.res.Resources;
;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import project.ahsan.language.com.vocabularyapp.R;


/**
 * Created by developerios on 7/8/18.
 */

public class NavigationDrawerAdapterView extends RecyclerView.Adapter<NavigationDrawerAdapterView.Holder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<DrawerItem> drawerItems;
    NavigationAdapterCallbacks navigationAdapterCallbacks;

    public NavigationDrawerAdapterView(Context context, ArrayList<DrawerItem> drawerItems) {
        this.context = context;
        this.drawerItems = drawerItems;
        inflater = LayoutInflater.from(context);
    }

    public void setDataSet(ArrayList<DrawerItem> drawerItems){
        this.drawerItems = drawerItems;
        notifyDataSetChanged();
    }

    public void setNavigationAdapterCallbacks(NavigationAdapterCallbacks navigationAdapterCallbacks) {
        this.navigationAdapterCallbacks = navigationAdapterCallbacks;
    }

    @NonNull
    @Override
    public NavigationDrawerAdapterView.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_navigation_drawer, parent, false);
        Holder holder = new Holder(view, new WeakReference<NavigationDrawerAdapterView>(this));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NavigationDrawerAdapterView.Holder holder, int position) {
        DrawerItem drawerItem = drawerItems.get(position);
        if(density()<3){
//            holder.itemTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        }
        if (drawerItem.itemId == -1) {
            holder.itemImageView.setVisibility(View.INVISIBLE);
            holder.itemTextView.setVisibility(View.INVISIBLE);
//            holder.dividerLayout.setVisibility(View.VISIBLE);
            holder.itemBackground.setBackgroundColor(context.getResources().getColor(R.color.colorNavBackground));
        } else {
            holder.itemImageView.setVisibility(View.VISIBLE);
            holder.itemTextView.setVisibility(View.VISIBLE);
//            holder.dividerLayout.setVisibility(View.INVISIBLE);
            holder.itemTextView.setText(drawerItem.titleText);
            holder.itemImageView.setImageResource(drawerItem.imageId);
            //Glide.with(context).load(drawerItem.imageId).into(holder.itemImageView);
            holder.itemBackground.setBackground(context.getResources().getDrawable(R.drawable.selector_navbar_item));
        }
    }

    @Override
    public int getItemCount() {
        return drawerItems.size();
    }

    public static float density() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView itemImageView;
        TextView itemTextView;
        RelativeLayout dividerLayout;
        RelativeLayout itemBackground;
        WeakReference<NavigationDrawerAdapterView> adapterWeakReference;

        public Holder(View itemView, WeakReference<NavigationDrawerAdapterView> navigationAdapterCallbacksWeakReference) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.image_navigation_item);
            itemTextView = itemView.findViewById(R.id.text_navigation_item);
            dividerLayout = itemView.findViewById(R.id.layout_divider);
            itemBackground = itemView.findViewById(R.id.layout_navigation_item_background);
            adapterWeakReference = navigationAdapterCallbacksWeakReference;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (adapterWeakReference.get() != null) {
                        adapterWeakReference.get().navigationAdapterCallbacks.navigationItemClicked(position);
                    }
                }
            });

        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            adapterWeakReference.get().navigationAdapterCallbacks.navigationItemClicked(position);
        }
    }

    public interface NavigationAdapterCallbacks {
        void navigationItemClicked(int position);
    }
}
