package ru.sberbank.school.HomeTask8;

import java.io.File;

public class PluginImpl implements Plugin {
    private File file;

    public PluginImpl(File file) {
        this.file = file;
    }

    @Override
    public void doUsefull() {
        System.out.println("Hi");
    }
}
