package com.google.sps.servlets;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Shows all of the images uploaded to Cloud Storage. */
@WebServlet("/list-images")
public class ListImage extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // List all of the uploaded files.
    String projectId = "rwu-sps-summer22";
    String bucketName = "rwu-sps-summer22.appspot.com";
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    Page<Blob> blobs = bucket.list();

    // Output <img> elements as HTML.
    response.setContentType("text/html;");
    int i = 0;
    for (Blob blob : blobs.iterateAll()) {
      i++;
      String imgTag = String.format("<img src=\"%s\" />", blob.getMediaLink());
      response.getWriter().println(imgTag);
      response.getWriter().println("<br>");
    }
    if(i == 0)
    {
        response.getWriter().println("There is no uploaded image");
    }
  }
}