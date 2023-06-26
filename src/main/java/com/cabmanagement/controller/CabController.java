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

import com.cabmanagement.dto.CabDTO;
import com.cabmanagement.entites.Cab;
import com.cabmanagement.entites.Driver;
import com.cabmanagement.exception.DuplicateRecordException;
import com.cabmanagement.exception.RecordNotFoundException;
import com.cabmanagement.service.CabService;
import com.cabmanagement.service.DriverService;
import com.cabmanagement.util.CabMapper;
import com.cabmanagement.util.ConstantFile;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CabController {

	private final CabService cabService;
	
	private final DriverService driverService;
	
	private Logger log = Logger.getLogger(CabController.class.getName());
	
	@ModelAttribute
	public void preload(Model model) {
		List<Driver> driverList = driverService.getAllDriver();
		model.addAttribute("driverList", driverList);
	}

	@RequestMapping(method = RequestMethod.GET, value =  "/cab" )
	public String showcab(@ModelAttribute("cab") CabDTO cab,@RequestParam(required = false) Long id) {
		log.info("showcab method of cabController started");
		if(cab.getId()!=null) {
			Cab cabData = cabService.findById(id);
			cab.setId(cabData.getId());
			cab.setCabRegistrationNumber(cabData.getCabRegistrationNumber());
			cab.setCabModel(cabData.getCabModel());
			cab.setCabColour(cabData.getCabColour());
			return "addcab";
		}
		log.info("showcab method of cabController ended");
		return "addcab";
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cab")
	public String addCab(@Valid @ModelAttribute("cab") CabDTO cab, Model model) {
		log.info("addCab method of cabController started");
		Cab dtoToEntity = CabMapper.DTOToEntity(cab);
		if (ConstantFile.ADD_CAB.equals("Add Cab")) {
			if(cab.getId()!=null) {
				try {
					cabService.update(dtoToEntity, cab.getId());
					model.addAttribute("success", "Cab Updated Successfully");
				} catch (RecordNotFoundException e) {
					model.addAttribute("error", e.getMessage());
					return "addcab";
				}
			} else {
				try {
					cabService.add(dtoToEntity);
					model.addAttribute("success", "Cab Added Successfully");
				} catch (DuplicateRecordException e) {
					model.addAttribute("error", e.getMessage());
					return "addcab";
				}
			}
			
		}
		log.info("addcab method of CabController ended");
		return "addcab";
	}
	
	@RequestMapping(value = "/cabs", method = {RequestMethod.GET, RequestMethod.POST})
	public String showList(@ModelAttribute("cab") CabDTO cab, Model model) {
		if(cab.getId()!=null) {
			cabService.deleteCab(cab.getId());
			model.addAttribute("success", "cab Deleted Successfully");
		}
		List<Cab> allcab = cabService.getAllCab();
		if(allcab.size() == 0) {
			model.addAttribute("error", "No Record Found");
		}
		model.addAttribute("list", allcab);
		return "cablist";
	}
	
	@RequestMapping(value = "/view/drivers", method = {RequestMethod.GET, RequestMethod.POST})
	public String showDriverList(@ModelAttribute("cab") CabDTO cab, Model model) {
		if(cab.getId()!=null) {
			List<Driver> list = driverService.findDriversAssinedToCab(cab.getId());
			if(list.size() == 0) {
				model.addAttribute("success", "No Drivers Assigned");
			}
			model.addAttribute("list", list);
		}
		return "viewdrivers";
	}
	
	@RequestMapping(value = "/cablist", method = {RequestMethod.GET, RequestMethod.POST})
	public String showListForCabPage(@ModelAttribute("cab") CabDTO cab, Model model) {
		if(cab.getId()!=null) {
			cabService.deleteCab(cab.getId());
			model.addAttribute("success", "Driver Deleted Successfully");
		}
		List<Cab> allcab = cabService.getAllCab();
		if(allcab.size() == 0) {
			model.addAttribute("error", "No Record Found");
		}
		model.addAttribute("list", allcab);
		return "cab";
	}
	
	@RequestMapping(method = RequestMethod.GET, value =  "/assign" )
	public String showAssignDriverPage(@ModelAttribute("cab") CabDTO cab,@RequestParam(required = false) Long id) {
		log.info("showAssignDriverPage method of cabController started");
		if(cab.getId()!=null) {
			Cab cabData = cabService.findById(id);
			
			
			cab.setId(cabData.getId());
			cab.setCabRegistrationNumber(cabData.getCabRegistrationNumber());
			cab.setCabModel(cabData.getCabModel());
			cab.setCabColour(cabData.getCabColour());
			if(cabData.getDriver()!=null) {
			cab.setDriverId(cabData.getDriver().getId());
			}
			return "assigndrivers";
			
		}
		log.info("showAssignDriverPage method of cabController ended");
		return "assigndrivers";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/driver/assigncab")
	public String assignDriversToCab(@ModelAttribute("cab") CabDTO cab, Model model) {
		Cab dtoToEntity = CabMapper.DTOToEntity(cab);
		log.info("cabid >>" + dtoToEntity.getId()+"driver id : "+cab.getDriverId());
		Long cabId = dtoToEntity.getId();
		Long driverId = cab.getDriverId();
		cabService.assignDriversToCab(driverId, cabId);
		model.addAttribute("success", "Driver Assigned to Cab Successfully");
		return "assigndrivers";

	}

}
