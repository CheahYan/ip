<<<<<<< Updated upstream:src/main/java/Deadline.java
public class Deadline extends Task {
    private String date;
=======
package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDateTime date;
>>>>>>> Stashed changes:src/main/java/duke/Deadline.java

    public Deadline(String description, String date) {
        super(description);

<<<<<<< Updated upstream:src/main/java/Deadline.java
=======
        DateTimeFormatter scanned = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        this.date = LocalDateTime.parse(date, scanned);
    }

>>>>>>> Stashed changes:src/main/java/duke/Deadline.java
    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mma");
        return "[D]" + super.toString() + " (by: " + this.date.format(dateFormat) + ")";
    }
}