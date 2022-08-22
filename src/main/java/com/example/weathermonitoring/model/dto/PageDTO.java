package com.example.weathermonitoring.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PageDTO<T> {

    Long total;
    Integer pageNumber;
    Integer totalPages;
    List<T> content;

    public PageDTO() {
        this.total = 0L;
        this.pageNumber = 0;
        this.totalPages = 0;
        this.content = new ArrayList<>();
    }

    public static <T> PageDTO<T> empty() {
        return new PageDTO<>();
    }
}
