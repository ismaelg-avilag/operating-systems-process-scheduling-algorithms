import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PlanningAlgorithms {

    public static ArrayList<String> FCFS(ArrayList<Process> processesList)
    {
        ArrayList<String> result = new ArrayList<String>();

        Queue<Process> fcfsQueue = new LinkedList<>();

        for(Process process : processesList)
            fcfsQueue.add(process);

        while(!fcfsQueue.isEmpty())
            result.add(fcfsQueue.poll().getName());

        return result;
    }

    public static ArrayList<String> SJF(ArrayList<Process> processesList)
    {
        ArrayList<String> result = new ArrayList<String>();

        Queue<Process> sjfQueue = new PriorityQueue<>(Process.durationComparator);

        for(Process process : processesList)
            sjfQueue.add(process);

        while(!sjfQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(sjfQueue.peek().getName() + "," + sjfQueue.peek().getDuration());

            result.add(sb.toString());

            sjfQueue.poll();
        }

        return result;
    }

    public static ArrayList<String> Priorities(ArrayList<Process> processesList)
    {
        ArrayList<String> result = new ArrayList<String>();

        Queue<Process> priorityQueue = new PriorityQueue<>(Process.priorityComparator);

        for(Process process : processesList)
            priorityQueue.add(process);

        while(!priorityQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(priorityQueue.peek().getName() + "," + priorityQueue.peek().getPriority());

            result.add(sb.toString());

            priorityQueue.poll();
        }

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
                process.setDuration(process.getDuration() - quantum);

                sb.append(process.getName() + "," + process.getDuration());

                roundRobinQueue.add(process);
                result.add(sb.toString());
            }
            else {
                result.add(process.getName() + ",Proceso Terminado");
            }
        }

        return result;
    }

}
