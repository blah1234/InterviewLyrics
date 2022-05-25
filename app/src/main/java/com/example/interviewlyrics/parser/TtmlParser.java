package com.example.interviewlyrics.parser;

import com.example.interviewlyrics.model.P;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public interface TtmlParser {
    /**
     * @param inputStream input stream to the TTML file to parse
     * @return a list of {@link P} XML model objects parsed from the TTML file
     */
    List<P> parse(InputStream inputStream);

    /**
     * @param timeStr a string in the form of `HH:mm:ss.SSS`
     * @return a {@link Date} representing that time
     */
    Date convertToTime(String timeStr);
}
