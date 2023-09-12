package com.s2w.preassignment.attackmanager.presentation.api;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class Pagination<T> {
    private final List<T> content;
    private final long totalElements;
    private final long numberOfElements;
    private final int currentPage;
    private final int totalPages;
    private final int size;
    private final boolean first;
    private final boolean last;

    private Pagination(List<T> content, long totalElements, long numberOfElements, int currentPage, int totalPages, int size, boolean first, boolean last) {
        this.content = content;
        this.totalElements = totalElements;
        this.numberOfElements = numberOfElements;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.size = size;
        this.first = first;
        this.last = last;
    }

    public static <T> Pagination of(List<T> content, Page page) {
        return new Pagination<T>(content, page.getTotalElements(),
                page.getNumberOfElements(),
                page.getNumber(),
                page.getTotalPages(),
                page.getSize(),
                page.isFirst(),
                page.isLast());
    }
}
