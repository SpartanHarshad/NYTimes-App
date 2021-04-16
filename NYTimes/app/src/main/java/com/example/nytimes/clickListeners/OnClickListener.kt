package com.example.nytimes.clickListeners

import com.example.nytimes.model.Sections

interface OnClickListener {
    fun getSectionName(sections: Sections)
}