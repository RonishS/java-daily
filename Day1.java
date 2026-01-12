public class Day1 {
    String taskName;
    int dayNumber;
    int streak; // New attribute!

    public Day1(String name, int day, int streak) {
        this.taskName = name;
        this.dayNumber = day;
        this.streak = streak;
    }

    public void displayProgress() {
        System.out.println("Goal: " + taskName);
        System.out.println("Progress: Day " + dayNumber + " completed!");
        System.out.println("Current Streak: " + streak + " days");
    }

    public static void main(String[] args) {
        // Updated object with streak value
        Day1 today = new Day1("Java Practice", 1, 1);
        today.displayProgress();
    }
}