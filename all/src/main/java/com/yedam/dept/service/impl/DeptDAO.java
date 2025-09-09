package com.yedam.dept.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

import com.yedam.dept.serive.DeptDefaultVO;
import com.yedam.dept.serive.DeptVO;

/**
 * @Class Name : DeptDAO.java
 * @Description : Dept DAO Class
 * @Modification Information
 *
 * @author 김유미
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("deptDAO")
public class DeptDAO extends EgovAbstractMapper {

	/**
	 * DEPT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DeptVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertDept(DeptVO vo) throws Exception {
        insert("deptDAO.insertDept", vo);
    }

    /**
	 * DEPT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DeptVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDept(DeptVO vo) throws Exception {
        update("deptDAO.updateDept", vo);
    }

    /**
	 * DEPT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DeptVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDept(DeptVO vo) throws Exception {
        delete("deptDAO.deleteDept", vo);
    }

    /**
	 * DEPT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DeptVO
	 * @return 조회한 DEPT
	 * @exception Exception
	 */
    public DeptVO selectDept(DeptVO vo) throws Exception {
        return (DeptVO) selectOne("deptDAO.selectDept", vo);
    }

    /**
	 * DEPT 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<DeptDefaultVO>
	 * @return DEPT 목록
	 * @exception Exception
	 */
    public List<DeptDefaultVO> selectDeptList(DeptDefaultVO searchVO) throws Exception {
        return selectList("deptDAO.selectDeptList", searchVO);
    }

    /**
	 * DEPT 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEPT 총 갯수
	 * @exception
	 */
    public int selectDeptListTotCnt(DeptDefaultVO searchVO) {
        return (Integer)selectOne("deptDAO.selectDeptListTotCnt", searchVO);
    }

}
