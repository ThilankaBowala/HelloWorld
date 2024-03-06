package com.example.helloworld;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class PrivilegedBlocksExamples {

    // Noncompliant Code Example
    private void privilegedMethod1(final String filename)
            throws FileNotFoundException {
        try {
            FileInputStream fis =
                    (FileInputStream) AccessController.doPrivileged(
                            new PrivilegedExceptionAction() {
                                public FileInputStream run() throws FileNotFoundException {
                                    return new FileInputStream(filename);
                                }
                            }
                    );
            // Do something with the file and then close it
        } catch (PrivilegedActionException e) {
            // Forward to handler
        }
    }

    // Compliant Solution (Input Validation)
    private void privilegedMethod2(final String filename2)
            throws FileNotFoundException {
        final String cleanFilename;

        try {
            cleanFilename = cleanAFilenameAndPath(filename2);
        } catch (Exception e) {
            // Log or forward to handler as appropriate based on specification
            // of cleanAFilenameAndPath
        }
        try {
            FileInputStream fis =
                    (FileInputStream) AccessController.doPrivileged(
                            new PrivilegedExceptionAction() {
                                public FileInputStream run() throws FileNotFoundException {
                                    return new FileInputStream(cleanFilename);
                                }
                            }
                    );
            // Do something with the file and then close it
        } catch (PrivilegedActionException e) {
            // Forward to handler
        }
    }

    public String cleanAFilenameAndPath(String name) {
        //sanitize malicious inputs
        return name;
    }
}
