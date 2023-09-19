package com.gsd.controller;

import com.gsd.entity.HotelArea;
import com.gsd.entity.RoomType;
import com.gsd.service.HotelAreaService;
import com.gsd.service.RoomTypeService;
import com.gsd.vo.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ScetypeController.java
 * @Description 单例
 * @createTime 2023年09月11日 12:50:00
 */
@Controller
//@Scope("prototype")//单例变原型
@RequestMapping("roomtype")
public class RoomTypeController {
    @Autowired
    RoomTypeService roomTypeService;

    // http://localhost/roomtype/findAll
    @GetMapping("findAll")
    @ResponseBody
    public List<RoomType> findAll(){
        return roomTypeService.findAll();
    }

    // http://localhost/roomtype/24
    @GetMapping("{hotelid}")
    public String findRoomtypeByHotelid(@PathVariable Long hotelid,
                                        Model model){
        model.addAttribute("roomtypeList", roomTypeService.findRoomtypeByHotelid(hotelid));
        return "roomtypeAll";
    }

    //在表格中更新
    //roomtype/updatyeRoomType
    @PostMapping("updatyeRoomType")
    @ResponseBody
    public Result updatyeRoom(RoomType roomType){
        System.out.println("房间: "+roomType);
        int rows = roomTypeService.updateRoomtype(roomType);
        if(rows==1){
            return new Result("添加成功");
        }else {
            return new Result(false,"添加失败");
        }
    }

    //localhost/roomtype/9
    @DeleteMapping("{roomtypeid}")
    @ResponseBody
    public Result deleteById(@PathVariable(value="roomtypeid") int roomtypeid) throws IOException {
        System.out.println("删除RoomType"+roomtypeid );
        int rows = roomTypeService.deleteRoomtype(new Long(roomtypeid));
        if (rows == 1) {
            return new Result("删除成功");
        } else {
            return new Result(false, "删除失败");
        }
    }



}
