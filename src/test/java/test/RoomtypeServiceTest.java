package test;

import com.gsd.dao.HotelDao;
import com.gsd.dao.RoomTypeDao;
import com.gsd.entity.Hotel;
import com.gsd.entity.RoomType;
import com.gsd.service.RoomTypeService;
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
public class RoomtypeServiceTest {
    @Autowired
    RoomTypeService roomTypeService;

    @Autowired
    RoomTypeDao roomTypeDao;

    @Test
    public void test1(){
        System.out.println(roomTypeService.getClass().getName());

        RoomType roomType = new RoomType();
        roomType.setRoomtypeid(new Long(1));
        roomType.setRoomnum(new Long(100));
        roomTypeService.updateRoomtype(roomType);


    }
}
