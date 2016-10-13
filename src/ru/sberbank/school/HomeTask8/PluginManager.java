package ru.sberbank.school.HomeTask8;

import java.io.File;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        try {
            File file = findFile(pluginClassName, new File(pluginRootDirectory, pluginName));
            return new PluginImpl(file);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File findFile(String className, File dir) throws ClassNotFoundException {
        File[] files = dir.listFiles();
        if (files == null) throw new ClassNotFoundException();
        for (File x : files) {
            if (x.isDirectory()) {
                File file = findFile(className, x);
                if (file != null) return file;
            } else {
                if (x.getName().equals(className))
                    return x;
            }
        }
        return null;
    }
}

