package org.jupiterhub;

import org.jupiterhub.masker.Masker;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Sanitizer {

    List<Masker> maskers;

    public Sanitizer(List<Masker> maskers) {
        this.maskers = maskers;
    }

    public String sanitize(String text) {
        AtomicReference<String> sanitized = new AtomicReference<>(text);
        maskers.stream()
                .forEach(masker -> sanitized
                .set(masker.sanitize(sanitized.get())));

        return sanitized.get();
    }
}
