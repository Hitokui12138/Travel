package com.gsd.entity;


public class HotelArea {

  private Long hotelareaid;
  private String areaname;

  public Long getHotelareaid() {
    return hotelareaid;
  }

  public void setHotelareaid(Long hotelareaid) {
    this.hotelareaid = hotelareaid;
  }

  public String getAreaname() {
    return areaname;
  }

  public void setAreaname(String areaname) {
    this.areaname = areaname;
  }

  @Override
  public String toString() {
    return "HotelArea{" +
            "hotelareaid=" + hotelareaid +
            ", areaname='" + areaname + '\'' +
            '}';
  }
}
