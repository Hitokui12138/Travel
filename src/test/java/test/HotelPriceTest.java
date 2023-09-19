package test;

import com.gsd.dao.HotelpriceDao;
import com.gsd.entity.Hotel;
import com.gsd.entity.Hotelprice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelPriceTest.java
 * @Description TODO
 * @createTime 2023年09月14日 08:13:00
 */
public class HotelPriceTest {
    @Autowired
    HotelpriceDao hotelpriceDaoTest;

    @Test
    public void Test1(){
        //hotelpriceDao.countByExample(new Hotelprice());
    }
}
