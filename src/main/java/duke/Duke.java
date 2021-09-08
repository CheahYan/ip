package duke;

import java.util.Scanner;

/**
 * Represents a Duke chatbot. It helps to collate tasks for the user.
 */
public class Duke {

    private static final String LOCAL_FILE = "data/duke.txt";

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Class constructor that constructs a Duke object.
     *
     * @param filePath File Path for Storage to obtain saved data. If data does not exist, a new file will be created
     *                 with that filePath.
     */
    public Duke(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            this.tasks = storage.load();
        } catch (DukeException e) {
            ui.showError(e);
        }
    }

    /**
     * Runs Duke object. Follows the commands scanned by the Scanner. Ends when "bye" command is detected.
     */
    public void run() {
        this.ui.welcome();

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser(sc.nextLine());


        while (!parser.isBye()) {
            try {
                if (parser.isList()) {
                    ui.list(this.tasks);

                    parser = new Parser(sc.nextLine());
                } else if (parser.isDone()) {
                    try {
                        this.tasks.done(parser.secondPartInInt());
                        this.storage.save(parser.getCommand());
                        ui.done(this.tasks.getMostRecent());

                        parser = new Parser(sc.nextLine());
                    } catch (DukeException e) {
                        ui.showError(e);

                        parser = new Parser(sc.nextLine());
                    }
                } else if (parser.isToDo()) {
                    ToDo task;
                    try {
                        task = new ToDo(parser.secondPart());
                        this.tasks.add(task);
                        this.storage.save(parser.getCommand());
                        ui.addTask(this.tasks.getMostRecent(), this.tasks);

                        parser = new Parser(sc.nextLine());
                    } catch (DukeException e) {
                        ui.showError(e);

                        parser = new Parser(sc.nextLine());
                    }
                } else if (parser.isDeadline()) {
                    Deadline task;
                    try {
                        task = new Deadline(parser.deadline()[0], parser.deadline()[1]);
                        this.tasks.add(task);
                        this.storage.save(parser.getCommand());
                        ui.addTask(this.tasks.getMostRecent(), this.tasks);

                        parser = new Parser(sc.nextLine());
                    } catch (DukeException e) {
                        ui.showError(e);

                        parser = new Parser(sc.nextLine());
                    }
                } else if (parser.isEvent()) {
                    Event task;
                    try {
                        task = new Event(parser.event()[0], parser.event()[1]);
                        this.tasks.add(task);
                        this.storage.save(parser.getCommand());
                        ui.addTask(this.tasks.getMostRecent(), this.tasks);

                        parser = new Parser(sc.nextLine());
                    } catch (DukeException e) {
                        ui.showError(e);

                        parser = new Parser(sc.nextLine());
                    }
                } else if (parser.isDelete()) {
                    try {
                        this.tasks.delete(parser.secondPartInInt());
                        ui.deleteTask(this.tasks.getMostRecent(), this.tasks);

                        parser = new Parser(sc.nextLine());
                    } catch (DukeException e) {
                        ui.showError(e);

                        parser = new Parser(sc.nextLine());
                    }
                } else {
                    throw new DukeException("I do not know what you want to do!");
                }
            } catch (DukeException e) {
                ui.showError(e);

                parser = new Parser(sc.nextLine());
            }
        }

        ui.bye();
        sc.close();
    }

    public static void main(String[] args) {
        new Duke(LOCAL_FILE).run();

    }
}
