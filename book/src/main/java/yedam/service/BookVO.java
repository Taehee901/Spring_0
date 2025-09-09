package yedam.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
@Getter
@Data
public class BookVO {
	private Long bookNo;
	private String bookName;
	private String bookCoverimg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookDate;
	private Long bookPrice;
	private String bookPublisher;
	private String bookInfo;
	private Long rentPrice;
	private Long rentStatus;
}
