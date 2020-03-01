package com.java.meet.c12_24_cas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class C_24_Person {

    private Integer id;
    private String personName;

    public C_24_Person(Integer id, String personName) {
        this.id = id;
        this.personName = personName;
    }
}
