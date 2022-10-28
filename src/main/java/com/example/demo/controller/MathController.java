package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MathController {

	@GetMapping("calc") // nekoへのアクセスを制御する
	public String culcGet(Model model) {
		return "calc"; // neko.htmlをクライアントに返す
	}

	@PostMapping("calc") // nekoへのPOSTを制御する
	public String culcPost(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
		double sum = num1 + num2;
		double sub = num1 - num2;
		double mul = num1 * num2;
		double div;
		if (num2 != 0) {
			div = (double) num1 / num2;
		} else {
			div = 0;
		}
		model.addAttribute("sum", sum);
		model.addAttribute("sub", sub);
		model.addAttribute("mul", mul);
		model.addAttribute("div", div);
		return "calc"; // neko.htmlをクライアントに返す
	}

}
