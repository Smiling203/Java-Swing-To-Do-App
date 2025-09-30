import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("To-Do App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");

        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(taskPanel);

        addButton.addActionListener(e -> {
            String taskText = taskField.getText();
            if (!taskText.isEmpty()) {
                JPanel row = new JPanel(new BorderLayout());
                JLabel taskLabel = new JLabel(taskText);
                JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(ev -> {
                    taskPanel.remove(row);
                    taskPanel.revalidate();
                    taskPanel.repaint();
                });
                row.add(taskLabel, BorderLayout.CENTER);
                row.add(deleteButton, BorderLayout.EAST);
                taskPanel.add(row);
                taskPanel.revalidate();
                taskField.setText("");
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
