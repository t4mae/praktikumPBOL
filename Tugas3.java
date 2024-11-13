import javax.swing.*;
import java.awt.*;

public class Tugas3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login & Sign Up");
        CardLayout cardLayout = new CardLayout();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(cardLayout);

        JPanel signUpPanel = createFormPanel("SIGN UP", "Sign Up", e -> cardLayout.show(frame.getContentPane(), "Login"), "Already have an account?", "Login", Color.WHITE);

        JPanel loginPanel = createFormPanel("LOGIN", "Login", e -> cardLayout.show(frame.getContentPane(), "Sign Up"), "Don't have an account?", "Sign Up", Color.WHITE);

        frame.add(signUpPanel, "Sign Up");
        frame.add(loginPanel, "Login");

        frame.setVisible(true);
    }

    private static JPanel createFormPanel(String titleText, String buttonText, java.awt.event.ActionListener switchListener, String switchLabel, String switchButtonText, Color switchButtonColor) {
        JPanel panel = new JPanel(new BorderLayout());

        // Judul
        JLabel title = new JLabel(titleText, JLabel.CENTER);
        title.setFont(new Font(null, Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        // Konten Form
        JPanel formContent = new JPanel();
        formContent.setLayout(new BoxLayout(formContent, BoxLayout.Y_AXIS));
        formContent.setAlignmentX(Component.CENTER_ALIGNMENT);

        formContent.add(createLabeledField("Email", new JTextField()));
        formContent.add(createLabeledField("Password", new JPasswordField()));

        JButton actionButton = new JButton(buttonText);
        actionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        actionButton.setBackground(new Color(0, 102, 204));
        actionButton.setForeground(Color.WHITE);
        formContent.add(Box.createRigidArea(new Dimension(0, 20)));
        formContent.add(actionButton);

        panel.add(formContent, BorderLayout.CENTER);

        // Footer
        JPanel footer = new JPanel();
        footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel switchLabelText = new JLabel(switchLabel);
        switchLabelText.setAlignmentX(Component.CENTER_ALIGNMENT);
        footer.add(switchLabelText);

        JButton switchButton = new JButton(switchButtonText);
        switchButton.setForeground(Color.WHITE);
        switchButton.setBackground(new Color(0, 102, 204));
        switchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        switchButton.addActionListener(switchListener);
        footer.add(switchButton);

        panel.add(footer, BorderLayout.SOUTH);

        return panel;
    }

    private static JPanel createLabeledField(String labelText, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        field.setMaximumSize(new Dimension(250, 30));
        panel.add(label);
        panel.add(field);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        return panel;
    }
}
