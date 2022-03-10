package me.dio.web.challenge.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String name;
    private Set<Class> subscribedClasses = new LinkedHashSet<>();
    private Set<Class> completedClasses = new LinkedHashSet<>();

    public Dev(String name) {
        this.name = name;
    }

    public void subscribeBootcamp(Bootcamp bootcamp) {
        this.subscribedClasses.addAll(bootcamp.getContents());
        bootcamp.getSubscribedDevs().add(this);
    }

    public void advanceBootcamp() {
        Optional<Class> content = this.subscribedClasses.stream().findFirst();
        if (content.isPresent()) {
            this.completedClasses.add(content.get());
            this.subscribedClasses.remove(content.get());
        } else {
            System.err.println("You're not subscribed in none bootcamp!");
        }
    }

    public double calculateTotalXp() {
        return this.completedClasses.stream().mapToDouble(Class::calculateXp).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(subscribedClasses, dev.subscribedClasses) && Objects.equals(completedClasses, dev.completedClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscribedClasses, completedClasses);
    }

    public String getName() {
        return name;
    }

    public Set<Class> getSubscribedContents() {
        return subscribedClasses;
    }

    public Set<Class> getCompletedContents() {
        return completedClasses;
    }
}
