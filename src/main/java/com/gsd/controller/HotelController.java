package com.gsd.controller;

import com.gsd.annotation.OperateLog;
import com.gsd.entity.Hotel;
import com.gsd.entity.Scenery;
import com.gsd.service.HotelService;
import com.gsd.vo.PageBean;
import com.gsd.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HotelController.java
 * @Description TODO
 * @createTime 2023年09月12日 07:10:00
 */

@Controller
@RequestMapping("hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    /**
     * http://localhost/hotel/findAll
     * @return
     */
    @GetMapping("findAll")
    @ResponseBody//返回JSON
    @OperateLog(operatemsg = "查询所有", logtype = "查询",requestmethod = "get")
    public List<Hotel> findAll(){
        return hotelService.findAll3(new Hotel());
    }

    /**
     * http://localhost/hotel/page
     * @param curPage
     * @param pageSize
     * @param model
     * @param hotel
     * @return
     */
    @GetMapping("page")//跳转网页hotelAll.jsp
    public String page(@RequestParam(name="curPage",required = false,defaultValue = "1")Integer curPage,
                       @RequestParam(name="pageSize",required = false,defaultValue = "5")Integer pageSize,
                       Model model,
                       Hotel hotel){
        System.out.println("查询参数: "+hotel);//查询参数，用Map或实体类做参数
        PageBean pb = hotelService.page(curPage, pageSize, hotel);
        model.addAttribute("pb",pb);//用Model返回
        return "hotelAll";
    }


    @PostMapping("addHotel")
    @ResponseBody
    public Result addHotel(Hotel hotel, Model model, MultipartFile file, HttpServletRequest request)throws IOException {
        int rows = hotelService.addHotel(hotel,file);
        if(rows==1){
            return new Result("添加成功");
        }else {
            return new Result(false,"添加失败");
        }
    }

    //根据景点ID查找景点
    // http://localhost/hotel/2
    @GetMapping("{hotelid}")
    @ResponseBody
    public Hotel findHotelByHotelid(@PathVariable(value="hotelid") Long hotelid) {

        return hotelService.findHotelByHotelid(hotelid);
    }

    //删除,请求方式不一样
    @DeleteMapping("{hotelid}")
    @ResponseBody
    public Result deleteById(@PathVariable(value="hotelid") Long hotelid) throws IOException {
        int rows = hotelService.deleteByPrimaryKey(hotelid);
        if (rows == 1) {
            return new Result("删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }

//修改
    @PostMapping("updateHotel")
    @ResponseBody
    public Result updateHotel(Hotel hotel, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(hotel);
        int rows = hotelService.updateByPrimaryKeySelective(hotel,file);
        if(rows==1){
            return new Result("修改成功");
        }else {
            return new Result(false,"修改失败");
        }
    }
}
