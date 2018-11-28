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
    @Size(min = 3, max = 30)
    private String description;

    public Animal(){}


}
