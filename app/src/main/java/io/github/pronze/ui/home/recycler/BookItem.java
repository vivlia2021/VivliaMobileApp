package io.github.pronze.ui.home.recycler;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BookItem implements Serializable {
    private final String title;
    private final String imageUrl;
    private final String description;
    private final String fullDescription;
}
