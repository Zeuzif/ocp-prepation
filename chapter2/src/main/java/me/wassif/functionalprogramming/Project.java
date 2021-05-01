package me.wassif.functionalprogramming;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@FunctionalInterface
public interface Project {
    public int getStatus();
}

// valid definitions of functional interface
@FunctionalInterface
interface chunk extends Project {
}

@FunctionalInterface
interface Sprint extends Project {
    public int getStatus();
}

@FunctionalInterface
interface Phase extends Project {
    default int getId() throws NoSuchAlgorithmException {
        return SecureRandom.getInstanceStrong().hashCode();
    }

    static void skip(int phase) {
    }
}