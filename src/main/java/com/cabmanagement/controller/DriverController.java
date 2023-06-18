package com.cabmanagement.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cabmanagement.dto.DriverDTO;
import com.cabmanagement.entites.Driver;
import com.cabmanagement.exception.DuplicateRecordException;
import com.cabmanagement.exception.RecordNotFoundException;
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
	public String showDriver(@ModelAttribute("driver") DriverDTO driver,@RequestParam(required = false) Long id) {
		log.info("showDriver method of DriverController started");
		if(driver.getId()!=null) {
			Driver driverData = driverService.findById(id);
			System.out.println("in >> "+driverData.getDriverIdNumber());
			driver.setId(driverData.getId());
			driver.setDriverIdNumber(driverData.getDriverIdNumber());
			driver.setDriverName(driverData.getDriverName());
			driver.setPhoneNo(driverData.getPhoneNo());
			driver.setEmail(driverData.getEmail());
			return "adddriver";
		}
		log.info("showDriver method of DriverController ended");
		return "adddriver";
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String addDriver(@Valid @ModelAttribute("driver") DriverDTO driver, Model model) {
		log.info("addDriver method of DriverController started");
		Driver dtoToEntity = DriverMapper.DTOToEntity(driver);
		System.out.println("dto - entity "+driver.getDriverIdNumber());
		if (ConstantFile.ADD_DRIVER.equals("Add Driver")) {
			if(driver.getId()!=null) {
				try {
					driverService.update(dtoToEntity, driver.getId());
					model.addAttribute("success", "Driver Updated Successfully");
				} catch (RecordNotFoundException e) {
					model.addAttribute("error", e.getMessage());
					return "adddriver";
				}
			} else {
				try {
					driverService.add(dtoToEntity);
					model.addAttribute("success", "Driver Added Successfully");
				} catch (DuplicateRecordException e) {
					model.addAttribute("error", e.getMessage());
					return "adddriver";
				}
			}
			
		}
		log.info("addDriver method of DriverController ended");
		return "adddriver";
	}
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String showList(@ModelAttribute("driver") DriverDTO driver, Model model) {
		if(driver.getId()!=null) {
			driverService.deleteDriver(driver.getId());
			model.addAttribute("success", "Driver Deleted Successfully");
		}
		List<Driver> allDriver = driverService.getAllDriver();
		if(allDriver.size() == 0) {
			model.addAttribute("error", "No Record Found");
		}
		model.addAttribute("list", allDriver);
		return "driverlist";
	}

}
