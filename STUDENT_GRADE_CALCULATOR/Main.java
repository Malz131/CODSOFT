public class Main {

    public static void main(String[] args) {
        Student student=new Student();
        Calculator calculater=new Calculator(student);
        Processor processor=new Processor(calculater, student);
        processor.process();
        //cOoKeD
        //TODO:INCLUDE COMMENTS.
    }
}
