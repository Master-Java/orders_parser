package com.nio.my_parser.Files;

public class JSON implements File{
    private String filePath;

    public JSON(String name) {
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
