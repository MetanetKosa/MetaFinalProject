package com.example.metawater;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Test1 {

	@Test
	public void 컬렉션_테스트() {
			String[] str = {"ROLE_USER", "ROLE_ADMIN", "ROLE_MANAGER"};
			List<String> list = Arrays.asList(str);
			for (String s : list) {
				System.out.println(s);
			}
	}
}
