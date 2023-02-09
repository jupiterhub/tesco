package org.jupiterhub.masker;

import org.junit.jupiter.api.Test;
import org.jupiterhub.masker.CurseWordMasker;

import static org.junit.jupiter.api.Assertions.*;

class CurseWordMaskerTest {


    CurseWordMasker sanitizer = new CurseWordMasker("crap", "cretin");

    @Test
    void maskSwearWords() {
        // Given
        String text = "James was a crap builder and generally a cretin.";

        // When
        String sanitized = sanitizer.sanitize(text);

        // Then
        assertEquals("James was a **** builder and generally a ******.", sanitized);
    }

}