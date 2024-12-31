import java.util.HashMap;
import java.util.Scanner;
import java.util.Scanner;
public class Processor {
    public static Calculator  calculator;public static Student  student;
    public Processor(Calculator calc,Student stud){
        Calculator.calculator=calc;
        Processor.student=stud;
    }
    public static void add(HashMap<String,Double> result_input){
        boolean x=true;
        while (x==true){
            System.out.println("NOTE:Enter 'done' as input when finished.");
            System.out.print("Enter the subject  that you want to add: ");
            Scanner scan=new Scanner(System.in);
            String input=scan.nextLine();
            if (input.equals("done")){return;};
            if (result_input.containsKey(input)){
                System.out.println("The subject already exists");
            }
            else{
            System.out.print("Enter the mark of "+input+": ");
                String input0=scan.nextLine();
                if (input0.equals("done")){return;};

                try{
                Double mark=Double.parseDouble(input0);
                if (mark<0 || mark>100){
                System.out.println("Marks cannot be greater than 100 or less than 0");}
                else{
                    student.input_subj_marks(input,mark);}}
                catch(Exception e){System.out.println("Invalid input");}}
        }
    ;}

    public static void remove(HashMap<String,Double> result_input){
        boolean x=true;
        while (x==true){
            System.out.println("NOTE:Enter 'done' as input when finished.");
            System.out.print("Enter the subject  that you want to remove: ");
            Scanner scan=new Scanner(System.in);
            String input=scan.nextLine();
            if (input.equals("done")){return;};
            if (result_input.containsKey(input)){
                student.remove_subj(input);
            }
            else{System.out.println("The subject does not exist");}
        }
    }
    @SuppressWarnings("resource")
    public static void replace(HashMap<String,Double> result_input){
        boolean x=true;
        while (x==true){
            System.out.println("NOTE:Enter 'done' as input when finished.");
            System.out.print("Enter the subject  that you want to replace the mark of: ");
            Scanner scan=new Scanner(System.in);
            String input=scan.nextLine();
            if (input.equals("done")){return;};

            if (result_input.containsKey(input)){
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
                catch(Exception e){System.out.println("Invalid input");}

            }
            else{System.out.println("The subject does not exist");}
        
    }}
    @SuppressWarnings("static-access")
    public void process(){
        //inputs:
        Scanner scan=new Scanner(System.in);
        boolean x=true;
        while (x=true){
            Double mark;
            System.out.print("Enter your subject (Enter 'done' when all/no subjects are entered): ");
            String subject =scan.nextLine();
            if (subject.equals("done")){break;};
            System.out.print("Enter your marks for the subject "+subject+": ");
            String input0 =scan.nextLine();
            try{
            mark=Double.parseDouble(input0);
            if (mark<0 ||mark>100){
                System.out.println("Marks cannot be greater than 100 or less than 0");
    
                continue; }
            else{
                student.input_subj_marks(subject, mark);
            }
            }
            catch(Exception e){System.out.println("Invalid input");

            continue;}

        }
        @SuppressWarnings("static-access")
        HashMap<String,Double> result_input=student.subjects;
        System.out.println("~~SUBJECTS(out of input)~~");

        for(String key : result_input.keySet()){
            System.out.println(key+": "+Double.toString(result_input.get(key)));
        }
        System.out.println("");

        while(x=true){
        @SuppressWarnings("resource")
        Scanner scan0=new Scanner(System.in);
        System.out.print("Do you want to do any changes/edit?(yes/no): ");
        String ischange=scan0.nextLine();
        if (ischange.equals("yes")){
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
            for(String key : result_input.keySet()){
                System.out.println(key+": "+Double.toString(result_input.get(key)));
            }
        }
        else if (input_c.equals("add")){
            add(result_input);
            System.out.println("~~SUBJECTS(MODIFIED)~~");
            for(String key : result_input.keySet()){
                System.out.println(key+": "+Double.toString(result_input.get(key)));
            }
        }
        else if (input_c.equals("remove")){
            remove(result_input);
            System.out.println("~~SUBJECTS(MODIFIED)~~");
            for(String key : result_input.keySet()){
                System.out.println(key+": "+Double.toString(result_input.get(key)));
            }
        }
        

        }
    else if (ischange.equals("no")){
        break;}
    }
    System.out.println("~~FINAL SUBJECTS~~");

    for(String key : result_input.keySet()){
        System.out.println(key+": "+Double.toString(result_input.get(key)));
    }
    System.out.println("-----------------");
    System.out.println("Total marks: "+Double.toString(calculator.total_marks()));
    System.out.print("Average Percentage: "+Double.toString(calculator.average_percentage()));
    System.out.print("  ");
    System.out.println("Grade: "+calculator.grade_decider());


        
        

    }
}
