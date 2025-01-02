import java.util.HashMap;
import java.util.Scanner;
import java.util.Scanner;
public class Processor {
    /*The class Proccesor execute the programe's loops.
    */
    public static Calculator  calculator;public static Student  student;private static String input;public static String ischange;

    public Processor(Calculator calc,Student stud){
        /*Initializes instance variables for the Processor class. */
        Calculator.calculator=calc;
        Processor.student=stud;
        Processor.input="";
        Processor.ischange="";

    }
    //Suppress any resource leakage warnings.
    @SuppressWarnings("resource")
    public static void add(HashMap<String,Double> result_input){
        /*The add method adds another subject and their corresponding marks.*/
        boolean x=true;
        while (x==true){
            System.out.println("NOTE:Enter 'done' as input when finished.");
            System.out.print("Enter the subject  that you want to add: ");
            Scanner scan=new Scanner(System.in);
            //Takes subject name as input:
            String input=scan.nextLine();
            if (input.equals("")){System.out.println("ERROR:No subject is inputed");}
            else if (input.equals("done")){return;}
            else if (result_input.containsKey(input)){
                System.out.println("The subject already exists");
            }
            else{
            System.out.print("Enter the mark of "+input+": ");
                //Takes the subject's mark as input:
                String input0=scan.nextLine();
                if (input0.equals("done")){return;};

                try{

                Double mark=Double.parseDouble(input0);
                if (mark<0 || mark>100){
                System.out.println("Marks cannot be greater than 100 or less than 0");}
                else{
                    student.input_subj_marks(input,mark);}}
                catch(Exception e){System.out.println("ERROR:Marks should a value between 1-100");
                System.out.println("Re-enter the subject and marks");}}
        }
    ;}

