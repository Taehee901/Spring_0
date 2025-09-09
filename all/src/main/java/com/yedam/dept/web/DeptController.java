package com.yedam.dept.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import com.yedam.dept.serive.DeptDefaultVO;
import com.yedam.dept.serive.DeptService;
import com.yedam.dept.serive.DeptVO;

/**
 * @Class Name : DeptController.java
 * @Description : Dept Controller class
 * @Modification Information
 *
 * @author 김유미
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=DeptVO.class)
public class DeptController {

    @Resource(name = "deptService")
    private DeptService deptService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * DEPT 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 DeptDefaultVO
	 * @return "/dept/DeptList"
	 * @exception Exception
	 */
    @RequestMapping(value="/dept/DeptList.do")
    public String selectDeptList(@ModelAttribute("searchVO") DeptDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> deptList = deptService.selectDeptList(searchVO);
        model.addAttribute("resultList", deptList);
        
        int totCnt = deptService.selectDeptListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/dept/DeptList";
    } 
    
    @RequestMapping("/dept/addDeptView.do")
    public String addDeptView(
            @ModelAttribute("searchVO") DeptDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("deptVO", new DeptVO());
        return "/dept/DeptRegister";
    }
    
    @RequestMapping("/dept/addDept.do")
    public String addDept(
            DeptVO deptVO,
            @ModelAttribute("searchVO") DeptDefaultVO searchVO, SessionStatus status)
            throws Exception {
        deptService.insertDept(deptVO);
        status.setComplete();
        return "forward:/dept/DeptList.do";
    }
    
    @RequestMapping("/dept/updateDeptView.do")
    public String updateDeptView(
            @RequestParam("id") java.math.BigDecimal id ,
            @ModelAttribute("searchVO") DeptDefaultVO searchVO, Model model)
            throws Exception {
        DeptVO deptVO = new DeptVO();
        deptVO.setId(id);
        // 변수명은 CoC 에 따라 deptVO
        model.addAttribute(selectDept(deptVO, searchVO));
        return "/dept/DeptRegister";
    }

    @RequestMapping("/dept/selectDept.do")
    public @ModelAttribute("deptVO")
    DeptVO selectDept(
            DeptVO deptVO,
            @ModelAttribute("searchVO") DeptDefaultVO searchVO) throws Exception {
        return deptService.selectDept(deptVO);
    }

    @RequestMapping("/dept/updateDept.do")
    public String updateDept(
            DeptVO deptVO,
            @ModelAttribute("searchVO") DeptDefaultVO searchVO, SessionStatus status)
            throws Exception {
        deptService.updateDept(deptVO);
        status.setComplete();
        return "forward:/dept/DeptList.do";
    }
    
    @RequestMapping("/dept/deleteDept.do")
    public String deleteDept(
            DeptVO deptVO,
            @ModelAttribute("searchVO") DeptDefaultVO searchVO, SessionStatus status)
            throws Exception {
        deptService.deleteDept(deptVO);
        status.setComplete();
        return "forward:/dept/DeptList.do";
    }

}
