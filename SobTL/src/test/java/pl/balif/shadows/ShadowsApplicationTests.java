package pl.balif.shadows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.balif.shadows.tl.bootstrap.springboot.ShadowsApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ShadowsApplication.class)
public class ShadowsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
