package com.gsd.entity;

import java.io.Serializable;

/**
 * t_hotelprice
 * @author 
 */
public class Hotelprice implements Serializable {
    /**
     * 主键,自增
     */
    private Integer id;

    /**
     * 外键1
     */
    private Integer roomid;

    /**
     * 外键2
     */
    private Integer userid;

    /**
     * 房间的个数
     */
    private Integer roomcount;

    /**
     * 总价
     */
    private Integer sum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoomcount() {
        return roomcount;
    }

    public void setRoomcount(Integer roomcount) {
        this.roomcount = roomcount;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Hotelprice other = (Hotelprice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoomid() == null ? other.getRoomid() == null : this.getRoomid().equals(other.getRoomid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getRoomcount() == null ? other.getRoomcount() == null : this.getRoomcount().equals(other.getRoomcount()))
            && (this.getSum() == null ? other.getSum() == null : this.getSum().equals(other.getSum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoomid() == null) ? 0 : getRoomid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getRoomcount() == null) ? 0 : getRoomcount().hashCode());
        result = prime * result + ((getSum() == null) ? 0 : getSum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roomid=").append(roomid);
        sb.append(", userid=").append(userid);
        sb.append(", roomcount=").append(roomcount);
        sb.append(", sum=").append(sum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}