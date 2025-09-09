package com.yedam.dept.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;

import com.yedam.dept.serive.DeptDefaultVO;
import com.yedam.dept.serive.DeptService;
import com.yedam.dept.serive.DeptVO;
import com.yedam.dept.service.impl.DeptDAO;
import com.yedam.dept.service.impl.DeptMapper;
/**
 * @Class Name : DeptServiceImpl.java
 * @Description : Dept Business Implement class
 * @Modification Information
 *
 * @author 김유미
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("deptService")
public class DeptServiceImpl extends EgovAbstractServiceImpl implements
        DeptService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(DeptServiceImpl.class);

    @Resource(name="deptMapper")
    private DeptMapper deptDAO;
    
    //@Resource(name="deptDAO")
    //private DeptDAO deptDAO;
    
    /** ID Generation */
    //@Resource(name="{egovDeptIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * DEPT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DeptVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertDept(DeptVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	deptDAO.insertDept(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * DEPT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DeptVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDept(DeptVO vo) throws Exception {
        deptDAO.updateDept(vo);
    }

    /**
	 * DEPT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DeptVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDept(DeptVO vo) throws Exception {
        deptDAO.deleteDept(vo);
    }

    /**
	 * DEPT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DeptVO
	 * @return 조회한 DEPT
	 * @exception Exception
	 */
    public DeptVO selectDept(DeptVO vo) throws Exception {
        DeptVO resultVO = deptDAO.selectDept(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * DEPT 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPT 목록
	 * @exception Exception
	 */
    public List<?> selectDeptList(DeptDefaultVO searchVO) throws Exception {
        return deptDAO.selectDeptList(searchVO);
    }

    /**
	 * DEPT 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPT 총 갯수
	 * @exception
	 */
    public int selectDeptListTotCnt(DeptDefaultVO searchVO) {
		return deptDAO.selectDeptListTotCnt(searchVO);
	}
    
}
