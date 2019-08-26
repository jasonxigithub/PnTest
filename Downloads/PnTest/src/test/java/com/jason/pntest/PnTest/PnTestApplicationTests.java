package com.jason.pntest.PnTest;

import com.jason.pntest.PnTest.fcm.FcmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PnTestApplicationTests {

	@Test
	public void contextLoads() {
		String path = FcmService.class.getResource("/").getPath();
		System.out.println("======"+path);
	}

}
