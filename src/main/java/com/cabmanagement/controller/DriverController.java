package com.cabmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cabmanagement.dto.DriverDTO;
import com.cabmanagement.service.DriverService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

	private final DriverService driverService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public String addDriver(@ModelAttribute("driver") DriverDTO driver) {
		return "adddriver";
	}
	
}
