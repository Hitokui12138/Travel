package com.gsd.entity;


public class RoomType {

  private Long roomtypeid;
  private String roomtype;
  private Long roomprice;
  private Long roomnum;
  private String acquiescence;
  private Long hotelid;
  private Long roomsize;
  private String intime;
  private String outtime;


  public Long getRoomtypeid() {
    return roomtypeid;
  }

  public void setRoomtypeid(Long roomtypeid) {
    this.roomtypeid = roomtypeid;
  }

  public String getRoomtype() {
    return roomtype;
  }

  public void setRoomtype(String roomtype) {
    this.roomtype = roomtype;
  }

  public Long getRoomprice() {
    return roomprice;
  }

  public void setRoomprice(Long roomprice) {
    this.roomprice = roomprice;
  }

  public Long getRoomnum() {
    return roomnum;
  }

  public void setRoomnum(Long roomnum) {
    this.roomnum = roomnum;
  }

  public String getAcquiescence() {
    return acquiescence;
  }

  public void setAcquiescence(String acquiescence) {
    this.acquiescence = acquiescence;
  }

  public Long getHotelid() {
    return hotelid;
  }

  public void setHotelid(Long hotelid) {
    this.hotelid = hotelid;
  }

  public Long getRoomsize() {
    return roomsize;
  }

  public void setRoomsize(Long roomsize) {
    this.roomsize = roomsize;
  }

  public String getIntime() {
    return intime;
  }

  public void setIntime(String intime) {
    this.intime = intime;
  }

  public String getOuttime() {
    return outtime;
  }

  public void setOuttime(String outtime) {
    this.outtime = outtime;
  }

  @Override
  public String toString() {
    return "RoomType{" +
            "roomtypeid=" + roomtypeid +
            ", roomtype='" + roomtype + '\'' +
            ", roomprice=" + roomprice +
            ", roomnum=" + roomnum +
            ", acquiescence='" + acquiescence + '\'' +
            ", hotelid=" + hotelid +
            ", roomsize=" + roomsize +
            ", intime='" + intime + '\'' +
            ", outtime='" + outtime + '\'' +
            '}';
  }
}
