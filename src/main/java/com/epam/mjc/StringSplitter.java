package com.epam.mjc;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */


    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String delimit : delimiters) {
            stringBuilder.append(delimit).append(",");
        }
        System.out.println(stringBuilder.toString());
        StringTokenizer st = new StringTokenizer(source, stringBuilder.toString());
        List<String> list = new ArrayList<>();
        while (st.hasMoreElements()) {
            list.add(st.nextToken());
        }
        return list;

    }
}
