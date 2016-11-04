package ar.edu.utn.d2s.utils;

import java.util.*;

public class StringUtil {

    public static Set<String> getUniqueWordsFromText(String text) {
        String[] wordsArray = text.split(" ");
        return new HashSet<>(Arrays.asList(wordsArray));
    }
}
