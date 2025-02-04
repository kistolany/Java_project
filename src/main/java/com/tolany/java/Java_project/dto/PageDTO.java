package com.tolany.java.Java_project.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;
@Data
public class PageDTO {
    private List<?> list;
    private PageationDTO pagition;
    
    public  PageDTO(Page<?> page) {
    	this.list = page.getContent();
    	this.pagition=PageationDTO.builder()
    			 .empty(page.isEmpty())
    			 .first(page.isFirst())
    			 .last(page.isLast())
    			 .pageSize(page.getPageable().getPageSize())
    			 .pageNumber(page.getPageable().getPageNumber()+1)
    			 .totalPages(page.getTotalPages())
    			 .TotalElements(page.getTotalElements())
    			 .numberOfElements(page.getNumberOfElements())
    			 .build();
    }
}
