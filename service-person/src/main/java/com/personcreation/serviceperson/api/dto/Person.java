package com.personcreation.serviceperson.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Person {
    private String username;
    private long level;
    private long gold;
    private long platinum;
}
