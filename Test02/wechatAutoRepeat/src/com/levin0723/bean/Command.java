package com.levin0723.bean;

import java.util.List;

public class Command {
    private String id;
    private String name;
    private String description;
    private List<Command_content> contentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Command_content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Command_content> contentList) {
        this.contentList = contentList;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
