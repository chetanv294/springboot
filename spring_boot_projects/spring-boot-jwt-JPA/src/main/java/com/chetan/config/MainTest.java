package com.chetan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.model.JwtRequest;
import com.chetan.model.JwtResponse;
import com.chetan.service.JwtUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@CrossOrigin
public class MainTest {
	
	@Autowired
	private JwtTokenUtil2 jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/testtoken", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		// System.out.println( userDetailsService );
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		String pass = encode.encode(authenticationRequest.getPassword());
		//System.out.println( authenticationRequest.getPassword() );
		//System.out.println( pass );
		
		final String token = jwtTokenUtil.generateToken(userDetails, pass + pass.substring(1, 2));
		
		//String uname = jwtTokenUtil.getUsernameFromToken( token );

		return ResponseEntity.ok(new JwtResponse( token ));
	}
	

}
