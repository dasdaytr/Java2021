package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private Music musicPlayer1;
    private Music musicPlayer2;
    @Autowired
    public Computer(@Qualifier("classicalMusic") Music musicPlayer1, @Qualifier("rockMusic") Music musicPlayer2) {
        this.musicPlayer1 = musicPlayer1;
        this.musicPlayer2 = musicPlayer2;
    }

    @Override
    public String toString() {
        return "Computer" + " " + musicPlayer1.getSong() + ", " + musicPlayer2.getSong();

    }
}
