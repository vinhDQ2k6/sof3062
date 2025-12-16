package com.asm.sof3062.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <h1>EnvLoader</h1>
 * <p>
 * Imagine this class as a helpful assistant who reads a secret note (the .env
 * file)
 * before the main show starts.
 * </p>
 * <p>
 * <b>Why do we need this?</b><br>
 * Sometimes we have secret keys or settings (like database URLs) that we don't
 * want
 * to hardcode in our program. We write them in a file named ".env".
 * This class reads that file and whispers the secrets to the System so the rest
 * of
 * the application can hear them.
 * </p>
 */
public class EnvLoader {

    /**
     * Loads environment variables from a .env file into System properties.
     * <p>
     * It looks for a file named ".env" in the project root. If found, it reads
     * line by line, splits by "=", and sets the key-value pair in the System.
     * </p>
     */
    public static void load() {
        File envFile = new File(".env");
        if (envFile.exists()) {
            try (Scanner scanner = new Scanner(envFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    // Skip empty lines and comments (lines starting with #)
                    if (!line.isEmpty() && !line.startsWith("#") && line.contains("=")) {
                        String[] parts = line.split("=", 2);
                        // Tell the System about this new secret
                        System.setProperty(parts[0].trim(), parts[1].trim());
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Failed to load .env file: " + e.getMessage());
            }
        }
    }
}
