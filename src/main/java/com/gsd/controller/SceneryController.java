package com.gsd.controller;

import com.gsd.annotation.OperateLog;
import com.gsd.entity.Area;
import com.gsd.entity.Scenery;
import com.gsd.service.SceneryService;
import com.gsd.vo.PageBean;
import com.gsd.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SceneryController.java
 * @Description TODO
 * @createTime 2023年09月08日 10:18:00
 */
@Controller
@RequestMapping("scenery")
public class SceneryController {
    @Autowired
    SceneryService sceneryService;

    // http://localhost/scenery/findAll
    @GetMapping("findAll")
    @OperateLog(operatemsg = "查询所有景点", logtype = "查询",requestmethod = "get")
    public String findAll(Model model) {
        model.addAttribute("sceneryList", sceneryService.findAll());
        return "sceneryAll";
    }

    @GetMapping("findAllSeason")
    @ResponseBody
    @OperateLog(operatemsg = "查询所有季节", logtype = "查询",requestmethod = "get")
    public List<Scenery> findAllSeason() {
        return sceneryService.findAllSeason();
    }


    /**
     * http://localhost/scenery/page
     * 分页
     *
     * @param curPage
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("page")
    @OperateLog(operatemsg = "分页查找景点", logtype = "查找",requestmethod = "get")
    public String page(@RequestParam(name = "curPage", required = false, defaultValue = "1") Integer curPage,
                       @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                       Model model,
                       Scenery scenery) {
        //int i = 1/0;
        System.out.println(scenery);//查询参数，用Map或实体类做参数

        PageBean pb = sceneryService.page(curPage, pageSize, scenery);
        model.addAttribute("pb", pb);
        return "sceneryAll";

    }

    //添加
    @PostMapping("addScenery")
    @ResponseBody
    @OperateLog(operatemsg = "添加景点", logtype = "添加",requestmethod = "post")
    public Result addScenery(Scenery scenery, Model model, MultipartFile file, HttpServletRequest request) throws IOException {
        int rows = sceneryService.addScenery(scenery, file);

        if (rows == 1) {
            return new Result("添加成功");
        } else {
            return new Result(false, "添加失败");
        }
    }

    //修改
    @PostMapping("updateScenery")
    @ResponseBody
    @OperateLog(operatemsg = "修改景点", logtype = "修改",requestmethod = "post")
    public Result updateScenery(Scenery scenery, Model model, MultipartFile file, HttpServletRequest request) throws IOException {
        int rows = sceneryService.updateScenerySelective(scenery, file);
        if (rows == 1) {
            return new Result("修改成功");
        } else {
            return new Result(false, "修改失败");
        }
    }
    //删除,请求方式不一样
    @DeleteMapping("{sceid}")
    @ResponseBody
    @OperateLog(operatemsg = "删除景点", logtype = "删除",requestmethod = "delete")
    public Result deleteById(@PathVariable(value="sceid") Long sceid) throws IOException {

        int rows = sceneryService.deleteById(sceid);
        if (rows == 1) {
            return new Result("删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

    //批量删除
    @GetMapping("batchDelete")
    @ResponseBody
    @OperateLog(operatemsg = "批量删除景点", logtype = "删除",requestmethod = "delete")
    public Result batchDelete(int[] sceids) throws IOException {
        System.out.println("batchDelete: " + Arrays.toString(sceids));
        int rows = sceneryService.batchDelete(sceids);
        if (rows > 1) {
            return new Result("批量删除成功");
        } else {
            return new Result(false, "批量删除失败");
        }
    }


    //根据景点ID查找景点
    @GetMapping("{sceid}")
    @ResponseBody
    @OperateLog(operatemsg = "根据id查景点", logtype = "查找",requestmethod = "get")
    public Scenery page(@PathVariable(value="sceid") Long sceid) {
        return sceneryService.findSceneryBysceid(sceid);
    }

}