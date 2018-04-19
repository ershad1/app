package com.app.server.appresource.participantinfo.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderLocation {

    static String OS = System.getProperty("OS.name").toLowerCase();

    Path getFolderLocation() throws IOException {

        String root = "";
        if (OS.contains("win")) {
            root = "D:\\coelFiles";
        } else {
            root = "/home/coelFiles";
        }

        Path file = Paths.get(root);

        // this creates directories in case they don't exist
        Files.createDirectories(file.getParent());

        return file;
    }
}
