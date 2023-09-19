package com.gsd.entity;


public class Area {

  private Long areaid;
  private String areaname;


  public Long getAreaid() {
    return areaid;
  }

  public void setAreaid(long areaid) {
    this.areaid = areaid;
  }


  public String getAreaname() {
    return areaname;
  }

  public void setAreaname(String areaname) {
    this.areaname = areaname;
  }

  @Override
  public String toString() {
    return "Area{" +
            "areaid=" + areaid +
            ", areaname='" + areaname + '\'' +
            '}';
  }
}
