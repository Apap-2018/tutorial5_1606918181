package com.apap.tutorial5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.repository.DealerDb;
import com.apap.tutorial5.service.CarService;
import com.apap.tutorial5.service.DealerService;

@Controller
public class DealerController {
	@Autowired
	private DealerService dealerService;
	
	@Autorwired
	private CarService carService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("dealer", new DealerModel());
		return "addDealer";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
	private String addDealerSubmit(@ModelAttribute DealerModel dealer) {
		dealerService.addDealer(dealer);
		return "add";
	}
	
	@RequestMapping(value = "/dealer/view", method = RequestMethod.GET)
	public String viewDealer(@RequestParam (value = "dealerId") long dealerId, Model model) {
		DealerModel archive = dealerService.getDealerDetailById(dealerId).get();
		model.addAttribute("dealer", archive);		
		return "view-dealer";
	}
	
	//Latihan 2: buatlah fitur delete​ untuk menghapus dealer dan sebuah mobil
	@RequestMapping(value = "/dealer/delete", method = RequestMethod.GET)
	private String deleteDealer(@RequestParam("dealerId") long id, Model model) {
		Optional<DealerModel> dealer = dealerService.getDealerDetailById(id);
	
			dealerService.deleteDealer(dealer.get());
			return "delete";
		}
	
	//Latihan 3: buatlah fitur update​ untuk seorang dealer dan sebuah mobil
	@RequestMapping(value = "/dealer/update/{id}", method = RequestMethod.GET)
	private String update(@PathVariable(value = "id") long id, Model model) {
		DealerModel dealer = dealerService.getDealerDetailById(id).get();
		model.addAttribute("dealer",dealer);
		return "updateDealer";
	}
	
	@RequestMapping(value = "/dealer/update/{id}", method = RequestMethod.POST)
	private String updateDealerSubmit(@PathVariable (value = "id") long id, @ModelAttribute Optional<DealerModel> dealer) {
		if(dealer.isPresent()) {
			dealerService.updateDealer(id, dealer);
			return "update";
		}
		return "error";
	}
	
	//Latihan 4:  Buatlah fitur ​untuk ​melihat ​view all dealer sehingga dapat menampilkan brand mobil beserta amount dan price yang dijual
	@RequestMapping(value = "/dealer/view/all", method = RequestMethod.GET)
	private String viewAll(Model model) { 
		DealerDb archive = dealerService.viewAll();
		List<DealerModel> list = archive.findAll();
		model.addAttribute("listDealer",list);
		return "view-all";
	}
}
