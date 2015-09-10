package task2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by vlad on 10.09.15.
 */
public class Sorter implements StudentsSorter {
    @Override
    public void process(InputStream inputstream, OutputStream output) throws IOException {
//        System.out.println(inputstream.available());
        byte[] bytes = new byte[inputstream.available()];
        int data = inputstream.read(bytes);
        inputstream.close();
//        System.out.println(new String(bytes));
        char[] charArray = new String(bytes).toCharArray();

        Groups groups = new Groups();
        String student = new String("");
        String group = new String("");
        boolean readStudent = true;
        for (char c : charArray) {
            if (readStudent){
                if (c != ':') student += c;
                else readStudent = !readStudent;
            } else {
                if (c != '\n') group += c;
                else {
                    groups.add(new String(group),new String(student));
                    student = "";
                    group = "";
                    readStudent = !readStudent;
                }
            }
        }

        groups.print();

    }

    class Groups {

        private ArrayList<Group> groups = null;

        Groups(){
            groups = new ArrayList<>();
        }

        void add(String groupName, String studentName){
            for (Group g : groups)
                if (g.name().equals(groupName)) {
                    g.add(studentName);
                    return;
                }

            groups.add(new Group(groupName));
            groups.get(groups.size()-1).add(studentName);
        }

        void sort(){
            
        }

        void print(){
            for (Group g : groups)
                g.print();
        }

    }

    class Group {

        private String name = null;
        private ArrayList<String> students = null;

        Group(String name){
            this.name = name;
            students = new ArrayList<>();
        }

        void add(String student){
            students.add(student);
        }

        String name(){
            return name;
        }

        void print(){
            System.out.print(name+": ");
            for (int i = 0; i < students.size()-1; i++)
                System.out.print(students.get(i)+", ");
            System.out.println(students.get(students.size()-1));
        }

    }

}
