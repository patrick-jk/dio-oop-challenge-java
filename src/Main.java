import me.dio.web.challenge.domain.*;
import me.dio.web.challenge.domain.Class;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Class class1 = new Course("Java course", "Java course description", 8);
        Class class2 = new Course("Javascript course", "Js course description", 4);
        Class mentoring = new Mentoring("Java mentoring", "Java mentoring description", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Java Developer Bootcamp Description");
        bootcamp.getContents().add(class1);
        bootcamp.getContents().add(class2);
        bootcamp.getContents().add(mentoring);

        Dev dev = new Dev("Dallon");
        getDeveloperBootcampProgress(dev, bootcamp);

        Dev dev1 = new Dev("Ryan");
        getDeveloperBootcampProgress(dev1, bootcamp);
    }

    private static void getDeveloperBootcampProgress(Dev dev, Bootcamp bootcamp) {
        dev.subscribeBootcamp(bootcamp);
        System.out.println(dev.getName() + "'s Subscribed Classes: " + dev.getSubscribedContents());
        if (dev.getName().equals("Dallon")) {
            dev.advanceBootcamp();
            dev.advanceBootcamp();
        } else {
            dev.advanceBootcamp();
            dev.advanceBootcamp();
            dev.advanceBootcamp();
        }
        System.out.println("-----");
        System.out.println(dev.getName() + "'s Subscribed Classes: " + dev.getSubscribedContents());
        System.out.println(dev.getName() + "'s Completed Classes: " + dev.getCompletedContents());
        System.out.println(dev.getName() + "'s XP: " + dev.calculateTotalXp());
        System.out.println("----------");
    }
}
