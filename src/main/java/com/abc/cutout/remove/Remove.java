package com.abc.cutout.remove;


import org.apache.catalina.connector.Response;
import org.jsoup.helper.HttpConnection;

import java.io.File;


public class Remove {
    public static void main(String[] args) {
        // Requires "Apache HttpComponents" to be installed (see hc.apache.org)

//        Response response = Request.Post("https://api.remove.bg/v1.0/removebg")
//                .addHeader("X-Api-Key", "INSERT_YOUR_API_KEY_HERE")
//                .body(
//                        MultipartEntityBuilder.create()
//                                .addBinaryBody("image_file", new File("/path/to/file.jpg"))
//                                .addTextBody("size", "auto")
//                                .build()
//                ).execute();
//        response.saveContent(new File("no-bg.png"));
    }
}
