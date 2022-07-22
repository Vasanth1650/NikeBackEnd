package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.service.CustomUserService;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserService userservice;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint).and()
		.authorizeRequests(request->request.antMatchers("h2-console/**","/search/add","/api/v1/auth/login","api/v1/auth/dashbord","/auth/userinfo","/users/addUser","/users/addAuthority","/users/addAuth"
				,"/product/save","/product/{id}","/product/delete/{id}","/product/allproducts","/totalproducts/addproducts","/product/updateProduct/{id}","/addnew/save","/addnew/{id}","/totalproducts/allproducts",
				"/addnew/updateuser/{id}","/charging/{id}","/totalproducts/category/{category1}","/totalproducts/collection/{collection}","/totalproducts/gender/{gender}","/totalproducts/addproducts","/totalproducts/{id}","/totalproducts/delete/{id}",
				"/totalproducts/updateProduct/{id}","/memberacess/**",
				"/charging/checkout","/totalproducts/name/{productname}","/wishlist/addwishlist","/wishlist/{id}","/wishlist/userid/{userid}","/wishlist/product/{productid}","/wishlist/username/{username}"
				,"/addnew/findby/{username}","/ordered/generateorder","/ordered/getbyuserid/{userid}","/product/gender/{gender}","/ordered/updateOrder/{id}","/ordered/viewallproducts","/ordered/{id}","/charging/delete/{userid}","/charging/{userid}",
				"/product/update/{id}","/actuator/**","/refund/refunding/{userid}","/refund/viewerequest","/refund/{id}","/refund/refundcollector","/refund/updaterefund/{id}","/wishlist/productid/{productid}","/normalwishing/addwishlist","/normalwishing/{id}",
				"/product/productunder/{category1}","/normalwishing/username/{username}","/normalwishing/userid/{userid}","/normalwishing/productid/{productid}","/normalwishing/{id}","/subscription/addSubs","/subscription/allSubs","/plan/addPlan","/plan/allPlans",
				"/livechat/getByTunnelId/{tunnelid}","/livechat/getAllId","/livechat/deletetunnel/{tunnelid}","/livechat/addnewrequest").permitAll().antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated())
		.addFilterBefore(new JWTAuthenticationFilter(userservice,jwtTokenHelper),UsernamePasswordAuthenticationFilter.class);
		
		
		http.cors();
		
		http.csrf().disable().headers().frameOptions().disable();
	}

	
	
	

}
