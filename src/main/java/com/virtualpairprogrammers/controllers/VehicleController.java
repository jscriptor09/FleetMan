package com.virtualpairprogrammers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.data.VehicleRepository;
import com.virtualpairprogrammers.domain.Vehicle;

@Controller
@RequestMapping("/website/vehicles")
public class VehicleController 
{
	@Autowired
	private VehicleRepository data;

	@RequestMapping(value="/newVehicle.html",method=RequestMethod.POST)
	public String newVehicle(Vehicle vehicle)
	{
		data.save(vehicle);
		return "redirect:/website/vehicles/list.html";
	}
	
	@RequestMapping(value="/newVehicle.html",method=RequestMethod.GET)
	public ModelAndView renderNewVehicleForm()
	{
		Vehicle newVehicle = new Vehicle();
		
		return new ModelAndView("newVehicle", "form", newVehicle);
		
		
	} 
	
	@RequestMapping(value="/list.html", method=RequestMethod.GET)	
	public ModelAndView vehicles()
	{
		List<Vehicle> allVehicals = data.findAll();
		
		
		Vehicle newVehicle = new Vehicle();
		newVehicle.setName("Truck 7");
		allVehicals.add(newVehicle);
		
		allVehicals.add(new Vehicle("Chevy Impala"));
		
		return new ModelAndView("allVehicles", "vehicles",allVehicals );
		
	}
	  
	@RequestMapping(value="/vehicle/{name}")
	public ModelAndView showVehicleByName(@PathVariable("name") String name)
	{

		Vehicle vehical = data.findByName(name);
		return new ModelAndView("vehicleInfo", "vehicle",vehical );
	}
	
}

