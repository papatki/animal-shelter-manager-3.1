package com.patpaw.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Document(collection = "animals")
@Data
@EqualsAndHashCode(of = "id")
public class Animal {

    @Id
    private String id;

    @Size(min = 3, max = 30)
    private String name;

    @NotBlank
    private String type;

    @NotBlank

    private String description;

    public Animal(){}

    public Animal(@Size(min = 3, max = 30) String name, @NotBlank String type, @NotBlank String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }
}
