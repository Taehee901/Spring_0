package com.yedam.collect;

import lombok.Builder;
import lombok.Data;

@Builder // 3개생성자 인수
@Data
public class DeptVO {
	private int deptno;
	private String dname;
	private int location;
}
