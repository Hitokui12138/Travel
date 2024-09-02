package com.gsd.entity;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Hotel.java
 * @Description TODO
 * @createTime 2023年09月14日 08:05:00
 */
public class Hotel {

    private Long hotelid;
    private String hotelname;
    private String intime;
    private String outtime;
    private String pic;
    private Long hotelareaid;
    private Long roomtypeid;
    private String context;
    private Long collection;
    private Long favorite;
    private Long roomcount;
    private String site;
    private Long hotelphone;
    private Long price;

    //聚合属性
    private HotelArea hotelarea;
    private RoomType roomtype;

    public Long getHotelid() {
        return hotelid;
    }

    public void setHotelid(Long hotelid) {
        this.hotelid = hotelid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getHotelareaid() {
        return hotelareaid;
    }

    public void setHotelareaid(Long hotelareaid) {
        this.hotelareaid = hotelareaid;
    }

    public Long getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(Long roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getCollection() {
        return collection;
    }

    public void setCollection(Long collection) {
        this.collection = collection;
    }

    public Long getFavorite() {
        return favorite;
    }

    public void setFavorite(Long favorite) {
        this.favorite = favorite;
    }

    public Long getRoomcount() {
        return roomcount;
    }

    public void setRoomcount(Long roomcount) {
        this.roomcount = roomcount;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Long getHotelphone() {
        return hotelphone;
    }

    public void setHotelphone(Long hotelphone) {
        this.hotelphone = hotelphone;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public HotelArea getHotelarea() {
        return hotelarea;
    }

    public void setHotelarea(HotelArea hotelarea) {
        this.hotelarea = hotelarea;
    }

    public RoomType getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(RoomType roomtype) {
        this.roomtype = roomtype;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelid=" + hotelid +
                ", hotelname='" + hotelname + '\'' +
                ", intime='" + intime + '\'' +
                ", outtime='" + outtime + '\'' +
                ", pic='" + pic + '\'' +
                ", hotelareaid=" + hotelareaid +
                ", roomtypeid=" + roomtypeid +
                ", context='" + context + '\'' +
                ", collection=" + collection +
                ", favorite=" + favorite +
                ", roomcount=" + roomcount +
                ", site='" + site + '\'' +
                ", hotelphone=" + hotelphone +
                ", price=" + price +
                ", hotelarea=" + hotelarea +
                ", roomtype=" + roomtype +
                '}';
    }
}
