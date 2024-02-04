package org.pyeonhaeng.api.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class EventResponse<T> {
    private final int count;
    private final String message;
    private final List<T> products;

}
