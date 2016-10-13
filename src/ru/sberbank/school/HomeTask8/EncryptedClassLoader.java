package ru.sberbank.school.HomeTask8;

import java.io.*;

public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    public Class<?> findClass(String className) {
        byte[] crypt = new byte[0];
        try (InputStream reader = new BufferedInputStream(new FileInputStream(dir))) {
            crypt = new byte[reader.available()];
            int data;
            int i = 0;
            while ((data = reader.read()) != -1) {
                crypt[i] = (byte) (data - key.charAt(i % key.length()));
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.defineClass(className, crypt, 0, crypt.length);
    }
}

