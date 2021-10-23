package com.umanizales.list_se.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Boy {
    private String identification;
    private String name;
    private byte age;
    private String gender;
}
