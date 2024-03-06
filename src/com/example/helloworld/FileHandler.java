package com.example.helloworld;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    public static void main(String[] args) {
        File file1 = new File(args[0]);
        file1.delete();
    }

    // Compliant code example
    public void deleteFile1() {
        File file2 = new File("file");
        if (!file2.delete()) {
            // Deletion failed, handle error
        }
    }

    // Compliant code example
    public void deleteFile2() {
        Path file3 = new File("file2").toPath();
        try {
            Files.delete(file3);
        } catch (IOException x) {
            // Deletion failed, handle error
        }
    }
}
