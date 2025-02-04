package com.tolany.java.Java_project.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface pageUtil {
  int DEFOULT_PAGE_LIMIT=10;
  int DEFOULT_PAGE_NUMBER=1;
  String PAGE_LIMIT="_limit";
  String PAGE_NUMBER="_page";
  
  static Pageable getPageable(int pageNumber,int pageSize) {
	  if(pageNumber<DEFOULT_PAGE_NUMBER) {
		  pageNumber=DEFOULT_PAGE_NUMBER;
	  }
	  if(pageSize<1) {
		  pageSize=DEFOULT_PAGE_LIMIT;
	  }
	  Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
	  return pageable;
  }
}
