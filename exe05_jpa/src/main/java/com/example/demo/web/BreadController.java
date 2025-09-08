//package com.example.demo.web;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.domain.Bread;
//import com.example.demo.dto.breadDTO;
//import com.example.demo.repository.BreadRepository;
//import com.example.demo.service.BreadService;
//import com.example.demo.service.PostsService;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//
////dto 분리,vo,breadDTO ->서비스,dto로넘겨서 entity로,조회할때는 entity dto
//@RequiredArgsConstructor
//@Controller
//public class BreadController {
//	private final BreadService breadService;
//	//전체조회
//	@GetMapping("allList")
//	public List<breadDTO> allList(){
//		return breadService.allList();
//	}
////	//단건조회
////	@GetMapping("detailList")
////	public String detailList(@RequestParam("id") Long id,Model model){
////		// Optional에서 바로 get() 사용
////		//orElse(null)를 사용하여 안전하게 값을 가져온다.,findByid는 옵션객체를 반환하는데 해당id가 DB에 없을 수 있어,get사용시 값이 없으면 NoSuchElementException 발생
////		Bread bread = breadService.findById(id).orElse(null);
////		model.addAttribute("bread",bread);
//////		detailList.html에서 ${bread.name} 같은 방식으로 데이터 접근이 가능
////		return "detailList";
////	}
////	//수정 & 등록
////	// HTML 폼(form)은 GET,POST만 지원
////	@PostMapping("saveBread")
////	//Thymeleaf 기준
////	public String saveBread(@ModelAttribute Bread bread) {
////		//DB에 id가 있을경우 수정, 없을 경우 등록
////		breadService.save(bread);
////		return "redirect:/allList";
////	}
//	//삭제: 특정 id  @PathVariable -> 
//	@DeleteMapping("deleteBread/{id}")
//	public String deleteBread(@PathVariable("id") Long id) {
//		breadService.delete(id);
//		return "redirect:/allList";
//	}
//
//}
