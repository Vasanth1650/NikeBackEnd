/**
@Test annotation specifies that method is the test method.
@Test(timeout=?) annotation specifies that method will be failed if it takes longer than ? milliseconds (1 second).
@BeforeClass annotation specifies that method will be invoked only once, before starting all the tests.
@Before annotation specifies that method will be invoked before each test.
@After annotation specifies that method will be invoked after each test.
@AfterClass annotation specifies that method will be invoked only once, after finishing all the tests.
*
*User Entity TestCases
*@author Vasanth
 * */

package com.example.demo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.dao.UserDetailsRepository;
import com.example.demo.model.User;
import com.example.demo.service.CustomUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class NikeShopingApplicationTests {
	
	@Mock
	UserDetailsRepository repositorys;

	@MockBean
	private UserDetailsRepository repository;
	
	@Autowired
	private CustomUserService service;
	
	
	
	
	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new User(1,"vasanth","vasanth123@gmail.com","raina9486","1234567890","dawda","scawca",
				"ehiwad",true)).collect(Collectors.toList()));
		assertEquals(1, service.getUsers().size());
	}
	

}
