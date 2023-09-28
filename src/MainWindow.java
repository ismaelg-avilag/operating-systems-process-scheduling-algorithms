import javax.swing.*;
import java.util.ArrayList;

public class MainWindow {
    private JButton buttonLoadProcesses;
    private JButton buttonAddProcess;
    private JButton buttonExecute;
    private JRadioButton radioButtonBegin;
    private JRadioButton radioButtonEnd;
    private JRadioButton radioButtonFCFS;
    private JRadioButton RadioButtonSJF;
    private JRadioButton radioButtonPriorities;
    private JRadioButton radioButtonRoundRobin;
    private JSpinner spinnerDuration;
    private JSpinner spinnerPriority;
    private JTextField textFieldProcessName;
    private JTextArea textAreaAlgorithOutput;
    private JTextArea textAreaProcesses;
    private JPanel panelMain;

    ArrayList<Process> processes = new ArrayList<>();

    public MainWindow() {
        ButtonGroup processOrder = new ButtonGroup();
        processOrder.add(radioButtonBegin);
        processOrder.add(radioButtonEnd);

        ButtonGroup algorithmSelection = new ButtonGroup();
        algorithmSelection.add(radioButtonFCFS);
        algorithmSelection.add(RadioButtonSJF);
        algorithmSelection.add(radioButtonPriorities);
        algorithmSelection.add(radioButtonRoundRobin);

        buttonLoadProcesses.addActionListener(e -> {
            FileManager.readProccessesFile("processes.txt", processes);

            for (Process process : processes)
                textAreaProcesses.append(process.toString() + "\n");

            buttonLoadProcesses.setEnabled(false);
        });

        buttonAddProcess.addActionListener(e -> {
            String processName = textFieldProcessName.getText();
            int duration = (int) spinnerDuration.getValue();
            int priority = (int) spinnerPriority.getValue();

            Process p = new Process(processName, duration, priority);

            if(radioButtonBegin.isSelected())
                processes.add(0, p);
            else if(radioButtonEnd.isSelected())
                processes.add(p);

            refreshProcessesTextArea();
            inputReset();
        });

        buttonExecute.addActionListener(e -> {
            textAreaAlgorithOutput.setText("");

            if(radioButtonFCFS.isSelected())
                for (String s : PlanningAlgorithms.FCFS(processes))
                    textAreaAlgorithOutput.append(s + "\n");

            else if(RadioButtonSJF.isSelected())
                for (String s : PlanningAlgorithms.SJF(processes))
                    textAreaAlgorithOutput.append(s + "\n");

            else if(radioButtonPriorities.isSelected())
                for (String s : PlanningAlgorithms.Priorities(processes))
                    textAreaAlgorithOutput.append(s + "\n");

            else if(radioButtonRoundRobin.isSelected())
                for (String s : PlanningAlgorithms.RoundRobin(processes, 3))
                    textAreaAlgorithOutput.append(s + "\n");

        });
    }

    private void refreshProcessesTextArea()
    {
        textAreaProcesses.setText("");

        for (Process process : processes)
            textAreaProcesses.append(process.toString() + "\n");
    }

    private void inputReset() {
        textFieldProcessName.setText("");
        spinnerDuration.setValue(0);
        spinnerPriority.setValue(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Algoritmos de Planificación de Procesos");
        frame.setContentPane(new MainWindow().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

}
