package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Neko;
import com.example.demo.service.NekoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NekoController {
	@Autowired
	private final NekoService service;

	@GetMapping("neko") // nekoへのアクセスを制御する
	public String hello(Model model) {
		model.addAttribute("nekoList", service.getNekoList()); // nekoListにねこを詰め込む
		return "neko"; // neko.htmlをクライアントに返す
	}

	@PostMapping("neko") // nekoへのPOSTを制御する
	public String insertNeko(@ModelAttribute Neko form, Model model) { // formとしてNekoをそのまま使う(手抜き)
		service.insertNeko(form); // DBにinsert
		model.addAttribute("nekoList", service.getNekoList()); // serviceから一覧を再取得
		return "neko"; // neko.htmlをクライアントに返す
	}
}
