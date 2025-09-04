package com.yedam.collect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
//@Getter
//@Setter
//@ToString
@AllArgsConstructor //모든 필드 생성자를 다 만들어줌 
@NoArgsConstructor
//@RequiredArgsConstructor
public class EmpVO {
	//필드 선언,final 생성자에 값이 있으면 변경못함
//	final private int empno;
//	final private String ename;
    private int empno;
    private String ename;
	private int dept;
}











//@Data
////@Getter
////@Setter
////@ToString
////@AllArgsConstructor //모든 필드 생성자를 다 만들어줌 
////@NoArgsConstructor
////@RequiredArgsConstructor
//public class EmpVO {
//	//필드 선언,final 생성자에 값이 있으면 변경못함
////	final private int empno;
////	final private String ename;
//	final private int empno;
//	final private String ename;
//	private int dept;
//}
