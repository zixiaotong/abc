package com.abc.abc;

import com.abc.abc.model.web.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-12-10 18:23
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AbcApplication.class })
public class ComponentTest {
	@Autowired
	private Random random;

	@Test
	public void test1() {
        System.out.println(random.getV());
        System.out.println(random.getI());
        System.out.println(random.getL());
        System.out.println(random.getTeni());
        System.out.println(random.getTeni());
	}
}
