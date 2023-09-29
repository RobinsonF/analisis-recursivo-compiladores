package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.view.components.TextArea;
import co.edu.unbosque.view.components.TextAreaScroll;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Box;

public class ShowPanel extends JPanel {

	private JPanel backgroundPanel, menuPanel;
	private JLabel titleLabel, iconLabel, expressionsLabel, sourceCodeLabel, tokenizerOutputLabel, backLabel,
			tokenizeAgainIcon, tokenizeAgainLabel, parserAgainIcon, parserAgainLabel, parserOutputLabel;
	private TextAreaScroll expressionsScroll, sourceCodeScroll, tokenizerOutPutScroll, parserOutPutScroll;
	private TextArea expressions, sourceCode, tokenizerOutPut, parserOutPut;

	public ShowPanel() {

		setSize(1150, 550);
		setLayout(null);
		setVisible(false);

		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(new Color(22, 22, 22));
		backgroundPanel.setBounds(0, 0, 1150, 550);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(23, 69, 23));
		menuPanel.setBounds(0, 0, 1150, 550);
		menuPanel.setLayout(null);
		backgroundPanel.add(menuPanel);

		titleLabel = new JLabel("Tokenizer/Parser");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 30));
		titleLabel.setBounds(48, 0, 220, 57);
		menuPanel.add(titleLabel);

		iconLabel = new JLabel("");
		iconLabel.setIcon(
				new ImageIcon(ShowPanel.class.getResource("/co/edu/unbosque/view/icons/regularExpressions.png")));
		iconLabel.setBounds(274, 11, 38, 30);
		menuPanel.add(iconLabel);

		expressionsLabel = new JLabel("Expressions:");
		expressionsLabel.setForeground(Color.WHITE);
		expressionsLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 15));
		expressionsLabel.setBounds(41, 48, 85, 20);
		menuPanel.add(expressionsLabel);

		sourceCodeLabel = new JLabel("Source code:");
		sourceCodeLabel.setForeground(Color.WHITE);
		sourceCodeLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 15));
		sourceCodeLabel.setBounds(41, 277, 92, 20);
		menuPanel.add(sourceCodeLabel);

		tokenizerOutputLabel = new JLabel("Tokenizer output:");
		tokenizerOutputLabel.setForeground(Color.WHITE);
		tokenizerOutputLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 15));
		tokenizerOutputLabel.setBounds(540, 0, 117, 30);
		menuPanel.add(tokenizerOutputLabel);

		backLabel = new JLabel("");
		backLabel.setIcon(new ImageIcon(ShowPanel.class.getResource("/co/edu/unbosque/view/icons/back.png")));
		backLabel.setBounds(10, 17, 24, 24);
		backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(backLabel);

		expressionsScroll = new TextAreaScroll();
		expressionsScroll.setBounds(42, 79, 298, 193);
		menuPanel.add(expressionsScroll);
		expressionsScroll.setLabelText("Expressions:");
		expressionsScroll.setFont(new Font("Roboto Thin", Font.PLAIN, 15));
		expressions = new TextArea();
		expressions.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		expressions.setColumns(10);
		expressions.setRows(5);
		expressionsScroll.setViewportView(expressions);

		sourceCodeScroll = new TextAreaScroll();
		sourceCodeScroll.setBounds(42, 308, 298, 193);
		menuPanel.add(sourceCodeScroll);
		sourceCodeScroll.setLabelText("Source code:");
		sourceCodeScroll.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		sourceCode = new TextArea();
		sourceCode.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		sourceCode.setColumns(10);
		sourceCode.setRows(5);
		sourceCodeScroll.setViewportView(sourceCode);

		tokenizerOutPutScroll = new TextAreaScroll();
		tokenizerOutPutScroll.setBounds(540, 31, 366, 217);
		menuPanel.add(tokenizerOutPutScroll);
		tokenizerOutPutScroll.setLabelText("Tokenize output:");
		tokenizerOutPutScroll.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		tokenizerOutPut = new TextArea();
		tokenizerOutPut.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		tokenizerOutPut.setColumns(10);
		tokenizerOutPut.setRows(5);
		tokenizerOutPutScroll.setViewportView(tokenizerOutPut);

		tokenizeAgainIcon = new JLabel("");
		tokenizeAgainIcon.setIcon(new ImageIcon(ShowPanel.class.getResource("/co/edu/unbosque/view/icons/start.png")));
		tokenizeAgainIcon.setBounds(988, 113, 40, 40);
		tokenizeAgainIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(tokenizeAgainIcon);

		tokenizeAgainLabel = new JLabel("Tokenize again");
		tokenizeAgainLabel.setForeground(Color.WHITE);
		tokenizeAgainLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 14));
		tokenizeAgainLabel.setBounds(963, 164, 92, 20);
		tokenizeAgainLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(tokenizeAgainLabel);

		parserAgainIcon = new JLabel("");
		parserAgainIcon.setIcon(new ImageIcon(ShowPanel.class.getResource("/co/edu/unbosque/view/icons/start.png")));
		parserAgainIcon.setBounds(988, 342, 40, 40);
		menuPanel.add(parserAgainIcon);

		parserAgainLabel = new JLabel("Parser again");
		parserAgainLabel.setForeground(Color.WHITE);
		parserAgainLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 14));
		parserAgainLabel.setBounds(973, 393, 75, 20);
		menuPanel.add(parserAgainLabel);

		parserOutputLabel = new JLabel("Parser output:");
		parserOutputLabel.setForeground(Color.WHITE);
		parserOutputLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 15));
		parserOutputLabel.setBounds(540, 253, 117, 30);
		menuPanel.add(parserOutputLabel);

		parserOutPutScroll = new TextAreaScroll();
		parserOutPutScroll.setLabelText("Parser output:");
		parserOutPutScroll.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		parserOutPutScroll.setBounds(540, 284, 366, 217);
		menuPanel.add(parserOutPutScroll);
		parserOutPut = new TextArea();
		parserOutPut.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		parserOutPut.setColumns(10);
		parserOutPut.setRows(5);
		parserOutPutScroll.setViewportView(parserOutPut);

	}

	public JPanel getBackgroundPanel() {
		return backgroundPanel;
	}

	public void setBackgroundPanel(JPanel backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
	}

	public JPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(JPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JLabel getIconLabel() {
		return iconLabel;
	}

	public void setIconLabel(JLabel iconLabel) {
		this.iconLabel = iconLabel;
	}

	public JLabel getExpressionsLabel() {
		return expressionsLabel;
	}

	public void setExpressionsLabel(JLabel expressionsLabel) {
		this.expressionsLabel = expressionsLabel;
	}

	public JLabel getSourceCodeLabel() {
		return sourceCodeLabel;
	}

	public void setSourceCodeLabel(JLabel sourceCodeLabel) {
		this.sourceCodeLabel = sourceCodeLabel;
	}

	public JLabel getTokenizerOutputLabel() {
		return tokenizerOutputLabel;
	}

	public void setTokenizerOutputLabel(JLabel tokenizerOutputLabel) {
		this.tokenizerOutputLabel = tokenizerOutputLabel;
	}

	public JLabel getBackLabel() {
		return backLabel;
	}

	public void setBackLabel(JLabel backLabel) {
		this.backLabel = backLabel;
	}

	public JLabel getTokenizeAgainIcon() {
		return tokenizeAgainIcon;
	}

	public void setTokenizeAgainIcon(JLabel tokenizeAgainIcon) {
		this.tokenizeAgainIcon = tokenizeAgainIcon;
	}

	public JLabel getTokenizeAgainLabel() {
		return tokenizeAgainLabel;
	}

	public void setTokenizeAgainLabel(JLabel tokenizeAgainLabel) {
		this.tokenizeAgainLabel = tokenizeAgainLabel;
	}

	public JLabel getParserAgainIcon() {
		return parserAgainIcon;
	}

	public void setParserAgainIcon(JLabel parserAgainIcon) {
		this.parserAgainIcon = parserAgainIcon;
	}

	public JLabel getParserAgainLabel() {
		return parserAgainLabel;
	}

	public void setParserAgainLabel(JLabel parserAgainLabel) {
		this.parserAgainLabel = parserAgainLabel;
	}

	public JLabel getParserOutputLabel() {
		return parserOutputLabel;
	}

	public void setParserOutputLabel(JLabel parserOutputLabel) {
		this.parserOutputLabel = parserOutputLabel;
	}

	public TextAreaScroll getExpressionsScroll() {
		return expressionsScroll;
	}

	public void setExpressionsScroll(TextAreaScroll expressionsScroll) {
		this.expressionsScroll = expressionsScroll;
	}

	public TextAreaScroll getSourceCodeScroll() {
		return sourceCodeScroll;
	}

	public void setSourceCodeScroll(TextAreaScroll sourceCodeScroll) {
		this.sourceCodeScroll = sourceCodeScroll;
	}

	public TextAreaScroll getTokenizerOutPutScroll() {
		return tokenizerOutPutScroll;
	}

	public void setTokenizerOutPutScroll(TextAreaScroll tokenizerOutPutScroll) {
		this.tokenizerOutPutScroll = tokenizerOutPutScroll;
	}

	public TextAreaScroll getParserOutPutScroll() {
		return parserOutPutScroll;
	}

	public void setParserOutPutScroll(TextAreaScroll parserOutPutScroll) {
		this.parserOutPutScroll = parserOutPutScroll;
	}

	public TextArea getExpressions() {
		return expressions;
	}

	public void setExpressions(TextArea expressions) {
		this.expressions = expressions;
	}

	public TextArea getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(TextArea sourceCode) {
		this.sourceCode = sourceCode;
	}

	public TextArea getTokenizerOutPut() {
		return tokenizerOutPut;
	}

	public void setTokenizerOutPut(TextArea tokenizerOutPut) {
		this.tokenizerOutPut = tokenizerOutPut;
	}

	public TextArea getParserOutPut() {
		return parserOutPut;
	}

	public void setParserOutPut(TextArea parserOutPut) {
		this.parserOutPut = parserOutPut;
	}
}
