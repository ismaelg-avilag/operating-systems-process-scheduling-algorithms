import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Process> processesList = FileManager.readProccessesFile("processes.txt");
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        while (option != 5) {
            System.out.println("Ingresa el algoritmo que deseas usar:");
            System.out.println("1. FCFS");
            System.out.println("2. SJF");
            System.out.println("3. Prioridades");
            System.out.println("4. Round Robin");
            System.out.println("5. Salir");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Orden de ejecución con el algoritmo FCFS...");
                    for (String s : PlanningAlgorithms.FCFS(processesList))
                        System.out.println(s);
                }
                case 2 -> {
                    System.out.println("Orden de ejecución con el algoritmo SJF...");
                    for (String s : PlanningAlgorithms.SJF(processesList))
                        System.out.println(s);
                }
                case 3 -> {
                    System.out.println("Orden de ejecución con el algoritmo Prioridades...");
                    for (String s : PlanningAlgorithms.Priorities(processesList))
                        System.out.println(s);
                }
                case 4 -> {
                    System.out.println("Orden de ejecución con el algoritmo Round Robin...");
                    for (String s : PlanningAlgorithms.RoundRobin(processesList, 3)) {
                        System.out.println(s);
                        Thread.sleep(3000);
                    }
                }
                case 5 -> System.out.println("Saliendo...");
            }

            System.out.println("Presiona enter para continuar...");
            scanner.nextLine();
        }

        scanner.close();
        System.out.println("Programa terminado.");
    }

}
