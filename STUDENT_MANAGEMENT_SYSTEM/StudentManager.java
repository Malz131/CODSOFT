
import java.util.Scanner;

public class StudentManager{
    private static Scanner scan;
    public StudentManager(){

    }
    public static String input(){
            scan=new Scanner(System.in);
            String input =scan.nextLine();
             return input;
    }
    public static SingleStudent student(){
        SingleStudent no_one=new SingleStudent("none","none","none","none","none");
        Boolean on=true;


        while (on==true){
        System.out.print("ENTER STUDENT'S ROLL NUMBER: ");
        try {
        Integer roll_no=Integer.valueOf(input());
        System.out.print("ENTER STUDENT'S FULLNAME: ");
        String fullname=input();

        System.out.print("ENTER STUDENT'S GENDER(m-male|f-female): ");
        String gender=input();
        if (gender.equals("m") || gender.equals("f")){
            System.out.print("ENTER STUDENT'S CONTACT NUMBER: ");
            String contact_no=input();  
            System.out.print("ENTER STUDENT'S GRADE: ");
            String grade=input();  
            SingleStudent student=new SingleStudent(Integer.toString(roll_no), fullname, gender, grade, contact_no);
            return student;
        }
            else{
            System.out.println("ERROR:Input should only \nbe either 'm' or 'f'");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR:Invalid input,\nInput should be numbers.");
            }
        

        
           
}
    return no_one;
}
    public static void Student_edit(SingleStudent student){
        /*Edit a single data */
        Boolean on=true;
        while (on==true){
            System.out.println("STUDENT EDIT");
            System.out.println("+++++++++++++");
            System.out.println("1}CHANGE FULLNAME");
            System.out.println("2}CHANGE GRADE");
            System.out.println("3}CHANGE GENDER");
            System.out.println("4}CHANGE CONTACT NO.");
            System.out.println("5}DONE");

            System.out.print("ENTER OPTIONS(1-4): ");
            try{
            Integer option=Integer.valueOf(input());
            switch(option){
                case 1:
                System.out.print("ENTER NEW FULLNAME: ");
                String input=input();
                student.fullname=input;
                System.out.println("CHANGES MADE SUCCESSFULLY!");
                break;


                case 2:
                System.out.print("ENTER NEW GRADE: ");
                String input2=input();
                student.grade=input2;
                System.out.println("CHANGES MADE SUCCESSFULLY!");
                break;

                case 3:
                System.out.print("ENTER NEW GENDER(m-male or f-female): ");
                String input3=input();
                if (input3.equals("m") ||input3.equals("f")){
                    student.gender=input3;
                    System.out.println("CHANGES MADE SUCCESSFULLY!");
                    break;
                }
                else{
                System.out.print("ERROR:Input can only be 'm' or 'f'");
                }
                break;

                case 4:
                System.out.print("ENTER NEW CONTACT NO. : ");
                String input4=input();
                student.contact_no=input4;
                System.out.println("CHANGES MADE SUCCESSFULLY!");

                break;

                case 5:
                return;

                default:
                    System.out.print("ERROR:Input should be \nInteger value between 1-4");


            }}
            catch(NumberFormatException e){
                System.out.print("ERROR:Input should be \nInteger value between 1-4");
                
            }

        }

    }

    public static void edit(StudentStorage storage){
        Boolean on=true;
        while (on==true){
            try{
            System.out.print("ENTER STUDENT'S ROLL NUMBER: ");
            Integer roll_no=Integer.valueOf(input());
            SingleStudent student =storage.getstudent(Integer.toString(roll_no));
            //edits a certain student data:
            Student_edit(student);
            //update a certain student data that was stored:
            storage.update_student(student);
            
            return;
            }
            catch( NumberFormatException e){
                System.out.println("ERROR:Input should be a Integer.");

            }
        }


    }
    public  static void main_display(){
        //Main display:
        System.out.println("_____________________________________");
        System.out.println("_____________________________________");
        System.out.println("          STUDENT MANAGEMENT    ");
        System.out.println("_____________________________________");
        System.out.println("________________SYSTEM_______________");
        System.out.println("_____________________________________");
        System.out.println("            ☆☆☆ OPTIONS ☆☆☆☆         ");
        System.out.println("=====================================");
        System.out.println("->  1}ENTER AND STORE NEW STUDENT.");
        System.out.println("->   2}DISPLAY ALL STORED STUDENT.");
        System.out.println("->      3}SEARCH STUDENT.");
        System.out.println("->  4}EDIT STORED STUDENT'S DATA.");
        System.out.println("->       5}REMOVE A STUDENT.");
        System.out.println("->   6}REMOVE ALL STORED STUDENTS. ");
        System.out.println("->            7}EXIT");

        System.out.println("=====================================");






    }
    public void system(){
        Boolean on=true;
        Integer options;
        StudentStorage studentStorage=new StudentStorage();
        SingleStudent student;
        while (on==true){
            main_display();
            System.out.print("ENTER OPTION(1-7): ");
            try{
                options=Integer.valueOf(input());
                if (options>=1 &&options<=7){
                    //Stops the system from running:
                    if (options==7){
                        System.out.println("THANK YOU FOR USING OUR SERVICES!");
                        break;
                    }

                    //otherwise:
                    else{
                        switch (options) {
                            case 1: 
                            //Adds and stores students in a textfile.
                            student=student();
                            studentStorage.student_adder(student);
                            System.out.println("STORED SUCCESSFULLY!");

                            break;

                            case 2:
                            //Prints all students stored.
                            studentStorage.printStoragedata();
                            break;

                            case 3:
                            //Search if certain student is stored in the textfile.
                                System.out.print("ENTER ROLL NUMBER OF STUDENT: ");

                                try{
                                Integer roll_no=Integer.valueOf(input());
                                studentStorage.search_student(Integer.toString(roll_no));}
                                catch(NumberFormatException e){
                                System.out.println("ERROR:Input should be a Integer value.");
                                }
                                break;
                            case 4:
                            //edit a student's data and update the students data that is stored in the textfile.
                            edit(studentStorage);
                            break;

                            case 5:
                            //removes a student from the textfile.
                            System.out.print("ENTER ROLL NUMBER OF STUDENT: ");
                            try{
                            Integer roll_no=Integer.valueOf(input());
                            student=studentStorage.getstudent(Integer.toString(roll_no));
                            studentStorage.student_rmer(student);
                            }
                            catch(NumberFormatException e){
                            System.out.println("ERROR:Input should be a Integer value.");
                            }
                
                            break;
                            case 6:
                            //removes all student stored in the textfile
                            studentStorage.reset();
                            System.out.println("SUCCESSFULLY REMOVE ALL STORED STUDENTS!");
                            break;
                        }
;


                    }
                }
                else{
                System.out.println("ERROR:Input should be a \nInteger value between 1-7.");
                }
            }
            catch(NumberFormatException e){
                System.out.println("ERROR:Input should be a \nInteger value between 1-7.");
            }
        }

    }
    // @SuppressWarnings("static-access")
//     public static void main(String[] args) {
//         // SingleStudent student=new SingleStudent("123212331","Maloney Mkize","male","11","0790867915");
//         // StudentStorage studentStorage=new StudentStorage();
//         // studentStorage.add_student(student);
//         // student=new SingleStudent("34554321234","Avela Petu","male","12","06543334545");
//         // studentStorage.add_student(student);
//         // studentStorage.storeinfile();
//         // studentStorage.getdatastorage();
//         // studentStorage.deletefile();
//         // student=new SingleStudent("37464874568843","Esther Seisa","female","12","0765556775");
//         // studentStorage.add_student(student);
//         // studentStorage.storeinfile();
//         system();
//  }
}
