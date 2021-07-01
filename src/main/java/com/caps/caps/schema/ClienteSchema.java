package com.caps.caps.schema;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteSchema {

    private Long id;

    @NotNull
    private String name;

    private String document;

}
