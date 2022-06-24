package com.google.sps.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.sps.Data.ServerStats;

@WebServlet("/server-stats")
public final class ServerStatsServlet extends HttpServlet {

  private final Date startTime = new Date();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Calculate server stats
    Date currentTime = new Date();
    long maxMemory = Runtime.getRuntime().maxMemory();
    long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

    // Convert the server stats to JSON
    ServerStats serverStats = new ServerStats(startTime, currentTime, maxMemory, usedMemory);
    String json = convertToJson(serverStats);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  /**
   * Converts a ServerStats instance into a JSON string using manual String concatentation.
   */
  private String convertToJson(ServerStats serverStats) {
    String json = "{";
    json += "\"startTime\": ";
    json += "\"" + serverStats.getStartTime() + "\"";
    json += ", ";
    json += "\"currentTime\": ";
    json += "\"" + serverStats.getCurrentTime() + "\"";
    json += ", ";
    json += "\"maxMemory\": ";
    json += serverStats.getMaxMemory();
    json += ", ";
    json += "\"usedMemory\": ";
    json += serverStats.getUsedMemory();
    json += "}";
    return json;
  }

  /**
   * Converts a ServerStats instance into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  private String convertToJsonUsingGson(ServerStats serverStats) {
    Gson gson = new Gson();
    String json = gson.toJson(serverStats);
    return json;
  }
}