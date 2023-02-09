package org.jupiterhub.masker;

import org.junit.jupiter.api.Test;
import org.jupiterhub.SanitizerException;
import org.jupiterhub.masker.EmailMasker;

import static org.junit.jupiter.api.Assertions.*;

class EmailMaskerTest {
    
    EmailMasker sanitizer = new EmailMasker();

    @Test
    void maskEmail() {
        // Given
        String text = "Mail me at james@jollycleverbuilders.com";

        // When
        String sanitized = sanitizer.sanitize(text);

        // Then
        assertEquals("Mail me at <email address>", sanitized);
    }

    @Test
    void returnSanitizerExceptionIfNull() {
        // Given
        SanitizerException exception = assertThrows(SanitizerException.class, () -> {
            // When
            sanitizer.sanitize(null);
            fail();
        });

        // Then
        assertNotNull(exception);
    }

}