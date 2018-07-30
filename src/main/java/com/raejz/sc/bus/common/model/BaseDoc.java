package com.raejz.sc.bus.common.model;

import com.datastax.driver.mapping.annotations.Column;
import java.util.Date;

/**
 *
 */
public class BaseDoc {

  @Column(name = "create_at")
  private Date createAt;

  @Column(name = "modify_at")
  private Date modifyAt;

  public BaseDoc() {
  }

  public BaseDoc(Date createAt, Date modifyAt) {
    this.createAt = createAt;
    this.modifyAt = modifyAt;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getModifyAt() {
    return modifyAt;
  }

  public void setModifyAt(Date modifyAt) {
    this.modifyAt = modifyAt;
  }
}
