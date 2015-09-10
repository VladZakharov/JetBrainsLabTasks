package task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by vlad on 10.09.15.
 */
public class Sorter implements StudentsSorter {
    @Override
    public void process(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
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
        if (!group.isEmpty() && !student.isEmpty()){
            groups.add(new String(group),new String(student));
        }

        groups.sort();
//        groups.print();

        outputStream.write(groups.toBytes());
        outputStream.close();

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
            for(int i = 0; i < groups.size() - 1; i++)
                for(int j = 0; j < groups.size() - i - 1; j++)
                    if(groups.get(j).size() < groups.get(j + 1).size()){
                        Group temp = groups.get(j);
                        groups.set(j, groups.get(j + 1));
                        groups.set(j + 1, temp);
                    }

            for (Group g : groups)
                g.sortByName();
        }

        void print(){
            for (Group g : groups)
                g.print();
        }

        byte[] toBytes(){
            String result = "";
            for (Group g : groups)
                result += g.asString();
            return result.getBytes();
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

        int size(){
            return students.size();
        }

        void sortByName(){
            Collections.sort(students, String.CASE_INSENSITIVE_ORDER);
        }

        void print(){
            System.out.print(name+": ");
            for (int i = 0; i < students.size()-1; i++)
                System.out.print(students.get(i)+", ");
            System.out.println(students.get(students.size() - 1));
        }

        String asString(){
            String result = "";
            result += (name+": ");
            for (int i = 0; i < students.size()-1; i++)
                result += (students.get(i)+", ");
            result += (students.get(students.size() - 1)+'\n');
            return result;
        }

    }

}
