package com.yedam.dept.service.impl;

import java.util.List;

import com.yedam.dept.serive.DeptDefaultVO;
import com.yedam.dept.serive.DeptVO;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : DeptMapper.java
 * @Description : Dept Mapper Class
 * @Modification Information
 *
 * @author 김유미
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("deptMapper")
public interface DeptMapper {

	/**
	 * DEPT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DeptVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertDept(DeptVO vo) throws Exception;

    /**
	 * DEPT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DeptVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDept(DeptVO vo) throws Exception;

    /**
	 * DEPT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DeptVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDept(DeptVO vo) throws Exception;

    /**
	 * DEPT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DeptVO
	 * @return 조회한 DEPT
	 * @exception Exception
	 */
    public DeptVO selectDept(DeptVO vo) throws Exception;

    /**
	 * DEPT 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEPT 목록
	 * @exception Exception
	 */
    public List<?> selectDeptList(DeptDefaultVO searchVO) throws Exception;

    /**
	 * DEPT 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEPT 총 갯수
	 * @exception
	 */
    public int selectDeptListTotCnt(DeptDefaultVO searchVO);

}
