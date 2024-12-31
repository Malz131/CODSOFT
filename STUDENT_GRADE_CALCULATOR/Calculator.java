import java.util.Collection;
import java.util.Set;

public class Calculator {
    private static Student student;
    public static Calculator calculator;
    public double grade_decider;
    public Calculator(Student student0){
        Calculator.student=student0;
    }
    public static double total_marks(){
            Collection<Double> marks=student.get_marks();
            double sum_mark=0;
            for (double mark:marks){
                sum_mark=sum_mark+mark;
            };
            return sum_mark;
        }
        public static double average_percentage(){
            Set<String> subjects=student.get_subjects();
            int number_of_subj=subjects.size();
            double average = total_marks()/number_of_subj;
        return average;
    }
        public static String grade_decider(){
            Long average=Math.round(average_percentage());
        if (90<=average &&  average<=100){return "A";}
        else if (70<=average &&  average<=80){return "B";}
        else if (50<=average &&  average<=70){return "C";}
        else if (40<=average &&  average<=50){return "D";}
        else{return "F";}

    }
}
