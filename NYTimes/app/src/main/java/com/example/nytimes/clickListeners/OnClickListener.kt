package com.example.nytimes.clickListeners

import com.example.nytimes.model.Sections

interface SectionOnClickListener {
    fun getSectionName(sections: Sections)
}