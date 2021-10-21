package com.seregsagapitov.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
		String dateString = simpleDateFormat.format(new Date());
		System.out.println(dateString);


		SpringApplication.run(RestDemoApplication.class, args);
	}

}
