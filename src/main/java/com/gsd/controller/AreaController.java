package com.gsd.controller;

import com.gsd.entity.Area;
import com.gsd.entity.Scetype;
import com.gsd.service.AreaService;
import com.gsd.service.ScetypeService;
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
@RequestMapping("area")
public class AreaController {
    @Autowired
    AreaService areaService;

    // http://localhost/area/findAll
    @GetMapping("findAll")
    @ResponseBody
    public List<Area> findAll(){
        return areaService.findAll();
    }

}
