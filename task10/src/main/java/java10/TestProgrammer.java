package java10;

public class TestProgrammer {
    private Programmer programmer;
    public TestProgrammer ( Programmer programmer){
        this.programmer = programmer;
    }
    public void DoTestProgrammer(){
        programmer.doCoding();
    }
}
