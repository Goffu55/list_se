package com.umanizales.list_se.model;


import lombok.Data;

@Data

public class Node {
    private Boy data;
    private Node next;

    public Node(Boy data) {
        this.data = data;
    }
}
