import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JPanel panelMain;
    private JTable tableProcesses;
    private JTable tableAlgorithmOutput;

    ArrayList<Process> processes = new ArrayList<>();

    String[] tableProcessesColumnNames = {"Nombre", "Duración", "Prioridad"};
    DefaultTableModel tableProcesessModel = new DefaultTableModel(tableProcessesColumnNames, 0);

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

            tableProcesses.setModel(tableProcesessModel);

            for (Process process : processes)
                tableProcesessModel.addRow(new Object[]{process.getName(), process.getDuration(), process.getPriority()});

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

            refreshProcessesTable();
            inputReset();
        });

        buttonExecute.addActionListener(e -> {
            if(radioButtonFCFS.isSelected()) {
                String[] FCFSColumnNames = {"Orden de ejecución", "Nombre del proceso"};
                DefaultTableModel tableFCFSModel = new DefaultTableModel(FCFSColumnNames, 0);
                tableAlgorithmOutput.setModel(tableFCFSModel);

                for (String s : PlanningAlgorithms.FCFS(processes))
                    tableFCFSModel.addRow(new Object[]{tableFCFSModel.getRowCount() + 1, s});
            }

            else if(RadioButtonSJF.isSelected()) {
                String[] SJFColumnNames = {"Orden de ejecución", "Nombre del proceso", "Duración"};
                DefaultTableModel tableSJFModel = new DefaultTableModel(SJFColumnNames, 0);
                tableAlgorithmOutput.setModel(tableSJFModel);

                for (String s : PlanningAlgorithms.SJF(processes))
                    tableSJFModel.addRow(new Object[]{tableSJFModel.getRowCount() + 1, s.split(",")[0], s.split(",")[1]});
            }

            else if(radioButtonPriorities.isSelected()) {
                String[] PrioritiesColumnNames = {"Orden de ejecución", "Nombre del proceso", "Prioridad"};
                DefaultTableModel tablePrioritiesModel = new DefaultTableModel(PrioritiesColumnNames, 0);
                tableAlgorithmOutput.setModel(tablePrioritiesModel);

                for (String s : PlanningAlgorithms.Priorities(processes))
                    tablePrioritiesModel.addRow(new Object[]{tablePrioritiesModel.getRowCount() + 1, s.split(",")[0], s.split(",")[1]});
            }

            else if(radioButtonRoundRobin.isSelected()) {
                String[] RoundRobinColumnNames = {"Turno", "Nombre del proceso", "Tiempo restante"};
                DefaultTableModel tableRoundRobinModel = new DefaultTableModel(RoundRobinColumnNames, 0);
                tableAlgorithmOutput.setModel(tableRoundRobinModel);

                for (String s : PlanningAlgorithms.RoundRobin(processes, 3))
                    tableRoundRobinModel.addRow(new Object[]{tableRoundRobinModel.getRowCount() + 1, s.split(",")[0], s.split(",")[1]});
            }
        });

    }

    private void refreshProcessesTable()
    {
        tableProcesessModel.setRowCount(0);
        tableProcesses.setModel(tableProcesessModel);

        for (Process process : processes)
            tableProcesessModel.addRow(new Object[]{process.getName(), process.getDuration(), process.getPriority()});
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
