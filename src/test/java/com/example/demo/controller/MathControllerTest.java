package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.NekoMavenMySqlApplication;

@AutoConfigureMockMvc
@SpringBootTest(classes = NekoMavenMySqlApplication.class)
public class MathControllerTest {

	//mockMvc TomcatサーバへデプロイすることなくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
	@Autowired
	private MockMvc mockMvc;

	// getリクエストでviewを指定し、httpステータスでリクエストの成否を判定
	@Test
	void getでcalc画面に移ってHTTPステータスコード200が返る() throws Exception {
		// andDo(print())でリクエスト・レスポンスを表示
		this.mockMvc.perform(get("/calc")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("calc"));
	}

	@Test
	void form入力と計算テスト_通常() throws Exception {
		// @formatter:off
		// /inputにPostでアクセス、指定したパラメータを入力
		this.mockMvc.perform(post("/calc").param("num1", "5").param("num2", "10"))
				// modelのsumの値は15.0
				.andExpect(model().attribute("sum", 15.0))
				// modelのsubの値は-5.0
				.andExpect(model().attribute("sub", -5.0))
				// modelのmulの値は-50
				.andExpect(model().attribute("mul", 50.0))
				// modelのdivの値は0.5
				.andExpect(model().attribute("div", 0.5))
				// メソッドの戻り値はinput
				.andExpect(view().name("calc"));
	}

	@Test
	void form入力と計算テスト_0割り() throws Exception {
		// @formatter:off
		// /inputにPostでアクセス、指定したパラメータを入力
		this.mockMvc.perform(post("/calc").param("num1", "5").param("num2", "0"))
				// modelのsumの値は15.0
				.andExpect(model().attribute("sum", 5.0))
				// modelのsubの値は-5.0
				.andExpect(model().attribute("sub", 5.0))
				// modelのmulの値は-50
				.andExpect(model().attribute("mul", 0.0))
				// modelのdivの値は0.5
				.andExpect(model().attribute("div", 0.0))
				// メソッドの戻り値はinput
				.andExpect(view().name("calc"));
	}

}