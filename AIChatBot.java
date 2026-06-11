import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class AIChatBot extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    HashMap<String, String> faq = new HashMap<>();

    public AIChatBot() {

        // FAQ Training Data
        faq.put("what is ai", "AI stands for Artificial Intelligence.");
        faq.put("what is java", "Java is a powerful object-oriented programming language.");
        faq.put("what is chatbot", "A chatbot is a software program that communicates with users.");
        faq.put("what is nlp", "NLP means Natural Language Processing.");
        faq.put("what is machine learning", "Machine Learning allows systems to learn from data.");

        // Frame Settings
        setTitle("AI ChatBot"); 
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat Area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input Field
        inputField = new JTextField();

        // Send Button
        sendButton = new JButton("Send");

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        // Add Components
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Action Listeners
        sendButton.addActionListener(this);
        inputField.addActionListener(this);

        // Welcome Message
        chatArea.append("Bot: Hello! I am your AI ChatBot.\n\n");

        setVisible(true);
    }

    // AI Logic
    public String getResponse(String input) {

        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        }

        else if (input.contains("your name")) {
            return "I am an AI ChatBot created using Java.";
        }

        else if (input.contains("bye")) {
            return "Goodbye! Have a great day.";
        }

        else if (input.contains("college")) {
            return "College projects improve practical programming skills.";
        }

        else if (input.contains("internship")) {
            return "Internships help students gain industry experience.";
        }

        // FAQ Matching
        for (String question : faq.keySet()) {

            if (input.contains(question)) {
                return faq.get(question);
            }
        }

        return "Sorry, I don't understand that yet.";
    }

    // Button Action
    @Override
    public void actionPerformed(ActionEvent e) {

        String userText = inputField.getText();

        if (userText.trim().isEmpty()) {
            return;
        }

        chatArea.append("You: " + userText + "\n");

        String response = getResponse(userText);

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    // Main Method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new AIChatBot();
        });
    }
}