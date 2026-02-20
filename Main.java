
import java.io.*;
import java.util.ArrayList;


public class Main {
    static ArrayList<course> courses = new ArrayList<>();


    public static void main(String[] args) {
        readCourseFromCSV("courseAndGradesData.csv");

        // Print courses to verify
        for (course course : courses) {
            System.out.println(course);
        }
     }

     static void readCourseFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int linenumber = 0;


            while ((line = br.readLine()) != null) {
                 linenumber++;
                // Skip first 2 lines
                if (linenumber <=2) {
                    continue;
                }

                
                //read line into a String called line, line looks like this in the file ACTG-04A,937,558,347,98,423
                 String[] parts = line.split(","); String courseName = parts[0]; ArrayList<Integer> grades = new ArrayList<>(); // parts[1] = A count, parts[2] = B count, ... parts[5] = F count
                for (int i = 1; i < parts.length; i++) {
                int count = Integer.parseInt(parts[i].trim());
                grades.add(count);  // index 0 = A, 1 = B, 2 = C, 3 = D, 4 = F
                }// end for loop


                course course = new course(courseName, grades);
                courses.add(course);

            }// end while
        }catch (IOException e){
            System.out.println("Enter reading file: " + e.getMessage());

        }
    }// end readcoursesfromcsv
}// end main