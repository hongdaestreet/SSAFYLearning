package com.ssafy.debug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.debug.model.dto.FruitDto;
import com.ssafy.debug.model.service.FruitService;

@Controller
@RequestMapping("/fruit")
public class FruitController {
//	@Autowired
	private FruitService fruitService;
	
	@Autowired
	public FruitController(FruitService fruitService) {
		this.fruitService = fruitService;
	}
	
	@GetMapping("/registform")
	public String registForm() {
		return "registform";
	}

	@PostMapping("/regist")
	public String regist(FruitDto fruitDto) {
		fruitService.registFruit(fruitDto);
		return "redirect:list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("fruitList", fruitService.getFruitList());
		return "list";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam("fruitId") int fruitId, Model model) {
		model.addAttribute("fruit", fruitService.getFruitDetail(fruitId));
		return "detail";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("fruitId") int fruitId) {
		fruitService.deleteFruit(fruitId);
		return "redirect:list";
	}

	@PostMapping("/updateform")
	public String updateForm(@RequestParam("fruitId") int fruitId, Model model) {
		model.addAttribute("fruit", fruitService.getFruitDetail(fruitId));
		return "updateform";
	}

	@PostMapping("/update")
	public String update(FruitDto fruitDto, /* @ModelAttribute */ Model model) {
        fruitService.updateFruit(fruitDto);
        return "redirect:detail?fruitId="+fruitDto.getFruitId();
    }
}
