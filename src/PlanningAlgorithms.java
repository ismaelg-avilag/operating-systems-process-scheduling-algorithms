import java.util.ArrayList;

public class PlanningAlgorithms {

    public static ArrayList<String> FCFS(ArrayList<Process> processesList)
    {
        ArrayList<String> result = new ArrayList<String>();

        for(Process process : processesList)
            result.add(process.getName());

        return result;
    }

}
