package test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsd.dao.SceneryDao;
import com.gsd.entity.Scenery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SceneryDaoTest.java
 * @Description TODO
 * @createTime 2023年09月08日 09:56:00
 */

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class SceneryDaoTest {
    @Autowired
    SceneryDao sceneryDaoTest;//可以去掉这个警告

    /**
     * A.查景点主表和Type名称
     */
    @Test
    public void test1(){
        //有些字段下划线没了
        sceneryDaoTest.findAll(new Scenery()).forEach(System.out::println);//select sceid,scename,scetypeid,c
    }

    @Test
    public void test2(){
        Page<Scenery> page = PageHelper.startPage(1, 5);
        System.out.println(page);//基本上都是0
        //sceneryDao.findAll().forEach(System.out::println);//多了个

        //1.page
        List<Scenery> secList = sceneryDaoTest.findAll(new Scenery());
        System.out.println(page);//发完select语句就有数据了
        System.out.println("当前页: " + page.getPageNum());
        System.out.println("总页数: " + page.getPages());
        System.out.println("总条数: " + page.getTotal());
        System.out.println("结果集: " + page.getResult());

        //2.PageInfo
        PageInfo<Scenery> pageInfo = new PageInfo<>(secList);//这个里面有更多数据

        /**
         * SELECT count(0) FROM t_scenery
         * LIMIT ?
         */
    }

    @Test
    public void test3(){
        //有些字段下划线没了
        sceneryDaoTest.findAllSeason().forEach(System.out::println);//select sceid,scename,scetypeid,c
    }
}
