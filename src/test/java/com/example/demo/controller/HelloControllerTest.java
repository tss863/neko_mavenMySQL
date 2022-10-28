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
public class HelloControllerTest {

	//mockMvc TomcatサーバへデプロイすることなくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
	@Autowired
	private MockMvc mockMvc;

	// getリクエストでviewを指定し、httpステータスでリクエストの成否を判定
	@Test
	void hello画面に移ってHTTPステータスコード200が返る() throws Exception {
		// andDo(print())でリクエスト・レスポンスを表示
		this.mockMvc.perform(get("/helloWorld")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("hello"));
		;
	}

	@Test
	void modelのmessageににゃーが渡される() throws Exception {
		this.mockMvc.perform(get("/helloWorld"))
				.andExpect(model().attribute("message", "にゃー"));
	}
}