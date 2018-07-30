package com.raejz.sc.config;

/**
 *
 * Specify the keyspace names
 * where app might need to access multiple keyspaces
 */
public enum Keyspace {
  SHOW_BUSINESS("SHOW_BUSINESS"),
  SPORT("SPORT");

  private final String keyspaceName;

  Keyspace(String keyspaceName) {
    this.keyspaceName = keyspaceName;
  }

  public String getKeyspaceName() {
    return this.keyspaceName;
  }
}
