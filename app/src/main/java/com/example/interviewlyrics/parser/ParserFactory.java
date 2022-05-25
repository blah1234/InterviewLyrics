package com.example.interviewlyrics.parser;

public class ParserFactory {

    static public TtmlParser createParser() {
        return new TtmlXmlPullParser();
    }
}