    @SuppressWarnings("resource")
    public static void remove(HashMap<String,Double> result_input){
        /*The remove method removes a subject  inputed and their corresponding marks.*/
        boolean x=true;
        while (x==true){
            System.out.println("NOTE:Enter 'done' as input when finished.");
            System.out.print("Enter the subject  that you want to remove: ");
            Scanner scan=new Scanner(System.in);
            //Enter subject's name:
            String input=scan.nextLine();
            if (input.equals("")){System.out.println("ERROR:No subject is inputed");}
            else if (input.equals("done")){return;}

            else if (result_input.containsKey(input)){
                //remove subject
                student.remove_subj(input);
            }
            else{System.out.println("The subject does not exist");}
        }
    }
    @SuppressWarnings("resource")
    public static void replace(HashMap<String,Double> result_input){
        /*The replace method replaces a certain subject's mark that has been inputed.*/
        boolean x=true;
        while (x==true){
            System.out.println("NOTE:Enter 'done' as input when finished.");
            System.out.print("Enter the subject  that you want to replace the mark of: ");
            Scanner scan=new Scanner(System.in);
            String input=scan.nextLine();
            
            if (input.equals("")){System.out.println("ERROR:No subject is inputed");}
            else if (input.equals("done")){return;}
            else if (result_input.containsKey(input)){
                System.out.print("Enter the new mark: ");
                String input0=scan.nextLine();
                if (input0.equals("done")){return;};

                try{
                Double mark=Double.parseDouble(input0);
                if (mark<0 || mark>100){
                System.out.println("Marks cannot be greater than 100 or less than 0");}
                else{
                    student.replace_marks(input,result_input.get(input), mark);

                }}
                catch(Exception e){System.out.println("ERROR:Marks should a value between 1-100");
                System.out.println("Re-enter the subject and marks");}

            }
            else{System.out.println("The subject does not exist");}
        
    }}
    @SuppressWarnings({ "static-access", "unused" })
    public void process(){
        //The process method entire the entire programme and generate a respective terminal output display.
        
        @SuppressWarnings("resource")
        Scanner scan=new Scanner(System.in);
        boolean x=true;
        while (x=true){
         //Initial inputs:
            Double mark;
            System.out.print("Enter your subject (Enter 'done' when all/no subjects are entered): ");
            //Takes subject's name as input:
            String subject =scan.nextLine();
            if (subject.equals("")){System.out.println("ERROR:No subject/'done' is inputed");}
            else if (subject.equals("done")){break;}
            else{
            System.out.print("Enter your marks for the subject "+subject+": ");
            //Takes subject's mark as input:
            String input0 =scan.nextLine();
            try{
            mark=Double.parseDouble(input0);
            if (mark<0 ||mark>100){
                System.out.println("ERROR:Marks should a value between 1-100");
                System.out.println("Re-enter the subject and marks");
                continue; }
            else{
                student.input_subj_marks(subject, mark);
            }
            }
            catch(Exception e){System.out.println("ERROR:Marks should a value between 1-100");
            System.out.println("Re-enter the subject and mark");

            continue;}

        }}
        @SuppressWarnings("static-access")
        HashMap<String,Double> result_input=student.subjects;
        System.out.println("~~SUBJECTS(out of input)~~");
        //Prints out the subject-mark recorded from initial input:
        for(String key : result_input.keySet()){
            System.out.println(key+": "+Double.toString(result_input.get(key)));
        }
        System.out.println("");
        //Control which part of code is executed if an error in input occurs:
        Boolean err_switch=false;

        while(x=true){
    
        if (err_switch==false){
        @SuppressWarnings("resource")
        Scanner scan0=new Scanner(System.in);
        System.out.print("Do you want to do any changes/edit?(yes/no): ");
        ischange=scan0.nextLine();};
        //If changes want to be made within the subject-mark recorded :
        if (ischange.equals("yes") || err_switch==true){
        System.out.println("~OPTIONS:");
        System.out.println("ENTER 'replace' if you want to replace a certain subject's mark.");
        System.out.println("ENTER 'add' if you want to add a new subject.");
        System.out.println("ENTER 'remove' if you want to remove a subject.");
        System.out.println("");
        System.out.print("NOTE: Enter input 'done' when finished changes.");
        System.out.print("Enter input('add'/'replace'/'remove'/'done'): ");

        String input_c=scan.nextLine();
        if (input_c.equals("done")){break;}
        else if (input_c.equals("replace")){
            replace(result_input);
            System.out.println("~~SUBJECTS(MODIFIED)~~");
        //Prints out the subject-mark recorded from modified input:
            for(String key : result_input.keySet()){
                System.out.println(key+": "+Double.toString(result_input.get(key)));
            }
            err_switch=false;

        }
        else if (input_c.equals("add")){
            add(result_input);
        //Prints out the subject-mark recorded from modified input:
            System.out.println("~~SUBJECTS(MODIFIED)~~");
            for(String key : result_input.keySet()){
                System.out.println(key+": "+Double.toString(result_input.get(key)));
            }
            err_switch=false;

        }
        else if (input_c.equals("remove")){
            remove(result_input);
        //Prints out the subject-mark recorded from modified input:
            System.out.println("~~SUBJECTS(MODIFIED)~~");
            for(String key : result_input.keySet()){
                System.out.println(key+": "+Double.toString(result_input.get(key)));
            }
            err_switch=false;

        }
        
        else{System.out.println("ERROR:Input can only be 'remove'/'add'/'add'/'replace'");
        err_switch=true;
        }
        }
    //If changes do not want to be made within subject-mark recorded:
    else if (ischange.equals("no")){
        break;}
    else{System.out.println("ERROR:Input can only be 'yes' or 'no' ");
}
    }

    //Prints out the final subject-mark recorded:
    System.out.println("~~FINAL SUBJECTS~~");

    for(String key : result_input.keySet()){
        System.out.println(key+": "+Double.toString(result_input.get(key)));
    }
    System.out.println("-----------------");
    //Print out the total marks,Average percentage and grade:
    System.out.println("Total marks: "+Double.toString(calculator.total_marks()));
    System.out.print("Average Percentage: "+Double.toString(calculator.average_percentage()));
    System.out.print("  ");
    System.out.println("Grade: "+calculator.grade_decider());


        
        

    }
}
