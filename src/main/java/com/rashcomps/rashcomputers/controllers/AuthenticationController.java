package com.rashcomps.rashcomputers.controllers;

import com.rashcomps.rashcomputers.config.JwtTokenUtil;
import com.rashcomps.rashcomputers.dtos.CreateUser;
import com.rashcomps.rashcomputers.exceptions.UserNotFoundException;
import com.rashcomps.rashcomputers.serviceImpl.UserServiceImplementation;
import com.rashcomps.rashcomputers.utils.JwtRequest;
import com.rashcomps.rashcomputers.utils.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auths")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserServiceImplementation userDetailsService;

	@Autowired
	private UserServiceImplementation userServiceImplementation;

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByEmail(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping("/sign-user")
	public ResponseEntity<?> saveUser(@RequestBody CreateUser user) throws Exception {
		return ResponseEntity.ok(userServiceImplementation.signupNewUser(user));
	}

	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new UserNotFoundException("Email or password is incorrect");
		}
	}
}
