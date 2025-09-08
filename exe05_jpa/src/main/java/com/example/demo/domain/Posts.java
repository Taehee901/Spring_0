package com.example.demo.domain;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;

//값 초기화하려면 생성자를 씀
//@setter -> Posts에 필드값을 변경하면 DB에 반영
@Getter
@Entity
public class Posts extends BaseTimeEntity {

//	@CreatedDate // 등록시 날짜 자동저장
	@Id //자카르 사용
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="post_title",length = 100,nullable = false)
	private String title;
	private String content;
//	@Transient //
	private String author;
	
//	@LastModifiedDate // 수정시
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date wdate;
	
	//단건조회
	public Posts() {};
	@Builder
	public Posts(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
//		this.wdate = wdate;
	}
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
