package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Neko;
import com.example.demo.mapper.NekoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NekoService {

	@Autowired
	private final NekoMapper mapper;

	/**
	 * ねこの一覧を取得する
	 *
	 * @return 一覧
	 */
	public ArrayList<Neko> getNekoList() {
		return mapper.getNekoList();
	}

	/**
	 * ねこを登録する
	 *
	 * @param neko
	 * @return
	 */
	public boolean insertNeko(Neko neko) {
		return mapper.insertNeko(neko);
	}
}