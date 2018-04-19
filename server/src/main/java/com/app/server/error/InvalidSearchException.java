package com.app.server.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * {@code InvalidSearchException} is a runtime exception if invalid search
 * criteria is entered.
 * <p/>
 *
 * @author Indra Basak
 * @since 9/22/17
 */
@NoArgsConstructor
@ToString(callSuper = true)
@Getter
@Setter
public class InvalidSearchException extends RuntimeException {
    public InvalidSearchException(String s) {
        super(s);
    }
}
