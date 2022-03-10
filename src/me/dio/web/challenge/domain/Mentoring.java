package me.dio.web.challenge.domain;

import java.time.LocalDate;

public class Mentoring extends Class {
    private final LocalDate date;

    public Mentoring(String title, String description, LocalDate date) {
        super(title, description);
        this.date = date;
    }

    @Override
    public double calculateXp() {
        return DEFAULT_XP + 20;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Mentoring{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", date=" + date +
                '}';
    }
}
