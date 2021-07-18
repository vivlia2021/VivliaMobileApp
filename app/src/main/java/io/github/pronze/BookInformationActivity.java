package io.github.pronze;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import io.github.pronze.databinding.ActivityBookInformationBinding;
import io.github.pronze.ui.home.recycler.BookItem;

public class BookInformationActivity extends AppCompatActivity {

    private ActivityBookInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BookItem item = (BookItem) getIntent().getSerializableExtra("information");
        Picasso.get().load(item.getImageUrl()).fit().into(binding.bookImage);
        binding.bookTitle.setText(item.getTitle());
        binding.description.setText(item.getFullDescription());
        binding.backButton.setOnClickListener(view -> finish());
        binding.quizButton.setOnClickListener(view -> startActivity(new Intent(BookInformationActivity.this, QuizActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT)));
    }
}
