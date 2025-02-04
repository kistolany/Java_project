package com.tolany.java.Java_project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageationDTO {
	private int pageSize;
	private int pageNumber;
	private int totalPages;
	private long TotalElements;
	private long numberOfElements;
	private boolean first;
	private boolean last;
	private boolean empty;
}
