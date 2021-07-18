package io.github.pronze.ui.home.recycler;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import io.github.pronze.Application;
import io.github.pronze.R;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContinueReadingRecyclerAdapter extends RecyclerView.Adapter<ContinueReadingRecyclerAdapter.ViewHolder> {
    private final List<BookItem> books = new ArrayList<>();
    private final WeakReference<Activity> activityWeakReference;

    public void addItem(@NotNull BookItem item) {
        books.add(item);
        notifyItemInserted(books.size() - 1);
    }

    @NonNull
    @NotNull
    @Override
    public ContinueReadingRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_continue_reading_single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ContinueReadingRecyclerAdapter.ViewHolder holder, int position) {
        BookItem item = books.get(position);
        holder.image.setOnClickListener(view -> Application.openBookInformationScreen(activityWeakReference.get(), holder.image, item));
        holder.itemView.setOnClickListener(view -> Application.openBookInformationScreen(activityWeakReference.get(), holder.image, item));
        holder.title.setOnClickListener(view -> Application.openBookInformationScreen(activityWeakReference.get(), holder.image, item));
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        Picasso.get().load(item.getImageUrl()).fit().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView image;
        private final TextView description;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }
    }
}
