package com.yedam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileTest {

	@Test
	public void list() {
		File file = new File("C:\\temp");
		String[] list =  file.list();
		for(int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}
	}
	//파일복사 input스트림 ,아웃스트림
	//@Test
	public void delete() {
		File file = new File("C:/temp/copy3.PNG");
//		file.delete();
		file.renameTo(new File("C:/temp/복사.PNG"));
	}
	@Test
	public void copy() throws Exception {
		FileInputStream fi = new FileInputStream(new File("C:/temp","복사.PNG"));//부모폴더,자식파일
		FileOutputStream fo = new FileOutputStream(new File ("C:/temp","복사텍스트.PNG"));
		int temp;
		while((temp = fi.read()) != -1) {
			fo.write(temp);
		}
		fi.close();
		fo.close();
	}
}
