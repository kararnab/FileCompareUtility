package view;

import model.ThemeManager;
import javax.swing.*;
import java.awt.*;
import controller.DragDropController;

public class MainFrame extends JFrame {
    private JPanel dragDropPanel1;
    private JPanel dragDropPanel2;
    private JTextArea resultArea;
    private JButton themeToggleButton;
    private boolean isDarkMode = false;

    public MainFrame() {
        setTitle("Folder Diff Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(800, 600);

        // Top panel with theme toggle
        JPanel topPanel = new JPanel();
        themeToggleButton = new JButton("Toggle Dark/Light Mode");
        themeToggleButton.addActionListener(e -> toggleTheme());
        topPanel.add(themeToggleButton);
        add(topPanel, BorderLayout.NORTH);

        // Center panel with drag-drop areas
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        dragDropPanel1 = createDragDropArea("Drop Folder/Zip 1 Here");
        dragDropPanel2 = createDragDropArea("Drop Folder/Zip 2 Here");

        centerPanel.add(dragDropPanel1);
        centerPanel.add(dragDropPanel2);
        add(centerPanel, BorderLayout.CENTER);

        // Result area
        resultArea = new JTextArea("Diff results will be shown here (Mocked)");
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Drag-drop functionality controller
        new DragDropController(dragDropPanel1, dragDropPanel2, resultArea);

        setVisible(true);
    }

    private JPanel createDragDropArea(String title) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(350, 200));
        return panel;
    }

    private void toggleTheme() {
        if (isDarkMode) {
            ThemeManager.applyLightTheme();
        } else {
            ThemeManager.applyDarkTheme();
        }
        SwingUtilities.updateComponentTreeUI(this);
        isDarkMode = !isDarkMode;
    }
}
