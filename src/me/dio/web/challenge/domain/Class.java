package me.dio.web.challenge.domain;

public abstract class Class {
    protected static final double DEFAULT_XP = 10;

    private String title;
    private String description;

    public Class(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public abstract double calculateXp();

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
