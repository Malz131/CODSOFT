import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Student {
    public static HashMap<String,Double> subjects;
        public Student(){
            Student.subjects=new HashMap<String,Double>();
    }
    public void input_subj_marks(String subject,Double mark){

        subjects.put(subject,mark);
    }
    public void remove_subj(String subject){
        subjects.remove(subject);
    }
    public void replace_marks(String subject,Double old_mark,Double new_mark){
        subjects.replace(subject, old_mark, new_mark);
    }
    public Set<String> get_subjects(){
        return subjects.keySet();
    }
    public Collection<Double> get_marks(){
        return subjects.values();
    }
// public static void main(String[] args) {
//     Student student=new Student();
//     input_subj_marks("Math", 45);
//     Collection<Integer> marks=get_marks();
//     for (Integer mark:marks){
//     System.out.println(mark);}

// }
}
