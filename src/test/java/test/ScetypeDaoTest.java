package test;


import com.gsd.dao.ScetypeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ScetypeDaoTest.java
 * @Description TODO
 * @createTime 2023年09月11日 08:44:00
 *
 *
 * 提示Test失败的话可以选闪电
 *
 */

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class ScetypeDaoTest {
    @Autowired
    ScetypeDao scetypeDaoTest;

    /**
     * B.查所有type和对应的所有的景点
     */
    @Test
    public void test1(){

        scetypeDaoTest.findAll().forEach(System.out::println);
    }

    /**
     * C.查某个type和对应的所有的景点
     */
    @Test
    public void test2(){
        System.out.println(scetypeDaoTest.findOne(new Long(1)).getSceneries());
    }

    /**
     * 分页:
     * pagehelper,Mybatis提供的插件
     * 自带一个拦截器,可以修改sql语句,添加limit?
     * 四步
     * 使用
     */

}
