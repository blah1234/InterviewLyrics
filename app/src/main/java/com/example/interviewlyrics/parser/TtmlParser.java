package com.example.interviewlyrics.parser;

import androidx.annotation.NonNull;

import com.example.interviewlyrics.model.P;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public interface TtmlParser {
    /**
     * @param inputStream input stream to the TTML file to parse
     * @return a list of {@link P} XML model objects parsed from the TTML file
     */
    List<P> parse(@NonNull InputStream inputStream);

    /**
     * @param timeStr a string in the form of `HH:mm:ss.SSS`
     * @return a {@link Date} representing that time. The input string will contain ONLY a time, so
     * an undefined date portion in the returned {@link Date} object is acceptable
     */
    Date convertToTime(@NonNull String timeStr);
}
