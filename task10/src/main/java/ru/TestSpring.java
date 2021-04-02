package ru;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        /*//ClassPathXmlApplicationContext example = new ClassPathXmlApplicationContext("applicationContext.xml");
        * -----------------Старый способ создания  --- ----
        *                                             |
        *                                            \ /
        *        */
        AnnotationConfigApplicationContext example = new AnnotationConfigApplicationContext(SpringConfig.class);//<---новый способ
        //Music music =  example.getBean("musicBean",Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);
        //MusicPlayer musicPlayer = example.getBean("musicPlayer",MusicPlayer.class);
        //musicPlayer.playMusic2();
        //System.out.println(musicPlayer.getName() + " " + musicPlayer.getVolume());
        Computer computer = example.getBean("computer",Computer.class);
        System.out.println(computer);
        MusicPlayer musicPlayer = example.getBean("musicPlayer",MusicPlayer.class);
        System.out.println(musicPlayer.getName() + " " + musicPlayer.getVolume());
        example.close();
    }
}
/*Подсказки, что бы не забывать
* @Component - аннотация, которая дает java  понять, что надо создать bean
* @Autowired - аннотация, которая дает понять java, что надо искать конструкторы или сеттеры и автоматически подставлять значения
* @Qualifier("название класса")- аннотация, которая говорит java на основе какого класса создавать bean
* @Value - аннотация, которая ставится над переменными, которые мы хотим проиницилизировать из файла <название файла>.properties (файл ключ = значение)
* @Scope("singleton или prototype") - аннотация, которая говорит java на основе какого паттерна создавать bean*/
