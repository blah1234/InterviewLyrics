package com.example.interviewlyrics.parser

import android.util.Xml
import com.example.interviewlyrics.model.P
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TtmlXmlPullParser : TtmlParser {

    companion object {
        private const val TIME_FORMAT = "HH:mm:ss.SSS"
    }


    // We don't use namespaces
    private val ns: String? = null


    override fun parse(inputStream: InputStream): List<P> {
        inputStream.use { stream ->
            val parser: XmlPullParser = Xml.newPullParser()
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(stream, null)
            parser.nextTag()

            return readFeed(parser)
        }
    }

    private fun readFeed(parser: XmlPullParser): List<P> {
        val lines = mutableListOf<P>()

        parser.require(XmlPullParser.START_TAG, ns, "tt")
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }

            // Starts by looking for the entry tag
            if (parser.name == P.NAME) {
                lines.add(readP(parser))
            }
        }

        return lines
    }

    private fun readP(parser: XmlPullParser): P {
        var begin = ""
        var end = ""

        for (i in 0 until parser.attributeCount) {

            when (parser.getAttributeName(i)) {
                P.ATTR_BEGIN -> {
                    begin = parser.getAttributeValue(i)
                }

                P.ATTR_END -> {
                    end = parser.getAttributeValue(i)
                }
            }
        }

        return P(readText(parser), begin, end)
    }

    private fun readText(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.nextTag()
        }
        return result
    }


    override fun convertToTime(timeStr: String): Date {
        val timeFormat = SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).apply {
            isLenient = true
        }

        return timeFormat.parse(timeStr)
    }
}