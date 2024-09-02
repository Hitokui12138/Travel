package com.gsd.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

//对于懒加载的属性需要加一个注解
@JsonIgnoreProperties(value = { "handler" })
public class Scetype implements Serializable {

  //对于懒加载的属性需要加一个注解

  private Long scetypeid;
  private String scename;
  private List<Scenery> sceneries;


  public Long getScetypeid() {
    return scetypeid;
  }

  public void setScetypeid(Long scetypeid) {
    this.scetypeid = scetypeid;
  }

  public List<Scenery> getSceneries() {
    return sceneries;
  }

  public void setSceneries(List<Scenery> sceneries) {
    this.sceneries = sceneries;
  }

  public String getScename() {
    return scename;
  }

  public void setScename(String scename) {
    this.scename = scename;
  }

  @Override
  public String toString() {
    return "Scetype{" +
            "scetypeid=" + scetypeid +
            ", scename='" + scename + '\'' +
            ", sceneries=" + sceneries +
            '}';
  }
}
