package com.rashcomps.rashcomputers.dtos;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  Id template dto
 */

public class IdTemplate {
    private Long id;

    public IdTemplate(Long id) {
        this.id = id;
    }

    public IdTemplate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdTemplate{" +
                "id=" + id +
                '}';
    }
}
