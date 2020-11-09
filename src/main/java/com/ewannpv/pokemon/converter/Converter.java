package com.ewannpv.pokemon.converter;

import org.springframework.lang.NonNull;

import java.util.Objects;

public interface Converter<FROM_T, TO_T> {

    TO_T convert(final @NonNull FROM_T from);

    default TO_T convertOrNull(final FROM_T from) {
        if (Objects.isNull(from)) {
            return null;
        }
        return convert(from);
    }
}
