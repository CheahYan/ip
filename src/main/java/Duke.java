<<<<<<< Updated upstream:src/main/java/Duke.java
=======
package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

>>>>>>> Stashed changes:src/main/java/duke/Duke.java
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

<<<<<<< Updated upstream:src/main/java/Duke.java
=======
    protected static final String LOCAL_FILE = "data/duke.txt";

    public static void appendToFile(String filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath, true); // create a FileWriter in append mode
        fw.write(textToAppend);
        fw.close();
    }

    public static String identifyTask(Task task) throws DukeException {
        if (task instanceof ToDo) {
            return "T";
        } else if (task instanceof Event) {
            return "E";
        } else if (task instanceof Deadline) {
            return "D";
        } else {
            throw new DukeException("Unknown type of task is detected.");
        }
    }
>>>>>>> Stashed changes:src/main/java/duke/Duke.java

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] b = a.split(" ", 2);

<<<<<<< Updated upstream:src/main/java/Duke.java
        ArrayList<Task> history = new ArrayList<Task>();
=======
        ArrayList<Task> history = new ArrayList<>();

        File importedFile = new File(LOCAL_FILE);

        try {
            importedFile.createNewFile();
        } catch (IOException error) {
            System.out.println("Ensure you have created a folder named 'data' within the main project directory!");
        }

        try {
            Scanner fileScanner = new Scanner(importedFile);
            while (fileScanner.hasNext()) {
                String fileData = fileScanner.nextLine();
                String[] details = fileData.split(" ", 2);

                if (details[0].equals("done")) {
                    int taskIndex = Integer.valueOf(details[1]);
                    Task completedTask = history.get(taskIndex - 1);
                    completedTask.Done();

                } else if (details[0].equals("todo")) {
                    ToDo task = new ToDo(details[1]);
                    history.add(task);

                } else if (details[0].equals("deadline")) {
                    String[] c = details[1].split(" /by ", 2);
                    Deadline task = new Deadline(c[0], c[1]);
                    history.add(task);

                } else if (details[0].equals("event")) {
                    String[] c = details[1].split(" /at ", 2);
                    Event task = new Event(c[0], c[1]);
                    history.add(task);

                } else if (details[0].equals("delete")) {
                    int taskIndex = Integer.valueOf(details[1]);
                    Task removed = history.get(taskIndex - 1);

                    history.remove(taskIndex - 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }


>>>>>>> Stashed changes:src/main/java/duke/Duke.java

            while (!a.equals("bye")) {
                try {
                    if (a.equals("list")) {
                        System.out.println("Here are the tasks in your list:");

                        int length = history.size();
                        for (int i = 0; i < length; i++) {
                            System.out.println(String.valueOf(i + 1) + ". " + history.get(i));
                        }
                        a = sc.nextLine();
                        b = a.split(" ", 2);

                    } else if (b[0].equals("done")) {
                        try {
                            int taskIndex = Integer.valueOf(b[1]);
                            history.get(taskIndex - 1).Done();
                            System.out.println("Nice! I have marked this task as done!");
<<<<<<< Updated upstream:src/main/java/Duke.java
                            System.out.println(history.get(taskIndex - 1));
=======
                            System.out.println(completedTask);

                            try {
                                appendToFile(LOCAL_FILE, a + System.lineSeparator());
                            } catch (IOException e) {
                                System.out.println("Something went wrong: " + e.getMessage());
                            }
>>>>>>> Stashed changes:src/main/java/duke/Duke.java

                            a = sc.nextLine();
                            b = a.split(" ", 2);
                        } catch (ArrayIndexOutOfBoundsException error) {
                            System.out.println(":(( sorry bud but which specific task is done?");

                            a = sc.nextLine();
                            b = a.split(" ", 2);
                        }
                    } else if (b[0].equals("todo")) {
                        try {
                            ToDo task = new ToDo(b[1]);
                            history.add(task);
                            int length = history.size();

                            System.out.println("Added task:");
                            System.out.println(task);
<<<<<<< Updated upstream:src/main/java/Duke.java
                            System.out.println("You have " + String.valueOf(length) + " tasks in the list");
=======
                            System.out.println("You have " + length + " tasks in the list");

                            try {
                                appendToFile(LOCAL_FILE, a + System.lineSeparator());
                            } catch (IOException e) {
                                System.out.println("Something went wrong: " + e.getMessage());
                            }
>>>>>>> Stashed changes:src/main/java/duke/Duke.java

                            a = sc.nextLine();
                            b = a.split(" ", 2);
                        } catch (ArrayIndexOutOfBoundsException error) {
                            System.out.println(":(( sorry bud but the description of your todo cannot be empty!");

                            a = sc.nextLine();
                            b = a.split(" ", 2);
                        }
                    } else if (b[0].equals("deadline")) {
                        String[] c = b[1].split(" /by ", 2);
                        Deadline task = new Deadline(c[0], c[1]);
                        history.add(task);
                        int length = history.size();

                        System.out.println("Added task:");
                        System.out.println(task);
                        System.out.println("You have " + String.valueOf(length) + " tasks in the list");

<<<<<<< Updated upstream:src/main/java/Duke.java
=======
                        try {
                            appendToFile(LOCAL_FILE, a + System.lineSeparator());
                        } catch (IOException e) {
                            System.out.println("Something went wrong: " + e.getMessage());
                        }

>>>>>>> Stashed changes:src/main/java/duke/Duke.java
                        a = sc.nextLine();
                        b = a.split(" ", 2);

                    } else if (b[0].equals("event")) {
                        String[] c = b[1].split(" /at ", 2);
                        Event task = new Event(c[0], c[1]);
                        history.add(task);
                        int length = history.size();

                        System.out.println("Added task:");
                        System.out.println(task);
                        System.out.println("You have " + String.valueOf(length) + " tasks in the list");

<<<<<<< Updated upstream:src/main/java/Duke.java
=======
                        try {
                            appendToFile(LOCAL_FILE, a + System.lineSeparator());
                        } catch (IOException e) {
                            System.out.println("Something went wrong: " + e.getMessage());
                        }

>>>>>>> Stashed changes:src/main/java/duke/Duke.java
                        a = sc.nextLine();
                        b = a.split(" ", 2);
                    } else if (b[0].equals("delete")) {
                        int taskIndex = Integer.valueOf(b[1]);
                        Task removed = history.get(taskIndex - 1);

                        history.remove(taskIndex - 1);
                        int length = history.size();

                        System.out.println("Ok! I have removed this task:");
                        System.out.println(removed);
                        System.out.println("Now you have " + String.valueOf(length) + " tasks in the list.");

<<<<<<< Updated upstream:src/main/java/Duke.java
                        a= sc.nextLine();
=======
                        try {
                            appendToFile(LOCAL_FILE, a + System.lineSeparator());
                        } catch (IOException e) {
                            System.out.println("Something went wrong: " + e.getMessage());
                        }

                        a = sc.nextLine();
>>>>>>> Stashed changes:src/main/java/duke/Duke.java
                        b = a.split(" ", 2);
                    } else {
                        throw new DukeException("I do not know what you want to do!");
                    }
                } catch (DukeException error) {
                    System.out.println(error);

                    a = sc.nextLine();
                    b = a.split(" ", 2);
                }
            }
            System.out.println("Bye! Hope to see you again soon!");
            sc.close();

    }
}