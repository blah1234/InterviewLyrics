package com.example.interviewlyrics.parser;

import androidx.annotation.Nullable;

public class ParserFactory {

    @Nullable
    static public TtmlParser createParser() {
        return new TtmlXmlPullParser();
    }
}
