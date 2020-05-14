package com.felipedeveloper.reportapp.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipedeveloper.reportapp.entities.Report;
import com.felipedeveloper.reportapp.entities.User;
import com.felipedeveloper.reportapp.entities.enums.DepartmentEnum;
import com.felipedeveloper.reportapp.entities.enums.ProcessEnum;
import com.felipedeveloper.reportapp.repositories.ReportRepository;
import com.felipedeveloper.reportapp.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReportRepository reportRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Felipe Campanaro", "felipe@gmail.com", "Maintenance Manager", 20001000, "123456");
		User user2 = new User(null, "Maria Brown", "maria@hotmail.com", "Maintenance Supervisor", 2000950, "123456");
		User user3 = new User(null, "Alex John", "felipe@gmail.com", "Electrical Engineer", 2000504, "123456");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Report repo1 = new Report(null, Instant.parse("2020-05-09T18:53:02Z"), ProcessEnum.INSTALLATION, DepartmentEnum.ENGINEERING, "Globoplay", "Installed a new equipment connecting EPTV station to Globo station", user1);
		Report repo2 = new Report(null, Instant.parse("2020-05-11T09:04:08Z"), ProcessEnum.FAIL, DepartmentEnum.CBN, "Tieline", "Failed to connect CBN RP to CBN SCL. The issue was in the internet provider.", user2);
		Report repo3 = new Report(null, Instant.parse("2020-05-12T13:32:56Z"), ProcessEnum.REPAIR, DepartmentEnum.JOURNALISM, "Audio Switcher Lawo", "Repaired a motherboard responsible to boot up the main system", user3);
		
		reportRepository.saveAll(Arrays.asList(repo1, repo2, repo3));
		
	}
	
	

}
