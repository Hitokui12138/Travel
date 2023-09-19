package com.gsd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gsd.dao.SceneryDao;
import com.gsd.entity.Scenery;
import com.gsd.util.FileUtils;
import com.gsd.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SceneryService.java
 * @Description TODO
 * @createTime 2023年09月08日 10:16:00
 */
@Service
public class SceneryService {
    @Autowired
    SceneryDao sceneryDao;

    public List<Scenery> findAll(){
        return sceneryDao.findAll(new Scenery());
    }

    public PageBean page(int curPage, int pageSize, Scenery scenery){
        Page<Scenery> page = PageHelper.startPage(curPage, pageSize);

//        int lowprice = (int) model.getAttribute("lowprice");
//        int highprice = (int) model.getAttribute("highprice");

        List<Scenery> sceneryList = sceneryDao.findAll(scenery);
        PageBean pb = new PageBean();
        pb.setCurPage(page.getPageNum());
        pb.setPages(page.getPages());
        pb.setList(page.getResult());
        return pb;
    }

    public List<Scenery> findAllSeason(){
        return sceneryDao.findAllSeason();
    }


    @Autowired
    HttpServletRequest request;

    public int addScenery(Scenery scenery, MultipartFile file) throws IOException {
        //应该在业务层封装上传文件，controller只要接收数据和返回结果
        scenery.setPic(FileUtils.up(file,request));
        return sceneryDao.addScenerySelective(scenery);
    }

    public int updateScenerySelective(Scenery scenery, MultipartFile file) throws IOException {
        //应该在业务层封装上传文件，controller只要接收数据和返回结果
        scenery.setPic(FileUtils.up(file,request));
        return sceneryDao.updateScenerySelective(scenery);
    }
    public Scenery findSceneryBysceid (Long sceid){
        return sceneryDao.findSceneryBysceid(sceid);
    }

    public int deleteById(Long sceid)  {
        return sceneryDao.deleteById(sceid);
    }

    public int batchDelete(int... sceids) {
        return sceneryDao.batchDelete(sceids);
    }

}
