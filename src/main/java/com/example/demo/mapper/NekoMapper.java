package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Neko;

@Repository // springのDIの対象となる
@Mapper // MybatisでxmlのSQLが対応づけられる
public interface NekoMapper {
	public ArrayList<Neko> getNekoList();

	public boolean insertNeko(Neko neko);
}