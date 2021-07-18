package io.github.pronze;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import io.github.pronze.ui.home.recycler.BookItem;

public class Application extends android.app.Application {
    private static Application instance;

    public static Application getInstance() {
        if (instance == null) {
            throw new UnsupportedOperationException("App has not been initialized yet!");
        }
        return instance;
    }

    public static void showToast(String message) {
        showToast(message, Toast.LENGTH_SHORT);
    }

    public static void showToast(String message, int length) {
        if (instance == null) {
            throw new UnsupportedOperationException("App has not been initialized yet!");
        }
        Toast.makeText(instance, message, length).show();
    }

    public static void openBookInformationScreen(Activity activity, ImageView image,  @NotNull BookItem item) {
        if (instance == null) {
            throw new UnsupportedOperationException("App has not been initialized yet!");
        }
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(activity, image, "book_image");

        activity.startActivity(new Intent(activity, BookInformationActivity.class).putExtra("information", item)
                .setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK), options.toBundle());
    }

    public Application() {
        instance = this;
    }
}
