package test;

import com.gsd.aop.HotelServiceImpl;
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

@SpringJUnitConfig(locations = "classpath:aop.xml")
public class AopTest {
    @Autowired
    HotelServiceImpl hotelService;//这里获取到的是代理对象

    /**
     * 有接口自动使用proxy
     * 没有的话使用cglib,也可以配置只使用某一种代理
     */

    @Test
    public void test1(){
        System.out.println(hotelService.add(10));
        hotelService.del();
    }
}
