package com.mycompany.app.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Todo implements Serializable {

    private static final long serialVersionUID = 4663044935291053899L;

    private Long id;
    private String message;
    private Status status;
}
