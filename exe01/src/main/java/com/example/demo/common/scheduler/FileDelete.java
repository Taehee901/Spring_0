package com.example.demo.common.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FileDelete {
	//반복실행 : 시간(cron: 매주, 초 분 시 일 월 주),cron = "0 0 1-10/2" 
	@Scheduled(fixedDelay = 2000)//fixedDelay = 2000 : 1000 -> 1s
	public void delete() {
		System.out.println("파일삭제");
	}
}	
