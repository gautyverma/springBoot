package com.matuga.limitsservice.model;

public class Limits {
  int minimum;
  int mmaximum;

  public Limits(int minimum, int mmaximum) {
    this.minimum = minimum;
    this.mmaximum = mmaximum;
  }

  public int getMinimum() {
    return minimum;
  }

  public void setMinimum(int minimum) {
    this.minimum = minimum;
  }

  public int getMmaximum() {
    return mmaximum;
  }

  public void setMmaximum(int mmaximum) {
    this.mmaximum = mmaximum;
  }
}
