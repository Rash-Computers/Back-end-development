/**
 * @author: ntwari egide
 * @description: authentication end points controller
 */

package com.rashcomps.rashcomputers.controllers;

import com.rashcomps.rashcomputers.config.JwtTokenUtil;
import com.rashcomps.rashcomputers.dtos.SignupUserDto;
import com.rashcomps.rashcomputers.exceptions.UserNotFoundModifiedException;
import com.rashcomps.rashcomputers.models.User;
import com.rashcomps.rashcomputers.serviceImpl.UserDetailsImpl;
import com.rashcomps.rashcomputers.serviceImpl.UserServiceImpl;
import com.rashcomps.rashcomputers.services.JwtUserDetailsService;
import com.rashcomps.rashcomputers.utils.JwtRequest;
import com.rashcomps.rashcomputers.utils.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auths")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest loginRequest) throws Exception {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		System.out.println("Reached here: "+authentication.getCredentials());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenUtil.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));
	}

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody SignupUserDto user) throws Exception {
		User savedUser = userService.signupUser(user);

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(savedUser.getUsername(), user.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtTokenUtil.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			System.out.println("Reached here: "+username);

		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new UserNotFoundModifiedException("User name or password is incorrect");
		}
	}
}
