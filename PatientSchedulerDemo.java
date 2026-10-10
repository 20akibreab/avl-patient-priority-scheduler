public class PatientSchedulerDemo {
    public static void main(String[] args) {
        PatientScheduler sched = new PatientScheduler();

        sched.addPatient(3, "John");
        sched.addPatient(1, "Maria");
        sched.addPatient(5, "David");
        sched.addPatient(2, "Sarah");
        sched.addPatient(4, "James");

        System.out.println("Patient Schedule:");
        sched.printSchedule();

        System.out.println();
        System.out.println("Highest priority patient: " + sched.getHighestPriorityPatient());

        System.out.println();
        System.out.println("Removing priority 1...");
        sched.removePatient(1);
        sched.printSchedule();

        System.out.println();
        System.out.println("Highest priority patient: " + sched.getHighestPriorityPatient());
    }
}
