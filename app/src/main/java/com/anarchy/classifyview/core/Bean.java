package com.anarchy.classifyview.core;

/**
 * <p/>
 * Date: 16/6/7 16:41
 * Author: rsshinide38@163.com
 * <p/>
 */
public class Bean {
    private String name;
    private String folderName;
    private boolean isFolder = false;

    public String getName() {
        return name;
    }

    public Bean setName(String name) {
        this.name = name;
        return this;
    }

    public String getFolderName() {
        return folderName;
    }

    public Bean setFolderName(String folderName) {
        this.folderName = folderName;
        return this;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public Bean setFolder(boolean folder) {
        isFolder = folder;
        return this;
    }

}
