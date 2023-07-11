import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;

public class application {
    public static void main(String[] args) {

        JLabel digitLengthLabel = new JLabel();
        digitLengthLabel.setText("Zeichenanzahl:");
        digitLengthLabel.setForeground(new Color(0x000000));
        digitLengthLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        digitLengthLabel.setOpaque(false);
        digitLengthLabel.setBounds(30, 32, 130, 22);
        digitLengthLabel.setEnabled(true);
        digitLengthLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        JLabel digitLengthDisplay = new JLabel();
        digitLengthDisplay.setText("15");
        digitLengthDisplay.setForeground(new Color(0x000000));
        digitLengthDisplay.setOpaque(false);
        digitLengthDisplay.setFont(new Font("Arial", Font.BOLD, 28));
        digitLengthDisplay.setBounds(477, 34, 122, 22);
        
        JSlider digitLengthSlider = new JSlider(4, 30, 15);
        digitLengthSlider.setOpaque(false);
        digitLengthSlider.setPaintTicks(false);
        digitLengthSlider.setPaintLabels(false);
        digitLengthSlider.setSnapToTicks(true);
        digitLengthSlider.setEnabled(true);
        digitLengthSlider.setOrientation(JSlider.HORIZONTAL);
        digitLengthSlider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        digitLengthSlider.setBounds(175, 34, 150, 22);
        digitLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent cmd) {
                int sliderValue = digitLengthSlider.getValue();
                digitLengthDisplay.setText(Integer.toString(sliderValue));
                if (sliderValue < 10) {
                    digitLengthDisplay.setBounds(485, 34, 122, 22);
                } else {
                    digitLengthDisplay.setBounds(477, 34, 122, 22);
                }
            }
        });

        JButton incrementDigitLength = new JButton();
        incrementDigitLength.setText("+");
        incrementDigitLength.setFont(new Font("Arial", Font.PLAIN, 20));
        incrementDigitLength.setFocusable(false);
        incrementDigitLength.setForeground(new Color(0x000000));
        incrementDigitLength.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        incrementDigitLength.setBounds(340, 19, 50, 50);
        incrementDigitLength.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent cmd) {
                int currentValue = digitLengthSlider.getValue();
                if (currentValue < 30) {
                    digitLengthSlider.setValue(currentValue + 1);
                }
            }
        });

        JButton decrementDigitLength = new JButton();
        decrementDigitLength.setText("-");
        decrementDigitLength.setFont(new Font("Arial", Font.PLAIN, 20));
        decrementDigitLength.setFocusable(false);
        decrementDigitLength.setForeground(new Color(0x000000));
        decrementDigitLength.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        decrementDigitLength.setBounds(405, 19, 50, 50);
        decrementDigitLength.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent cmd) {
                int currentValue = digitLengthSlider.getValue();
                if (currentValue > 4) {
                    digitLengthSlider.setValue(currentValue - 1);
                }
            }
        });

        JPanel propertiesPanel = new JPanel();
		propertiesPanel.setBackground(new Color(0xFFFFFF));
		propertiesPanel.setBounds(17, 90, 500, 200);
		propertiesPanel.setBorder(BorderFactory.createLineBorder(new Color(0x808080), 1));
		
		JLabel propertiesHeadline = new JLabel();
		propertiesHeadline.setText("Zeicheneigenschaften:");
		propertiesHeadline.setForeground(new Color(0x000000));
		propertiesHeadline.setFont(new Font("Arial", Font.BOLD, 17));
		propertiesHeadline.setBounds((propertiesPanel.getWidth() - 150) / 2, 95, 200, 30);
		
		JCheckBox optionIncludeUppercaseLetters = new JCheckBox();
		optionIncludeUppercaseLetters.setText("Großbuchstaben");
		optionIncludeUppercaseLetters.setBounds(60, 145, 200, 35);
		optionIncludeUppercaseLetters.setFocusable(false);
		optionIncludeUppercaseLetters.setFont(new Font("Arial", Font.PLAIN, 20));
		optionIncludeUppercaseLetters.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		optionIncludeUppercaseLetters.setForeground(new Color(0x000000));
		optionIncludeUppercaseLetters.setBackground(new Color(0xFFFFFF));
		ImageIcon optionsCheckboxSelectedIcon = new ImageIcon("icons/checked_checkbox.png");
		ImageIcon optionsCheckboxDeselectedIcon = new ImageIcon("icons/unchecked_checkbox.png");
		optionIncludeUppercaseLetters.setIcon(optionsCheckboxDeselectedIcon);
		optionIncludeUppercaseLetters.setSelectedIcon(optionsCheckboxSelectedIcon);
		optionIncludeUppercaseLetters.setSelected(true);
		
		JCheckBox optionIncludeLowercaseLetters = new JCheckBox();
		optionIncludeLowercaseLetters.setText("Kleinbuchstaben");
		optionIncludeLowercaseLetters.setBounds(60, 215, 200, 35);
		optionIncludeLowercaseLetters.setFocusable(false);
		optionIncludeLowercaseLetters.setFont(new Font("Arial", Font.PLAIN, 20));
		optionIncludeLowercaseLetters.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		optionIncludeLowercaseLetters.setForeground(new Color(0x000000));
		optionIncludeLowercaseLetters.setBackground(new Color(0xFFFFFF));
		optionIncludeLowercaseLetters.setIcon(optionsCheckboxDeselectedIcon);
		optionIncludeLowercaseLetters.setSelectedIcon(optionsCheckboxSelectedIcon);
        optionIncludeLowercaseLetters.setSelected(true);
		
		JCheckBox optionIncludeIntegers = new JCheckBox();
		optionIncludeIntegers.setText("Zahlen");
		optionIncludeIntegers.setBounds(285, 215, 205, 35);
		optionIncludeIntegers.setFocusable(false);
		optionIncludeIntegers.setFont(new Font("Arial", Font.PLAIN, 20));
		optionIncludeIntegers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		optionIncludeIntegers.setForeground(new Color(0x000000));
		optionIncludeIntegers.setBackground(new Color(0xFFFFFF));
		optionIncludeIntegers.setIcon(optionsCheckboxDeselectedIcon);
		optionIncludeIntegers.setSelectedIcon(optionsCheckboxSelectedIcon);
        optionIncludeIntegers.setSelected(true);
		
		JCheckBox optionIncludeSpecialCharacters = new JCheckBox();
		optionIncludeSpecialCharacters.setText("Sonderzeichen");
		optionIncludeSpecialCharacters.setBounds(285, 145, 225, 35);
		optionIncludeSpecialCharacters.setFocusable(false);
		optionIncludeSpecialCharacters.setFont(new Font("Arial", Font.PLAIN, 20));
		optionIncludeSpecialCharacters.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		optionIncludeSpecialCharacters.setForeground(new Color(0x000000));
		optionIncludeSpecialCharacters.setBackground(new Color(0xFFFFFF));
		optionIncludeSpecialCharacters.setIcon(optionsCheckboxDeselectedIcon);
		optionIncludeSpecialCharacters.setSelectedIcon(optionsCheckboxSelectedIcon);
		
		JPanel passwordOutputArea = new JPanel();
		passwordOutputArea.setBackground(new Color(0xFFFFFF));
		passwordOutputArea.setBounds(17, 350, 500, 100);
		passwordOutputArea.setBorder(BorderFactory.createLineBorder(new Color(0x808080), 1));
		
		JLabel passwordOutputAreaHeadline = new JLabel();
		passwordOutputAreaHeadline.setText("Ausgabe:");
		passwordOutputAreaHeadline.setForeground(new Color(0x000000));
		passwordOutputAreaHeadline.setFont(new Font("Arial", Font.BOLD, 16));
		passwordOutputAreaHeadline.setBounds(225, 355, 200, 30);
		
		JPasswordField passwordOutput = new JPasswordField();
		passwordOutput.setText("Platzhalterpasswort");
		passwordOutput.setBounds(35, 391, 400, 40);
		passwordOutput.setBorder(BorderFactory.createLineBorder(new Color(0x808080), 1));
		passwordOutput.setFont(new Font("Arial", Font.BOLD, 15));
		passwordOutput.setForeground(new Color(0x000000));
		passwordOutput.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		passwordOutput.setEditable(false);
		passwordOutput.setHighlighter(null);
		passwordOutput.setHorizontalAlignment(SwingConstants.CENTER);
		passwordOutput.setEchoChar((char)0);
		
		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(21, 466, 495, 30);
		progressBar.setValue(100);
		progressBar.setStringPainted(true);
		progressBar.setBorderPainted(true);
		progressBar.setString("Halte in Zwischenablage...");
		progressBar.setForeground(new Color(0x006400));
		progressBar.setFont(new Font("Arial", Font.BOLD, 14));
		progressBar.setBorder(BorderFactory.createLineBorder(new Color(0x000000), 1));
		progressBar.setVisible(false);
		
		JButton copyPasswordButton = new JButton();
		copyPasswordButton.setText("kopieren");
		copyPasswordButton.setBounds(192, 303, 150, 35);
		copyPasswordButton.setFocusable(false);
		copyPasswordButton.setFont(new Font("Arial", Font.PLAIN, 18));
		copyPasswordButton.setForeground(new Color(0x000000));
		copyPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		copyPasswordButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent cmd) {
				// create a StringSelection and copy it to the system clipboard
				char[] password = passwordOutput.getPassword();
                String passwordString = new String(password);
                if ( ("Platzhalterpasswort".equals(passwordString)) || ("Kopieren nicht möglich, da 'Platzhalterpasswort' ".equals(passwordString)) ) {
                    passwordOutput.setText("Kopieren nicht möglich, da 'Platzhalterpasswort' ");
                    return;
                }
				StringSelection stringSelection = new StringSelection(new String(password));
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				
				// disable the copy button
				copyPasswordButton.setEnabled(false);
				
				// create and start the progress bar timer
				progressBar.setVisible(true);
				ActionListener progressBarAction = new ActionListener() {
					int i = 100;
					public void actionPerformed(ActionEvent ae) {
						i--;
						progressBar.setValue(i);
						progressBar.setString("Halte in Zwischenablage... " + i + "%");
						if (i <= 0) {
							// enable the copy button and stop the timer
							copyPasswordButton.setEnabled(true);
							((Timer)ae.getSource()).stop();
							progressBar.setVisible(false);
						}
					}
				};
				Timer timer = new Timer(150, progressBarAction);
				timer.start();
				
				// create and start the clear clipboard timer
				Timer clearClipboardTimer = new Timer(15000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent cmd) {
						clipboard.setContents(new StringSelection(""), null);
					}
				});
				clearClipboardTimer.setRepeats(false);
				clearClipboardTimer.start();
			}
		});

		JButton resetEverythingButton = new JButton();
		resetEverythingButton.setText("zurücksetzen");
		resetEverythingButton.setBounds(365, 303, 150, 35);
		resetEverythingButton.setFocusable(false);
		resetEverythingButton.setFont(new Font("Arial", Font.PLAIN, 18));
		resetEverythingButton.setForeground(new Color(0x000000));
		resetEverythingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		resetEverythingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent cmd) {
				digitLengthSlider.setValue(15);
				optionIncludeUppercaseLetters.setSelected(true);
				optionIncludeLowercaseLetters.setSelected(true);
				optionIncludeIntegers.setSelected(true);
				optionIncludeSpecialCharacters.setSelected(false);
				passwordOutput.setText("Platzhalterpasswort");
			}
		});
		
		JButton generatePasswordButton = new JButton();
		generatePasswordButton.setText("generieren");
		generatePasswordButton.setBounds(20, 303, 150, 35);
		generatePasswordButton.setFocusable(false);
		generatePasswordButton.setFont(new Font("Arial", Font.PLAIN, 18));
		generatePasswordButton.setForeground(new Color(0x000000));
		generatePasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generatePasswordButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent cmd) {
				 final String[] UPPERCASE_LETTERS = new String[]{
					"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
					"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
				};
				final String[] LOWERCASE_LETTERS = new String[]{
					"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
					"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
				};
				final String[] INTEGERS = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
				final String[] SPECIAL_CHARS = new String[]{"!", ",", ".", "-", "?", "+", "=", "(", ")", "%", "&", "/", "*", "$", "€", "#"};
				int digitLength = digitLengthSlider.getValue();
				boolean includeUppercase = optionIncludeUppercaseLetters.isSelected();
				boolean includeLowercase = optionIncludeLowercaseLetters.isSelected();
				boolean includeIntegers = optionIncludeIntegers.isSelected();
				boolean includeSpecialChars = optionIncludeSpecialCharacters.isSelected();
				
				ArrayList<String[]> selectedArrays = new ArrayList<String[]>();
				if (includeUppercase) {
					selectedArrays.add(UPPERCASE_LETTERS);
				}
				if (includeLowercase) {
					selectedArrays.add(LOWERCASE_LETTERS);
				}
				if (includeIntegers) {
					selectedArrays.add(INTEGERS);
				}
				if (includeSpecialChars) {
					selectedArrays.add(SPECIAL_CHARS);
				}
				if (selectedArrays.size() == 0) {
					passwordOutput.setText("Bitte mind. 1 Bedingung wählen!");
					return;
				}
				
				StringBuilder password = new StringBuilder();
				Random randomSelector = new Random();
				for (int i = 0; i < digitLength; i++) {
					String[] selectedArray = selectedArrays.get(randomSelector.nextInt(selectedArrays.size()));
					String selectedChar = selectedArray[randomSelector.nextInt(selectedArray.length)];
					password.append(selectedChar);
				}
				passwordOutput.setText(password.toString());
			}
		});
		
		JRadioButton hidePasswordButton = new JRadioButton();
		hidePasswordButton.setBounds(455, 375, 50, 50);
		ImageIcon passwordHiddenIcon = new ImageIcon("icons/icon_password_hidden.png");
		ImageIcon passwordUnhiddenIcon = new ImageIcon("icons/icon_password_unhidden.png");
		hidePasswordButton.setIcon(passwordUnhiddenIcon);
		hidePasswordButton.setSelectedIcon(passwordHiddenIcon);
		hidePasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hidePasswordButton.setBorder(BorderFactory.createLineBorder(new Color(0x808080),1 ));
		hidePasswordButton.setSelected(false);
		hidePasswordButton.addItemListener(cmd -> {
			if (cmd.getStateChange() == ItemEvent.SELECTED) {
				passwordOutput.setEchoChar('*');
			} else {
				passwordOutput.setEchoChar((char)0);
			}
		});

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowWidth = 550;
        int windowHeight = 550;
        int windowXSpawnPos = (screenSize.width - windowWidth) / 2;
        int windowYSpawnPos = (screenSize.height - windowHeight) / 2;
        JFrame windowFrame = new JFrame();
        ImageIcon windowIcon = new ImageIcon("icons/window_icon.png");
        windowFrame.setResizable(false);
        windowFrame.setSize(windowWidth, windowHeight);
        windowFrame.setLocation(windowXSpawnPos, windowYSpawnPos);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setIconImage(windowIcon.getImage());
        windowFrame.getContentPane().setBackground(new Color(0xF5F5F5));
        windowFrame.setTitle("PWGenerate 4");
        windowFrame.add(digitLengthLabel);
        windowFrame.add(digitLengthSlider);
        windowFrame.add(incrementDigitLength);
        windowFrame.add(decrementDigitLength);
        windowFrame.add(digitLengthDisplay);
        windowFrame.add(propertiesHeadline);
        windowFrame.add(optionIncludeUppercaseLetters);
        windowFrame.add(optionIncludeLowercaseLetters);
        windowFrame.add(optionIncludeIntegers);
        windowFrame.add(optionIncludeSpecialCharacters);
        windowFrame.add(generatePasswordButton);
        windowFrame.add(copyPasswordButton);
        windowFrame.add(resetEverythingButton);
        windowFrame.add(passwordOutputAreaHeadline);
        windowFrame.add(passwordOutput);
        windowFrame.add(hidePasswordButton);
        windowFrame.add(passwordOutputArea);
        windowFrame.add(progressBar);
        windowFrame.add(propertiesPanel);
        windowFrame.setLayout(null);
        windowFrame.setVisible(true);
    }
}
