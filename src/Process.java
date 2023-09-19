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


}
