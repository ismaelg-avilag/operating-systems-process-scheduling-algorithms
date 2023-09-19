import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PlanningAlgorithms {

    public static ArrayList<String> FCFS(ArrayList<Process> processesList)
    {
        ArrayList<String> result = new ArrayList<String>();

        for(Process process : processesList)
            result.add(process.getName());

        return result;
    }

    public static ArrayList<String> SJF(ArrayList<Process> processesList)
    {
        ArrayList<String> result = new ArrayList<String>();

        Queue<Process> sjfQueue = new PriorityQueue<>(Process.durationComparator);

        for(Process process : processesList)
            sjfQueue.add(process);

        while(!sjfQueue.isEmpty())
            result.add(sjfQueue.poll().getName());

        return result;
    }

    public static ArrayList<String> Priorities(ArrayList<Process> processesList)
    {
        ArrayList<String> result = new ArrayList<String>();

        Queue<Process> priorityQueue = new PriorityQueue<>(Process.priorityComparator);

        for(Process process : processesList)
            priorityQueue.add(process);

        while(!priorityQueue.isEmpty())
            result.add(priorityQueue.poll().getName());

        return result;
    }

    public static ArrayList<String> RoundRobin(ArrayList<Process> processesList, int quantum)
    {
        ArrayList<String> result = new ArrayList<String>();
        Queue<Process> roundRobinQueue = new LinkedList<>();

        for(Process process : processesList)
            roundRobinQueue.add(process);

        while(!roundRobinQueue.isEmpty()) {
            Process process = roundRobinQueue.poll();
            StringBuilder sb = new StringBuilder();

            if(process.getDuration() > quantum) {
                sb.append(process.getName() + " - Tiempo restante: " + process.getDuration());
                process.setDuration(process.getDuration() - quantum);
                roundRobinQueue.add(process);
                result.add(sb.toString());
            }
            else {
                result.add(process.getName() + " - Proceso Terminado\n");
            }
        }

        return result;
    }

}
