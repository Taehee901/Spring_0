package com.yedam.dept.serive;

import java.util.List;

/**
 * @Class Name : DeptService.java
 * @Description : Dept Business class
 * @Modification Information
 *
 * @author 김유미
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface DeptService {
	
	/**
	 * DEPT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DeptVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertDept(DeptVO vo) throws Exception;
    
    /**
	 * DEPT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DeptVO
	 * @return void형
	 * @exception Exception
	 */
    void updateDept(DeptVO vo) throws Exception;
    
    /**
	 * DEPT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DeptVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteDept(DeptVO vo) throws Exception;
    
    /**
	 * DEPT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DeptVO
	 * @return 조회한 DEPT
	 * @exception Exception
	 */
    DeptVO selectDept(DeptVO vo) throws Exception;
    
    /**
	 * DEPT 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPT 목록
	 * @exception Exception
	 */
    List selectDeptList(DeptDefaultVO searchVO) throws Exception;
    
    /**
	 * DEPT 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPT 총 갯수
	 * @exception
	 */
    int selectDeptListTotCnt(DeptDefaultVO searchVO);
    
}
