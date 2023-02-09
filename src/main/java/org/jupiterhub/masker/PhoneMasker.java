package org.jupiterhub.masker;

public class PhoneMasker implements  Masker{
    private static final String PHONE_REGEX = "\\d{11}";
    public static final String MASK_FOR_PHONE = "<phone number>";
    @Override
    public String sanitize(String text) {
        return text.replaceAll(PHONE_REGEX, MASK_FOR_PHONE);
    }
}
