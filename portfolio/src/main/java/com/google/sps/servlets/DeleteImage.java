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
@WebServlet("/delete-image")
public class DeleteImage extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // List all of the uploaded files.
    String projectId = "rwu-sps-summer22";
    String bucketName = "rwu-sps-summer22.appspot.com";
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    Page<Blob> blobs = bucket.list();

    // Output <img> elements as HTML.
    response.setContentType("text/html;");
    for (Blob blob : blobs.iterateAll()) {
      blob.delete();
    }
    response.sendRedirect("/index.html");
  }
}