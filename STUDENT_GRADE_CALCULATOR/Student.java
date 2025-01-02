import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Student {
    /*The Student class stores, modify and remove the subject-mark pairs within a HashMap object 'subjects'.*/
    public static HashMap<String,Double> subjects;
        public Student(){
            Student.subjects=new HashMap<String,Double>();
    }
    public void input_subj_marks(String subject,Double mark){
        /*The method input_subj_marks stores subject-mark in the HashMap object 'subjects'.*/
        subjects.put(subject,mark);
    }
    public void remove_subj(String subject){
        /*The method remove_subj removes subject-mark in the HashMap object 'subjects'.*/
        subjects.remove(subject);
    }
    public void replace_marks(String subject,Double old_mark,Double new_mark){
        /*The method replace_makrs replace subject-mark in the HashMap object 'subjects'.*/
        subjects.replace(subject, old_mark, new_mark);
    }
    public Set<String> get_subjects(){
        /*The method get_subjects returns a set consisting of all subjects stored in the hashmap object 'subjects'.*/
        return subjects.keySet();
    }
    public Collection<Double> get_marks(){
        /*The method get_subjects returns a collection consisting of all subject's marks stored in the hashmap object 'subjects'.*/
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
