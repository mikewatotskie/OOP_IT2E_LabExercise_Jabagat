import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArithmeticGame extends JFrame implements ActionListener {

    private JLabel leftNumLabel, operatorLabel, rightNumLabel, correctScoreLabel, incorrectScoreLabel;
    private JTextField answerField;
    private JButton submitButton;
    private JRadioButton level1Radio, level2Radio, level3Radio;
    private JCheckBox addBox, subBox, mulBox, divBox, modBox;
    private int correctAnswers = 0, incorrectAnswers = 0, currentAnswer = 0;
    private int minNum = 1, maxNum = 50;
    private String currentOperator = "+";
    private final Random random = new Random();

    public ArithmeticGame() {
        setTitle("Arithmetic Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 900); 
        setLocationRelativeTo(null);

        Color bgColor = new Color(170, 200, 255);   
        Color panelColor = new Color(140, 160, 255); 
        Font mainFont = new Font("Algerian", Font.BOLD, 22); 

        Container content = getContentPane();
        content.setBackground(bgColor);
        content.setLayout(new BorderLayout(25, 25)); 

        JPanel problemPanel = new JPanel(new GridBagLayout());
        problemPanel.setBackground(bgColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        leftNumLabel = makeNumberLabel("0");
        gbc.gridx = 0;
        problemPanel.add(leftNumLabel, gbc);

        operatorLabel = new JLabel("+", SwingConstants.CENTER);
        operatorLabel.setFont(new Font("Algerian", Font.BOLD, 60)); 
        operatorLabel.setForeground(Color.RED);
        gbc.gridx = 1;
        problemPanel.add(operatorLabel, gbc);

        rightNumLabel = makeNumberLabel("0");
        gbc.gridx = 2;
        problemPanel.add(rightNumLabel, gbc);

        JLabel equalLabel = new JLabel("=", SwingConstants.CENTER);
        equalLabel.setFont(new Font("Algerian", Font.BOLD, 60)); 
        equalLabel.setForeground(Color.RED);
        gbc.gridx = 3;
        problemPanel.add(equalLabel, gbc);

        answerField = new JTextField(6);
        answerField.setFont(new Font("Algerian", Font.BOLD, 48)); 
        answerField.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridx = 4;
        problemPanel.add(answerField, gbc);

        submitButton = new JButton("SUBMIT");
        submitButton.setFont(mainFont);
        submitButton.setBackground(new Color(60, 130, 200));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(this);
        gbc.gridx = 5;
        problemPanel.add(submitButton, gbc);

        content.add(problemPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 30, 0));
        bottomPanel.setBackground(bgColor);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));

        JPanel levelOpPanel = new JPanel(new BorderLayout(30, 30));
        levelOpPanel.setBackground(panelColor);
        levelOpPanel.setBorder(BorderFactory.createTitledBorder("Settings"));

        JPanel levelPanel = new JPanel();
        levelPanel.setBackground(panelColor);
        levelPanel.setLayout(new BoxLayout(levelPanel, BoxLayout.Y_AXIS));

        JLabel levelTitle = new JLabel("Level:");
        levelTitle.setFont(mainFont);
        levelPanel.add(levelTitle);

        ButtonGroup levelGroup = new ButtonGroup();
        level1Radio = new JRadioButton("Level 1 (1-50)", true);
        level2Radio = new JRadioButton("Level 2 (51-100)");
        level3Radio = new JRadioButton("Level 3 (101-300)");
        JRadioButton[] levels = {level1Radio, level2Radio, level3Radio};
        for (JRadioButton rb : levels) {
            rb.setBackground(panelColor);
            rb.setFont(new Font("Segoe UI", Font.PLAIN, 20)); 
            rb.addActionListener(this);
            levelGroup.add(rb);
            levelPanel.add(rb);
        }

        JPanel opPanel = new JPanel();
        opPanel.setBackground(panelColor);
        opPanel.setLayout(new BoxLayout(opPanel, BoxLayout.Y_AXIS)); 

        JLabel opTitle = new JLabel("Operations:");
        opTitle.setFont(mainFont);
        opPanel.add(opTitle);

        // Operation checkboxes
        addBox = new JCheckBox("+", true);
        subBox = new JCheckBox("-");
        mulBox = new JCheckBox("*");
        divBox = new JCheckBox("/");
        modBox = new JCheckBox("%");

        JCheckBox[] ops = {addBox, subBox, mulBox, divBox, modBox};
        for (JCheckBox cb : ops) {
            cb.setBackground(panelColor);
            cb.setFont(new Font("Algerian", Font.BOLD, 26)); 
            opPanel.add(cb);
        }

      
        ItemListener singleSelectListener = e -> {
            JCheckBox selected = (JCheckBox) e.getSource();
            if (selected.isSelected()) {
                for (JCheckBox cb : ops) {
                    if (cb != selected) cb.setSelected(false);
                }
                generateProblem();
            }
        };

        for (JCheckBox cb : ops) cb.addItemListener(singleSelectListener);

        levelOpPanel.setLayout(new GridLayout(1, 2, 30, 10));
        levelOpPanel.add(opPanel);
        levelOpPanel.add(levelPanel);

        bottomPanel.add(levelOpPanel);

        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(panelColor);
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
        scorePanel.setBorder(BorderFactory.createTitledBorder("Score"));
        correctScoreLabel = new JLabel("Correct = 0");
        incorrectScoreLabel = new JLabel("Incorrect = 0");
        correctScoreLabel.setFont(new Font("Algerian", Font.BOLD, 26)); 
        incorrectScoreLabel.setFont(new Font("Algerian", Font.BOLD, 26));
        correctScoreLabel.setForeground(new Color(0, 120, 0));
        incorrectScoreLabel.setForeground(Color.RED);
        scorePanel.add(correctScoreLabel);
        scorePanel.add(Box.createVerticalStrut(20));
        scorePanel.add(incorrectScoreLabel);

        bottomPanel.add(scorePanel);

        content.add(bottomPanel, BorderLayout.SOUTH);

        generateProblem();
        setVisible(true);
    }

    private JLabel makeNumberLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Algerian", Font.BOLD, 80));
        label.setOpaque(true);
        label.setBackground(new Color(180, 190, 255));
        label.setPreferredSize(new Dimension(250, 250)); 
        label.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 200), 4));
        return label;
    }

    private void generateProblem() {
        List<String> selectedOps = new ArrayList<>();
        if (addBox.isSelected()) selectedOps.add("+");
        if (subBox.isSelected()) selectedOps.add("-");
        if (mulBox.isSelected()) selectedOps.add("*");
        if (divBox.isSelected()) selectedOps.add("/");
        if (modBox.isSelected()) selectedOps.add("%");

        if (selectedOps.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one operation!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        currentOperator = selectedOps.get(random.nextInt(selectedOps.size()));
        int a = random.nextInt(maxNum - minNum + 1) + minNum;
        int b = random.nextInt(maxNum - minNum + 1) + minNum;

        switch (currentOperator) {
            case "/":
                while (b == 0 || a % b != 0) {
                    a = random.nextInt(maxNum - minNum + 1) + minNum;
                    b = random.nextInt(maxNum - minNum + 1) + minNum;
                }
                currentAnswer = a / b;
                break;
            case "-":
                if (a < b) { int t = a; a = b; b = t; }
                currentAnswer = a - b;
                break;
            case "+":
                currentAnswer = a + b;
                break;
            case "*":
                currentAnswer = a * b;
                break;
            case "%":
                while (b == 0) b = random.nextInt(maxNum - minNum + 1) + minNum;
                currentAnswer = a % b;
                break;
        }

        leftNumLabel.setText(String.valueOf(a));
        rightNumLabel.setText(String.valueOf(b));
        operatorLabel.setText(currentOperator);
        answerField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) checkAnswer();
        else if (src == level1Radio) setLevel(1, 50);
        else if (src == level2Radio) setLevel(51, 100);
        else if (src == level3Radio) setLevel(101, 300);
    }

    private void setLevel(int min, int max) {
        this.minNum = min;
        this.maxNum = max;
        generateProblem();
    }

    private void checkAnswer() {
        String input = answerField.getText().trim();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an answer!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            BigInteger userAnswer = new BigInteger(input);
            BigInteger correct = BigInteger.valueOf(currentAnswer);

            if (userAnswer.equals(correct)) {
                correctAnswers++;
                correctScoreLabel.setText("Correct = " + correctAnswers);
                JOptionPane.showMessageDialog(this, "Correct!", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                incorrectAnswers++;
                incorrectScoreLabel.setText("Incorrect = " + incorrectAnswers);
                JOptionPane.showMessageDialog(this, "Incorrect! The answer was " + currentAnswer, "Result", JOptionPane.ERROR_MESSAGE);
            }

            generateProblem();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArithmeticGame::new);
    }
}
