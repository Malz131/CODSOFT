public class Main {

    public static void main(String[] args) {
        //Creates student object
        Student student=new Student();
        //Create calculator object
        Calculator calculater=new Calculator(student);
        //Create the processor object
        Processor processor=new Processor(calculater, student);
        //execute the programme process by utilising method process
        processor.process();
    }
}
