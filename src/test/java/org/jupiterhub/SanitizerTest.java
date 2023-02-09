package org.jupiterhub;

import org.junit.jupiter.api.Test;
import org.jupiterhub.masker.CurseWordMasker;
import org.jupiterhub.masker.EmailMasker;
import org.jupiterhub.masker.PhoneMasker;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SanitizerTest {

    Sanitizer sanitizer = new Sanitizer(List.of(new EmailMasker(), new PhoneMasker(), new CurseWordMasker("crap", "cretin")));

    @Test
    void sanitze() {
        // Given
        String text = "James was a crap builder and generally a cretin. Send him your complaints on james@jollycleverbuilders.com or (07965123456)";

        // When
        String sanitized = sanitizer.sanitize(text);

        // Then
        assertEquals("James was a **** builder and generally a ******. Send him your complaints on <email address> or (<phone number>)", sanitized);
    }
}