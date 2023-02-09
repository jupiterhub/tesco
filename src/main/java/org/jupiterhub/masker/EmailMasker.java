package org.jupiterhub.masker;

import org.jupiterhub.SanitizerException;

public class EmailMasker implements Masker{
    private static final String EMAIL_REGEX = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)";
    public static final String MASK_FOR_EMAIL = "<email address>";

    @Override
    public String sanitize(String text) {
        if (text == null) {
            throw new SanitizerException("Text is required");
        }
        return text.replaceAll(EMAIL_REGEX, MASK_FOR_EMAIL);
    }
}
