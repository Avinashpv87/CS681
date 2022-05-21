package edu.umb.cs681.HW15;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();

        Directory directory1 = new Directory(null, "Root", 12, date);
        Directory directory2 = new Directory(directory1, "Home", 8, date);
        Directory directory3 = new Directory(directory1, "User", 5, date);

        File file1 = new File(directory2, "Main.java", 4, date);
        File file2 = new File(directory2, "Sub File.java", 5, date);
        File file3 = new File(directory2, "User Settings.json", 8, date);

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {

                System.out.println(directory1.getName());
                System.out.println(directory2.getName());
                System.out.println(directory3.getName());

                System.out.println(file1.getName());
                System.out.println(file2.getName());
                System.out.println(file3.getName());

                System.out.println(directory1.getTotalSize());
                System.out.println(directory2.getTotalSize());
                System.out.println(directory3.getTotalSize());

                System.out.println(file1.getParent().getParent().countChildren());
                System.out.println(file3.getParent().getParent().countChildren());
                System.out.println(directory3.getParent().countChildren());
            }));
        }

        for (Thread t : threads) {
            try {
                t.start();
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

}
