package com.cabmanagement.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cabmanagement.dto.DriverDTO;
import com.cabmanagement.entites.Driver;
import com.cabmanagement.exception.DuplicateRecordException;
import com.cabmanagement.service.DriverService;
import com.cabmanagement.util.ConstantFile;
import com.cabmanagement.util.DriverMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DriverController {

	private final DriverService driverService;
	
	private Logger log = Logger.getLogger(DriverController.class.getName());

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/add" })
	public String showDriver(@ModelAttribute("driver") DriverDTO driver) {
		log.info("showDriver method of DriverController started");
		log.info("showDriver method of DriverController ended");
		return "adddriver";
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String addDriver(@Valid @ModelAttribute("driver") DriverDTO driver, Model model) {
		log.info("addDriver method of DriverController started");
		if (ConstantFile.ADD_DRIVER.equalsIgnoreCase("Add Driver")) {

			Driver dtoToEntity = DriverMapper.DTOToEntity(driver);

			try {
				driverService.add(dtoToEntity);
				model.addAttribute("success", "Driver Added Successfully");
			} catch (DuplicateRecordException e) {
				model.addAttribute("error", e.getMessage());
				return "adddriver";
			}
		}
		log.info("addDriver method of DriverController ended");
		return "adddriver";
	}

}
