package test;

import com.gsd.dao.HotelDao;
import com.gsd.entity.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelDaoTest.java
 * @Description TODO
 * @createTime 2023年09月12日 06:49:00
 */

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class HotelDaoTest {
    @Autowired
    HotelDao hotelDaoTest;

    @Test
    public void test1(){
        hotelDaoTest.findAll(new Hotel()).forEach(System.out::println);
    }
}
