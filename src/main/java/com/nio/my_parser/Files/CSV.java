package com.nio.my_parser.Files;

public class CSV implements File {
    private String filePath;

    public CSV(String name) {
        this.filePath = name;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
