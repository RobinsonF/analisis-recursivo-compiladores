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
	private JLabel titleLabel, iconLabel, expressionsLabel, sourceCodeLabel, outputLabel, backLabel, tokenizeAgainIcon,
			tokenizeAgainLabel;
	private TextAreaScroll expressionsScroll, sourceCodeScroll, outPutScroll;
	private TextArea expressions, sourceCode, outPut;

	public ShowPanel() {

		setSize(918, 512);
		setLayout(null);
		setVisible(false);

		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(new Color(22, 22, 22));
		backgroundPanel.setBounds(0, 0, 918, 512);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(23, 69, 23));
		menuPanel.setBounds(0, 0, 902, 473);
		menuPanel.setLayout(null);
		backgroundPanel.add(menuPanel);

		titleLabel = new JLabel("Tokenizer/Parser");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 30));
		titleLabel.setBounds(20, 38, 220, 57);
		menuPanel.add(titleLabel);

		iconLabel = new JLabel("");
		iconLabel.setIcon(
				new ImageIcon(ShowPanel.class.getResource("/co/edu/unbosque/view/icons/regularExpressions.png")));
		iconLabel.setBounds(248, 54, 38, 30);
		menuPanel.add(iconLabel);

		expressionsLabel = new JLabel("Expressions:");
		expressionsLabel.setForeground(Color.WHITE);
		expressionsLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 20));
		expressionsLabel.setBounds(36, 72, 113, 76);
		menuPanel.add(expressionsLabel);

		sourceCodeLabel = new JLabel("Source code:");
		sourceCodeLabel.setForeground(Color.WHITE);
		sourceCodeLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 20));
		sourceCodeLabel.setBounds(338, 38, 113, 76);
		menuPanel.add(sourceCodeLabel);

		outputLabel = new JLabel("Output:");
		outputLabel.setForeground(Color.WHITE);
		outputLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 20));
		outputLabel.setBounds(382, 230, 69, 76);
		menuPanel.add(outputLabel);

		backLabel = new JLabel("");
		backLabel.setIcon(new ImageIcon(ShowPanel.class.getResource("/co/edu/unbosque/view/icons/back.png")));
		backLabel.setBounds(10, 11, 24, 24);
		backLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(backLabel);

		expressionsScroll = new TextAreaScroll();
		expressionsScroll.setBounds(35, 131, 264, 320);
		menuPanel.add(expressionsScroll);
		expressionsScroll.setLabelText("Expressions:");
		expressionsScroll.setFont(new Font("Roboto Thin", Font.PLAIN, 15));
		expressions = new TextArea();
		expressions.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		expressions.setColumns(10);
		expressions.setRows(5);
		expressionsScroll.setViewportView(expressions);

		sourceCodeScroll = new TextAreaScroll();
		sourceCodeScroll.setBounds(461, 11, 431, 217);
		menuPanel.add(sourceCodeScroll);
		sourceCodeScroll.setLabelText("Source code:");
		sourceCodeScroll.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		sourceCode = new TextArea();
		sourceCode.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		sourceCode.setColumns(10);
		sourceCode.setRows(5);
		sourceCodeScroll.setViewportView(sourceCode);

		outPutScroll = new TextAreaScroll();
		outPutScroll.setBounds(461, 239, 431, 212);
		menuPanel.add(outPutScroll);
		outPutScroll.setLabelText("Output:");
		outPutScroll.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		outPut = new TextArea();
		outPut.setFont(new Font("Roboto Thin", Font.PLAIN, 12));
		outPut.setColumns(10);
		outPut.setRows(5);
		outPutScroll.setViewportView(outPut);

		tokenizeAgainIcon = new JLabel("");
		tokenizeAgainIcon.setIcon(new ImageIcon(ShowPanel.class.getResource("/co/edu/unbosque/view/icons/start.png")));
		tokenizeAgainIcon.setBounds(351, 317, 40, 40);
		tokenizeAgainIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(tokenizeAgainIcon);

		tokenizeAgainLabel = new JLabel("Tokenize & parse again");
		tokenizeAgainLabel.setForeground(Color.WHITE);
		tokenizeAgainLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 14));
		tokenizeAgainLabel.setBounds(309, 359, 142, 20);
		tokenizeAgainLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(tokenizeAgainLabel);

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

	public JLabel getOutputLabel() {
		return outputLabel;
	}

	public void setOutputLabel(JLabel outputLabel) {
		this.outputLabel = outputLabel;
	}

	public JLabel getBackLabel() {
		return backLabel;
	}

	public void setBackLabel(JLabel backLabel) {
		this.backLabel = backLabel;
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

	public TextAreaScroll getOutPutScroll() {
		return outPutScroll;
	}

	public void setOutPutScroll(TextAreaScroll outPutScroll) {
		this.outPutScroll = outPutScroll;
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

	public TextArea getOutPut() {
		return outPut;
	}

	public void setOutPut(TextArea outPut) {
		this.outPut = outPut;
	}
}
