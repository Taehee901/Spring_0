package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Bread;
import com.example.demo.dto.breadDTO;
import com.example.demo.repository.BreadRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BreadService {
	final BreadRepository breadRepository;
 //전체조회
	public List<breadDTO> allList(){
	       // 1. map을 사용하여 각 이름을 대문자로 변환
        List<breadDTO> list = breadRepository.findAll().stream()
                                           .map(br->new breadDTO(br)) // 각 요소를 대문자로 변환
                                           .collect(Collectors.toList()); // 대문자로 변환된 요소들을 List로 수집
		return list;
	}
	//등록
	@Transactional
	public Long save(breadDTO breadDto) {
		return breadRepository.save(breadDto.toEntity()).getId();
	}
	//수정
	@Transactional
	public Long update(Long id,breadDTO breadDto) {
		Bread bread = breadRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
		
		bread.update(breadDto.getBreadName(),breadDto.getBreadContent(),breadDto.getSalary());
        return id;
	}
	//삭제
	@Transactional
	public void delete(Long id) {
		//id 엔티티를 찾은 후 객체로 가져온다.
		Bread bread = breadRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("해당 아이디가 없습니다. id=" + id));
		breadRepository.delete(bread);
	}
}
