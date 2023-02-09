package org.jupiterhub.masker;

import org.junit.jupiter.api.Test;
import org.jupiterhub.masker.PhoneMasker;

import static org.junit.jupiter.api.Assertions.*;

class PhoneMaskerTest {

    PhoneMasker sanitizer = new PhoneMasker();


    @Test
    void maskPhone() {
        // Given
        String text = "(07965123456)";

        // When
        String sanitized = sanitizer.sanitize(text);

        // Then
        assertEquals("(<phone number>)", sanitized);
    }

    @Test
    void shouldOnlyReplacePhoneIf11Chars() {
        // Given
        String text = "(0796512345)";

        // When
        String sanitized = sanitizer.sanitize(text);

        // Then
        assertEquals("(0796512345)", sanitized);
    }
}