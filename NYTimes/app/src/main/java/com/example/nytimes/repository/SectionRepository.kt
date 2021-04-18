package com.example.nytimes.repository

import android.util.Log
import com.example.nytimes.R
import com.example.nytimes.model.Sections

class SectionRepository {

    var sectionItems = mutableListOf<Sections>()

    fun allSections(): List<Sections> {
        setSections();
        return sectionItems;
    }

    fun setSections() {
        sectionItems.add(Sections(R.drawable.ic_most_popular, "Most Popular"))
        sectionItems.add(Sections(R.drawable.ic_world, "World"))
        sectionItems.add(Sections(R.drawable.ic_us_map, "U.S."))
        sectionItems.add(Sections(R.drawable.ic_politics, "Politics"))
        sectionItems.add(Sections(R.drawable.ic_business, "Business"))
        sectionItems.add(Sections(R.drawable.ic_sports, "Sports"))
        sectionItems.add(Sections(R.drawable.ic_arts, "Arts"))
        sectionItems.add(Sections(R.drawable.ic_open_book1, "Magazine"))
        //sectionItems.add(Sections(R.drawable.ic_video_camera,"Video"))
        sectionItems.add(Sections(R.drawable.ic_reader_center, "Reader Center"))
        sectionItems.add(Sections(R.drawable.ic_photos, "Photos"))
        sectionItems.add(Sections(R.drawable.ic_technology, "Technology"))
        sectionItems.add(Sections(R.drawable.ic_health, "Health"))
        sectionItems.add(Sections(R.drawable.ic_well, "Well"))
        sectionItems.add(Sections(R.drawable.ic_science, "Science"))
        sectionItems.add(Sections(R.drawable.ic_climate, "Climate And Environment"))
        sectionItems.add(Sections(R.drawable.ic_food, "Food"))
        sectionItems.add(Sections(R.drawable.ic_books, "Books"))
        sectionItems.add(Sections(R.drawable.ic_movies, "Movies"))
        sectionItems.add(Sections(R.drawable.ic_theater, "Theater"))
    }
}