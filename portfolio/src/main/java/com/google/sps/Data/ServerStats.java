package com.google.sps.Data;

import java.util.Date;

/** Class containing server statistics. */
public final class ServerStats {

  private final Date startTime;
  private final Date currentTime;
  private final long maxMemory;
  private final long usedMemory;

  public ServerStats(Date startTime, Date currentTime, long maxMemory, long usedMemory) {
    this.startTime = startTime;
    this.currentTime = currentTime;
    this.maxMemory = maxMemory;
    this.usedMemory = usedMemory;
  }

  public Date getStartTime() {
    return startTime;
  }

  public Date getCurrentTime() {
    return currentTime;
  }

  public long getMaxMemory() {
    return maxMemory;
  }

  public long getUsedMemory() {
    return usedMemory;
  }
}