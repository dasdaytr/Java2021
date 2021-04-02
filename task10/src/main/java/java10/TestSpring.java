package java10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext example = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestProgrammer testProgrammer = example.getBean("TestPr",TestProgrammer.class);
        testProgrammer.DoTestProgrammer();

    }
}
