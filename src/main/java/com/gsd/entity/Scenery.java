package com.gsd.entity;


public class Scenery {
  //基本类型不能设为null,但数据库里有空
  private Long sceid;
  private String scename;
  private Long scetypeid;
  private String context;
  private String pic;
  private Long recommend;
  private Long areaid;
  private Long ticket;
  private Long favorite;
  private String season;
  private Long collection;
  private Long sceGrade;
  private String location;
//下划线没有自动生成?
  private String startTime;
  private Long ticCount;

  //多对一
  private Scetype scetype;
  private Area area;

  //拓展属性
  private Integer lowprice;
  private Integer highprice;

  public Integer getLowprice() {
    return lowprice;
  }

  public void setLowprice(Integer lowprice) {
    this.lowprice = lowprice;
  }

  public Integer getHighprice() {
    return highprice;
  }

  public void setHighprice(Integer highprice) {
    this.highprice = highprice;
  }

  /**
   * 现在的Scetype没有数据
   * 1. 在findAll里写一个多表关联
   * 2.
   *
   */


//重新生成getersetter
  public Long getSceid() {
    return sceid;
  }

  public void setSceid(Long sceid) {
    this.sceid = sceid;
  }

  public String getScename() {
    return scename;
  }

  public void setScename(String scename) {
    this.scename = scename;
  }

  public Long getScetypeid() {
    return scetypeid;
  }

  public void setScetypeid(Long scetypeid) {
    this.scetypeid = scetypeid;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public Long getRecommend() {
    return recommend;
  }

  public void setRecommend(Long recommend) {
    this.recommend = recommend;
  }

  public Long getAreaid() {
    return areaid;
  }

  public void setAreaid(Long areaid) {
    this.areaid = areaid;
  }

  public Long getTicket() {
    return ticket;
  }

  public void setTicket(Long ticket) {
    this.ticket = ticket;
  }

  public Long getFavorite() {
    return favorite;
  }

  public void setFavorite(Long favorite) {
    this.favorite = favorite;
  }

  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public Long getCollection() {
    return collection;
  }

  public void setCollection(Long collection) {
    this.collection = collection;
  }

  public Long getSceGrade() {
    return sceGrade;
  }

  public void setSceGrade(Long sceGrade) {
    this.sceGrade = sceGrade;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public Long getTicCount() {
    return ticCount;
  }

  public void setTicCount(Long ticCount) {
    this.ticCount = ticCount;
  }

  public Scetype getScetype() {
    return scetype;
  }

  public void setScetype(Scetype scetype) {
    this.scetype = scetype;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  @Override
  public String toString() {
    return "Scenery{" +
            "sceid=" + sceid +
            ", scename='" + scename + '\'' +
            ", scetypeid=" + scetypeid +
            ", context='" + context + '\'' +
            ", pic='" + pic + '\'' +
            ", recommend=" + recommend +
            ", areaid=" + areaid +
            ", ticket=" + ticket +
            ", favorite=" + favorite +
            ", season='" + season + '\'' +
            ", collection=" + collection +
            ", sceGrade=" + sceGrade +
            ", location='" + location + '\'' +
            ", startTime='" + startTime + '\'' +
            ", ticCount=" + ticCount +
            ", scetype=" + scetype +
            ", area=" + area +
            ", lowprice=" + lowprice +
            ", highprice=" + highprice +
            '}';
  }
}
