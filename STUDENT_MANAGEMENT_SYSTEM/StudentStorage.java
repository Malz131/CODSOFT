import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentStorage {
   private static ArrayList<SingleStudent> storage;

   public StudentStorage() {
      StudentStorage.storage = new ArrayList<>();
   }
   public void student_adder(SingleStudent var0){
      //Adds a student from the student data textfile.
      reset_storage();
      getdatastorage();
      add_student( var0);
      resetfile();
      storeinfile();
   }

   public void reset(){
      reset_storage();
      resetfile();
   }
   public void student_rmer(SingleStudent var0){
      //Removes a student from the student data textfile.
      getdatastorage();
      rm_student( var0);
      storeinfile();
      reset_storage();
      System.out.println("SUCCESSFULLY REMOVED!!");

   }
   public void search_student(String roll_number){
      //Search for a student from the student data textfile.

      reset_storage();
      getdatastorage();
      for(SingleStudent student : storage){
         if (student.rollnumber.equals(roll_number)){
         System.out.println("FOUND: "+student.rollnumber+"  "+student.fullname+"  "+student.gender+"  "+student.grade);
         return;
         }
      }
      storeinfile();
      System.out.println("FOUND:NONE");
      System.out.println("NO STUDENT WITH THE INPUTED ROLL_NUMBER FOUND.");
   }
   public static void remove_student(String roll_number){
      //Searches and removes a student from textfile
      reset_storage();
      getdatastorage();
      for(SingleStudent student : storage){
         if (student.rollnumber.equals(roll_number)){
         System.out.println("FOUND:Student successfully found.");
            rm_student(student);
            resetfile();
            storeinfile();
         return;
         }
      }
      System.out.println("FOUND:NONE");
      System.out.println("NO STUDENT WITH THE INPUTED ROLL_NUMBER FOUND.");
   }
   public SingleStudent getstudent(String roll_number){
      //Searches and returns a Student from the textfile
      reset_storage();
      getdatastorage();
      SingleStudent no_one=new SingleStudent("none","none","none","none","none");
      for(SingleStudent student : storage){
         if (student.rollnumber.equals(roll_number)){
         System.out.println("FOUND:Student successfully found.");
            resetfile();
            storeinfile();
            return student;
         }
      }
      System.out.println("FOUND:NONE");
      System.out.println("NO STUDENT WITH THE INPUTED ROLL_NUMBER FOUND.");
      return no_one;

   }
   public static void add_student(SingleStudent var0) {
      for (SingleStudent storedstudent : storage){
      if (var0.rollnumber.equals(storedstudent.rollnumber)){
         System.out.println("ERROR:Roll number inputed already exists.");
         return;}}
      
      storage.add(var0);
   }
   public void update_student(SingleStudent var0) {
      getdatastorage();
      for (SingleStudent storedstudent : storage){
      if (var0.rollnumber.equals(storedstudent.rollnumber)){
         storedstudent.fullname=var0.fullname;
         storedstudent.contact_no=var0.contact_no;
         storedstudent.gender=var0.gender;
         storedstudent.grade=var0.grade;
         storeinfile();
         return;}}
      storeinfile();
   }
   public static boolean rm_student(SingleStudent var0) {
      for (SingleStudent storedstudent : storage){
         if (storedstudent.rollnumber.equals(var0.rollnumber)){
            boolean var1 = storage.remove(storedstudent);
            return var1;
         }
      }
      return false;

   }
   public void printStoragedata(){
      //Prints data stored in the textfile on console
      reset_storage();
      getdatastorage();
      System.out.println("DATA STORED:");
      System.out.println("~~~~~~~~~~~~");
      for(SingleStudent student : storage){
         System.out.println(student.rollnumber+"  "+student.fullname+"  "+student.gender+"  "+student.grade);
      }
      storeinfile();
   }
   public static void reset_storage() {
      //resets ArrayList object(storage)
      storage.clear();
   }

   public static void getdatastorage() {
      //get data stored from textfile then stores it in the ArrayList object(storage)
      File var0 = new File("Student_data.txt");
      try ( Scanner scan = new Scanner(var0)) {
         while (scan.hasNext()){ 
               String input=scan.nextLine();
               String[] arr=input.split("   ");
               if (arr.length>1){
               SingleStudent student=new SingleStudent(arr[0],arr[1],arr[2],arr[3],arr[4]);
               add_student(student);}
           }
           scan.close();} 
      catch (FileNotFoundException ex) {
       }
      deletefile();
   }
   public static void storeinfile() {
      //takes data from the ArrayList object then stores it in the text file(if text file doesnt exist it creates it as well)
      try {
          try (BufferedWriter var1 = new BufferedWriter(new FileWriter("Student_data.txt"))) {
              for (SingleStudent student : storage){
                  var1.newLine();
                  var1.write(student.rollnumber+"   "+student.fullname+"   "+student.gender+"   "+student.grade+"   "+student.contact_no);
                  var1.newLine();
              }}

      } catch (IOException e) {
         System.err.println(e.toString());
      }
      //removes everything the ArrayList object (storage)
      reset_storage();

   }
   public static void deletefile(){
      //removes textfile
      File var0 = new File("Student_data.txt");
      var0.delete();
   }
   
   public static void resetfile() {
      //reset the text file
      deletefile();
      File var0 = new File("Student_data.txt");
      try {
         var0.createNewFile();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   // public static void main(String[] var0) {
   //    storeinfile();
   // }
}
    
