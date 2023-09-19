import java.util.Comparator;

public class Process {

    private String name;
    private int duration;
    private int priority;

    public Process() {}

    public Process(String name, int duration, int priority)
    {
        this.name = name;
        this.duration = duration;
        this.priority = priority;
    }

    public String getName() { return name; }
    public int getDuration() { return duration; }
    public int getPriority() { return priority; }

    public void setName(String name) { this.name = name; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setPriority(int priority) { this.priority = priority; }


    public static Comparator<Process> durationComparator = new Comparator<Process>() {
        @Override
        public int compare(Process process1, Process process2) {
            int durationComparator =  Integer.compare(process1.getDuration(), process2.getDuration());

            if(durationComparator == 0)
                return Integer.compare(process1.getPriority(), process2.getPriority());

            return durationComparator;
        }
    };

    public static Comparator<Process> priorityComparator = new Comparator<Process>() {
        @Override
        public int compare(Process process1, Process process2) {
            int priorityComparator =  Integer.compare(process1.getPriority(), process2.getPriority());

            if(priorityComparator == 0)
                return Integer.compare(process1.getDuration(), process2.getDuration());

            return priorityComparator;
        }
    };


}
