package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.domain.Bread;
import com.example.demo.domain.Customer;
import com.example.demo.repository.BreadRepository;
import com.example.demo.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableJpaAuditing
@SpringBootApplication
public class Exe05JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Exe05JpaApplication.class, args);
	}
	//private	static	final	Logger	log	=	LoggerFactory.getLogger(BjpaH2Application.class);
	 //테이블만들고 데이터 넣으려고 최초로 한번만 실행하면 됨
//	//@Bean
//	 public	CommandLineRunner	demo(CustomerRepository	repository)	{
//		 //람다 식 =>함수역할
//	 return	(args)	->	{
//	 //	save	a	few	customers
//	 repository.save (new Customer("Jack",	"010"));
//	 repository.save(new Customer("Chloe",	"111"));
//	 repository.save(new Customer("Kim",	"222"));
//	 repository.save(new Customer("David",	"333"));
//	 repository.save(new Customer("Michelle",	"444"));
//	 //	fetch	all	customers
//	 log.info("Customers	found	with	findAll():");
//	 log.info("-------------------------------");
//	 for	(Customer	customer	:	repository.findAll())	{
//	 log.info(customer.toString());
//	 }
//	 log.info("");
//	 };
//   }
//	@Bean
	public CommandLineRunner demo(BreadRepository repository) {
		return(args)->{
			repository.save(new Bread("크로와상","64겹",5000));
			repository.save(new Bread("크로와상","128겹",7500));
			 log.info("Bread	found	with	findAll():");
			 log.info("-------------------------------");
			 for	(Bread	bread	:	repository.findAll())	{
			 log.info(bread.toString());
			 }
			 log.info("");
	};
   }	
		
}
