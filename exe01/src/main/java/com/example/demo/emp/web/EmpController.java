package com.example.demo.emp.web;

import java.io.InputStream;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.Paging;
import com.example.demo.emp.service.EmpService;
import com.example.demo.emp.service.EmpVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

//emp에서 들어오는 요청은 admin
@RequestMapping("/emp")
@Controller // 라우터 바인딩
public class EmpController {
	//@Autowired EmpMapper empMapper; //new x, 객체(빈)가 주입됨
	@Autowired EmpService empService;//서비스구현메소드는 마음대로교체가능
	
	@GetMapping("/empList")//empList?page=2
	public String empList(Model model, EmpVO empVO, Paging paging) {
		//페이징관련
		paging.setPageUnit(5);//페이징건수
		paging.setTotalRecord(empService.selectCount(empVO));
		empVO.setFirst(paging.getFirst());
		empVO.setLast(paging.getLast());
		model.addAttribute("empList",empService.selectEmp(empVO));
		return "emp/empList"; //empList.html
	}
	@GetMapping("/emp") //localhost/emp?employeeId=100
	public String emp(Model model,@RequestParam Long employeeId) {//원시데이터 하나니까..
		model.addAttribute("emp",empService.selectEmpById(employeeId));
		return "emp"; //emp.html
	}
	//리포트 핸들러
	//1.커넥션 읽어서 넘겨주는 방식
//	@Autowired 
//	DataSource datasource;
//	@RequestMapping("report")
//	 public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
//	 Connection conn = datasource.getConnection();
//	 InputStream jasperStream = getClass().getResourceAsStream("/reports/emp.jrxml");
//	 JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
//	      //파라미터 맵
//	      HashMap<String,Object> map = new HashMap<>();
//	      map.put("P_EMPNAME", "Hong gildong");//request.getParameter("dept")
//	      response.setContentType("application/pdf");
//	 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
//	 JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//	 }
	@Autowired
	DataSource dataspirce;
	
	@GetMapping("report2")
	public ModelAndView report2() {
		// view 지정
		// view 지정
		JasperPdfView view = new JasperPdfView("reports/emp.jrxml");
		view.setContentType("application/octet-stream");
		//view.setContentType("application/pdf");
		ModelAndView mv = new ModelAndView(view);
//		ModelAndView mv = new ModelAndView(new JasperPdfView("reports/emp.jrxml"));
		// 파라미터
		mv.addObject("P_EMPNAME", "hong gildong");
		
		// 데이터 조회
		EmpVO vo = new EmpVO();
		vo.setFirst(1);
		vo.setLast(10);
		mv.addObject("datas", empService.selectEmp(vo));
		
		return mv;
	}
	

	@Autowired 
	DataSource datasource;
	   @RequestMapping("report")
	    public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
//	        Connection conn = datasource.getConnection();
	        // 소스 컴파일 jrxml -> jasper
	        InputStream stream = getClass().getResourceAsStream("/reports/emp.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(stream);
	        //파라미터 맵
	        HashMap<String,Object> map = new HashMap<>();
		      map.put("P_EMPNAME", "Hong gildong");
		      
		    //데이터조회
		    EmpVO vo = new EmpVO();
		    vo.setFirst(1);
		    vo.setLast(5);
		    JRDataSource jRdataSource = new JRBeanCollectionDataSource(empService.selectEmp(vo));
		    response.setContentType("application/pdf");
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, jRdataSource);//list VO전달가능
	        JasperExportManager.exportReportToPdfStream( jasperPrint, response.getOutputStream());
	    }
}
