package com.example.helloworld;

import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;

public class CustomClassLoader extends URLClassLoader {
    public CustomClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    // Noncompliant Code Example
    protected PermissionCollection getPermissions(CodeSource codesource) {
        PermissionCollection perms = new Permissions();
        // Allow exit from the VM anytime
        perms.add(new RuntimePermission("exitVM"));
        return perms;
    }

    // Compliant Solution
    /*protected PermissionCollection getPermissions(CodeSource codesource) {
        PermissionCollection perms = super.getPermissions(codesource);
        // Allow exit from the VM anytime
        perms.add(new RuntimePermission("exitVM"));
        return perms;
    }*/
}
