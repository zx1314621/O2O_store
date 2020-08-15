package edu.scu.xyl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * sprint and junit, load springIOC
 * 
 * @author dylan
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
//junit spring location
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {

}
