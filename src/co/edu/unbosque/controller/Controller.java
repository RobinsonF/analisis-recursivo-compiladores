package co.edu.unbosque.controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import co.edu.unbosque.model.LexerException;
import co.edu.unbosque.model.Parser;
import co.edu.unbosque.model.ParserException;
import co.edu.unbosque.model.Token;
import co.edu.unbosque.model.Tokenizer;

import co.edu.unbosque.view.FileChooserManager;
import co.edu.unbosque.view.PrincipalView;

public class Controller {

	private PrincipalView principalView;
	private FileChooserManager fileChooserManager;
	private boolean parametersFileLoaded;
	private boolean sourceCodeFileLoaded;
	private File parametersFile;
	private File sourceCodeFile;

	public Controller() throws Exception {
		principalView = new PrincipalView();
		fileChooserManager = new FileChooserManager();
		handleLabelClick();
	}

	public void handleLabelClick() {
		MouseListener uploadParameters = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parametersFile = fileChooserManager.getSelectedTextFile();
				if (parametersFile != null) {
					principalView.informationMessages("The user has selected the file: " + parametersFile.getName());
					principalView.getExpressIcon().setIcon(null);
					principalView.getExpressIcon().setIcon(
							new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/selected.png")));
					principalView.getNoFileSelected1().setText("File selected: " + parametersFile.getName());

					parametersFileLoaded = true;
				} else {
					principalView.warningMessages("The user has not selected any file");
				}
			}
		};

		MouseListener uploadSourceCodeListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sourceCodeFile = fileChooserManager.getSelectedReadableFile();
				if (sourceCodeFile != null) {
					principalView.informationMessages("The user has selected the file: " + sourceCodeFile.getName());
					principalView.getFileIcon().setIcon(null);
					principalView.getFileIcon().setIcon(
							new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/selected.png")));
					principalView.getNoFileSelected2().setText("File selected: " + sourceCodeFile.getName());

					sourceCodeFileLoaded = true;
				} else {
					principalView.warningMessages("The user has not selected any file");
				}
			}
		};

		MouseListener cancel = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				principalView.getExpressIcon().setIcon(null);
				principalView.getExpressIcon().setIcon(
						new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/noSelected.png")));
				principalView.getNoFileSelected1().setText("No file selected");
				parametersFileLoaded = false;
				principalView.getFileIcon().setIcon(null);
				principalView.getFileIcon().setIcon(
						new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/noSelected.png")));
				principalView.getNoFileSelected2().setText("No file selected");
				sourceCodeFileLoaded = false;

				principalView.informationMessages("The files were cancelled");
			}
		};

		MouseListener tokenizer = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (parametersFileLoaded && sourceCodeFileLoaded) {
					try {
						String parametersContent = new String(Files.readAllBytes(parametersFile.toPath()));
						principalView.getShowPanel().getExpressions().setText(parametersContent);

						String sourceCodeContent = new String(Files.readAllBytes(sourceCodeFile.toPath()));
						principalView.getShowPanel().getSourceCode().setText(sourceCodeContent);

						String rulesContent = principalView.getShowPanel().getExpressions().getText();
						String codeToTokenize = principalView.getShowPanel().getSourceCode().getText();

						Tokenizer tokenizer = new Tokenizer();

						String[] ruleLines = rulesContent.split("\n");
						for (String ruleLine : ruleLines) {
							String[] parts = ruleLine.trim().split("\\s+", 2);
							if (parts.length == 2) {
								String patternStr = parts[0];
								int tokenType = Integer.parseInt(parts[1]);

								tokenizer.add(patternStr, tokenType);
							}
						}

						try {
							LinkedList<Token> tokens = tokenizer.tokenize(codeToTokenize);

							StringBuilder tokenOutput = new StringBuilder();
							for (Token token : tokens) {
								tokenOutput.append("Token: ").append(token.getType()).append(" - Lexeme: ")
										.append(token.getLexeme()).append(" - Position: ").append(token.getPosition())
										.append("\n");
							}
							principalView.getShowPanel().getTokenizerOutPut().setText("");
							principalView.getShowPanel().getTokenizerOutPut().append(tokenOutput.toString());

						} catch (LexerException lexEx) {
							principalView.getShowPanel().getTokenizerOutPut().setText("");
							principalView.errorMessages("Tokenization error:\n" + lexEx.getMessage());

						}

					} catch (IOException ex) {
						ex.printStackTrace();
					}

					principalView.getBackgroundPanel().setVisible(false);
					principalView.getShowPanel().setVisible(true);
				} else {
					principalView.warningMessages("Both files must be loaded before proceeding");
				}
			}
		};

		MouseListener tokenizerAgain = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (parametersFileLoaded && sourceCodeFileLoaded) {

					String rulesContent = principalView.getShowPanel().getExpressions().getText();
					String codeToTokenize = principalView.getShowPanel().getSourceCode().getText();

					Tokenizer tokenizer = new Tokenizer();

					String[] ruleLines = rulesContent.split("\n");
					for (String ruleLine : ruleLines) {
						String[] parts = ruleLine.trim().split("\\s+", 2);
						if (parts.length == 2) {
							String patternStr = parts[0];
							int tokenType = Integer.parseInt(parts[1]);

							tokenizer.add(patternStr, tokenType);
						}
					}

					try {
						LinkedList<Token> tokens = tokenizer.tokenize(codeToTokenize);

						StringBuilder tokenOutput = new StringBuilder();
						for (Token token : tokens) {
							tokenOutput.append("Token: ").append(token.getType()).append(" - Lexeme: ")
									.append(token.getLexeme()).append(" - Position: ").append(token.getPosition())
									.append("\n");
						}
						principalView.getShowPanel().getTokenizerOutPut().setText("");
						principalView.getShowPanel().getTokenizerOutPut().append(tokenOutput.toString());

					} catch (LexerException lexEx) {
						principalView.getShowPanel().getTokenizerOutPut().setText("");
						principalView.errorMessages("Tokenization error:\n" + lexEx.getMessage());

					}

					principalView.getBackgroundPanel().setVisible(false);
					principalView.getShowPanel().setVisible(true);
				} else {
					principalView.warningMessages("Both files must be loaded before proceeding");
				}
			}
		};

		MouseListener back = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				principalView.getShowPanel().setVisible(false);
				principalView.getShowPanel().getExpressions().setText("");
				principalView.getShowPanel().getSourceCode().setText("");
				principalView.getShowPanel().getTokenizerOutPut().setText("");
				principalView.getShowPanel().getParserOutPut().setText("");
				principalView.getBackgroundPanel().setVisible(true);

			}
		};

		principalView.getExpressionIcon().addMouseListener(uploadParameters);
		principalView.getUploadExpressionButton().addMouseListener(uploadSourceCodeListener);
		principalView.getSourceCodeIcon().addMouseListener(uploadSourceCodeListener);
		principalView.getUploadFileButton().addMouseListener(uploadSourceCodeListener);
		principalView.getCancelIcon().addMouseListener(cancel);
		principalView.getCancelButton().addMouseListener(cancel);
		principalView.getTokenizeIcon().addMouseListener(tokenizer);
		principalView.getTokenizeButton().addMouseListener(tokenizer);
		principalView.getShowPanel().getTokenizeAgainIcon().addMouseListener(tokenizerAgain);
		principalView.getShowPanel().getTokenizeAgainLabel().addMouseListener(tokenizerAgain);
		principalView.getShowPanel().getBackLabel().addMouseListener(back);

	}
}
