package org.jupiterhub.masker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CurseWordMasker implements Masker {

    Map<String, String> swearWordsMap = new HashMap<>();

    public CurseWordMasker(String... swearWords) {
        if (swearWords != null) {
            Arrays.stream(swearWords).forEach(s -> swearWordsMap.put(s, "*".repeat(s.length())));
        }
    }

    // do a lookup at startup to initize the words
    // that could be from DB

    @Override
    public String sanitize(String text) {
        AtomicReference<String> hiddenText = new AtomicReference<>(text);
        swearWordsMap.entrySet().stream().forEach(keyValuePair -> {
            hiddenText.set(hiddenText.get().replaceAll(keyValuePair.getKey(), keyValuePair.getValue()));
        });

        return hiddenText.get();
    }
}
