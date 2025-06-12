package org.lucian.module2.TheaterSystem;

public class Main {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound, lights);

        homeTheater.startMovie();
        // ...movie is playing...
        homeTheater.endMovie();
    }
}
