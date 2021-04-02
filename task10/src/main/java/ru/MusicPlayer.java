package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    //@Autowired
    private Music music;
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private  int volume;
    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }
    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    //@Autowired
    public MusicPlayer(Music music){
        this.music = music;
    }
    public void playMusic(){
        System.out.println("Playing" + music.getSong());
    }
    public String playMusic2(){
        return "Play "+ classicalMusic.getSong();

    }
    public MusicPlayer(){}
    //@Autowired
    public void setMusic(Music music) {
        this.music = music;
    }
}
