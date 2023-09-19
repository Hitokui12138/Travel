package com.gsd.controller;

import com.gsd.entity.Area;
import com.gsd.entity.HotelArea;
import com.gsd.service.AreaService;
import com.gsd.service.HotelAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ScetypeController.java
 * @Description TODO
 * @createTime 2023年09月11日 12:50:00
 */
@Controller
@RequestMapping("hotelarea")
public class HotelAreaController {
    @Autowired
    HotelAreaService hotelAreaService;

    // http://localhost/hotelarea/findAll
    @GetMapping("findAll")
    @ResponseBody
    public List<HotelArea> findAll(){
        return hotelAreaService.findAll();
    }

}
