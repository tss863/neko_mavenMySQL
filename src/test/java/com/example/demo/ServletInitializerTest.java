package com.example.demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.builder.SpringApplicationBuilder;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class) for JUnit 4
class ServletInitializerTest {

	@Mock
	private SpringApplicationBuilder springApplicationBuilder;

	@Test
	public void servletInitializerテスト() {
		ServletInitializer servletInitializer = new ServletInitializer();
		when(springApplicationBuilder.sources(NekoMavenMySqlApplication.class)).thenReturn(springApplicationBuilder);

		SpringApplicationBuilder result = servletInitializer.configure(springApplicationBuilder);

		verify(springApplicationBuilder).sources(NekoMavenMySqlApplication.class);
		assertEquals(springApplicationBuilder, result);
	}

}