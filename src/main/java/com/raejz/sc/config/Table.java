package com.raejz.sc.config;

/**
 * Document the list of tables.  It
 */
public enum Table {
  ACTOR("ACTOR"),
  MOVIE("MOVIE");

  private final String tableName;

  Table(String tableName) {
    this.tableName = tableName;
  }

  public String getTableName() {
    return this.tableName;
  }
}
