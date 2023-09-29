package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class PrincipalView extends JFrame {

	private JPanel contentPanel, backgroundPanel, menuPanel, secondMenuPanel, panel1, panel2;
	private JLabel expressIcon, noFileSelected1, fileIcon, noFileSelected2, titleLabel, sourceCodeIcon, subTitleLabel,
			folderIcon, uploadFileButton, uploadExpressionButton, expressionIcon, tokenizeIcon, tokenizeButton,
			cancelIcon, cancelButton;
	private ShowPanel showPanel;

	public PrincipalView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1150, 512);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);

		contentPanel = new JPanel();
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);

		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(new Color(22, 22, 22));
		backgroundPanel.setBounds(0, 0, 1150, 512);
		backgroundPanel.setLayout(null);
		contentPanel.add(backgroundPanel);

		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(23, 69, 23));
		menuPanel.setBounds(0, 0, 1140, 473);
		menuPanel.setLayout(null);
		backgroundPanel.add(menuPanel);

		secondMenuPanel = new JPanel();
		secondMenuPanel.setBackground(new Color(25, 77, 25));
		secondMenuPanel.setBounds(0, 160, 1140, 202);
		menuPanel.add(secondMenuPanel);
		secondMenuPanel.setLayout(null);

		panel1 = new JPanel();
		panel1.setBackground(new Color(51, 153, 51));
		panel1.setBounds(333, 11, 189, 153);
		secondMenuPanel.add(panel1);
		panel1.setLayout(null);

		expressIcon = new JLabel("");
		expressIcon
				.setIcon(new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/noSelected.png")));
		expressIcon.setBounds(43, 28, 100, 100);
		panel1.add(expressIcon);

		noFileSelected1 = new JLabel("No file selected");
		noFileSelected1.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		noFileSelected1.setForeground(new Color(255, 255, 255));
		noFileSelected1.setBounds(333, 175, 179, 14);
		secondMenuPanel.add(noFileSelected1);

		panel2 = new JPanel();
		panel2.setBackground(new Color(51, 153, 51));
		panel2.setBounds(655, 11, 189, 153);
		secondMenuPanel.add(panel2);
		panel2.setLayout(null);

		fileIcon = new JLabel("");
		fileIcon.setIcon(new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/noSelected.png")));
		fileIcon.setBounds(50, 31, 100, 100);
		panel2.add(fileIcon);

		noFileSelected2 = new JLabel("No file selected");
		noFileSelected2.setForeground(Color.WHITE);
		noFileSelected2.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		noFileSelected2.setBounds(655, 175, 189, 14);
		secondMenuPanel.add(noFileSelected2);

		titleLabel = new JLabel("Lexer");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 48));
		titleLabel.setBounds(26, 0, 125, 95);
		menuPanel.add(titleLabel);

		subTitleLabel = new JLabel("Generator");
		subTitleLabel.setForeground(new Color(255, 255, 255));
		subTitleLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 24));
		subTitleLabel.setBounds(144, 17, 110, 76);
		menuPanel.add(subTitleLabel);

		folderIcon = new JLabel("");
		folderIcon.setIcon(new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/folder.png")));
		folderIcon.setBounds(255, 43, 28, 30);
		menuPanel.add(folderIcon);

		sourceCodeIcon = new JLabel("");
		sourceCodeIcon
				.setIcon(new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/uploadFile.png")));
		sourceCodeIcon.setBounds(740, 99, 30, 30);
		sourceCodeIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(sourceCodeIcon);

		uploadFileButton = new JLabel("Upload source code");
		uploadFileButton.setForeground(new Color(255, 255, 255));
		uploadFileButton.setFont(new Font("Roboto Thin", Font.PLAIN, 14));
		uploadFileButton.setBounds(694, 129, 121, 20);
		uploadFileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(uploadFileButton);

		uploadExpressionButton = new JLabel("Upload regular expressions");
		uploadExpressionButton.setForeground(Color.WHITE);
		uploadExpressionButton.setFont(new Font("Roboto Thin", Font.PLAIN, 14));
		uploadExpressionButton.setBounds(348, 129, 174, 20);
		uploadExpressionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(uploadExpressionButton);

		expressionIcon = new JLabel("");
		expressionIcon.setIcon(
				new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/regularExpressions.png")));
		expressionIcon.setBounds(413, 99, 30, 30);
		expressionIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(expressionIcon);

		tokenizeIcon = new JLabel("");
		tokenizeIcon.setIcon(new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/start.png")));
		tokenizeIcon.setBounds(1066, 403, 40, 40);
		tokenizeIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(tokenizeIcon);

		tokenizeButton = new JLabel("Tokenize");
		tokenizeButton.setFont(new Font("Roboto Thin", Font.PLAIN, 14));
		tokenizeButton.setForeground(new Color(255, 255, 255));
		tokenizeButton.setBounds(1057, 442, 73, 20);
		tokenizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(tokenizeButton);

		cancelIcon = new JLabel("");
		cancelIcon.setIcon(new ImageIcon(PrincipalView.class.getResource("/co/edu/unbosque/view/icons/cancel.png")));
		cancelIcon.setBounds(1000, 404, 40, 40);
		cancelIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(cancelIcon);

		cancelButton = new JLabel("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Roboto Thin", Font.PLAIN, 14));
		cancelButton.setBounds(1000, 442, 47, 20);
		cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPanel.add(cancelButton);

		showPanel = new ShowPanel();
		contentPanel.add(showPanel);

	}

	public void warningMessages(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
	}

	public void errorMessages(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void informationMessages(String message) {
		JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
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

	public JPanel getSecondMenuPanel() {
		return secondMenuPanel;
	}

	public void setSecondMenuPanel(JPanel secondMenuPanel) {
		this.secondMenuPanel = secondMenuPanel;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JLabel getExpressIcon() {
		return expressIcon;
	}

	public void setExpressIcon(JLabel expressIcon) {
		this.expressIcon = expressIcon;
	}

	public JLabel getNoFileSelected1() {
		return noFileSelected1;
	}

	public void setNoFileSelected1(JLabel noFileSelected1) {
		this.noFileSelected1 = noFileSelected1;
	}

	public JLabel getFileIcon() {
		return fileIcon;
	}

	public void setFileIcon(JLabel fileIcon) {
		this.fileIcon = fileIcon;
	}

	public JLabel getNoFileSelected2() {
		return noFileSelected2;
	}

	public void setNoFileSelected2(JLabel noFileSelected2) {
		this.noFileSelected2 = noFileSelected2;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JLabel getSourceCodeIcon() {
		return sourceCodeIcon;
	}

	public void setSourceCodeIcon(JLabel sourceCodeIcon) {
		this.sourceCodeIcon = sourceCodeIcon;
	}

	public JLabel getSubTitleLabel() {
		return subTitleLabel;
	}

	public void setSubTitleLabel(JLabel subTitleLabel) {
		this.subTitleLabel = subTitleLabel;
	}

	public JLabel getFolderIcon() {
		return folderIcon;
	}

	public void setFolderIcon(JLabel folderIcon) {
		this.folderIcon = folderIcon;
	}

	public JLabel getUploadFileButton() {
		return uploadFileButton;
	}

	public void setUploadFileButton(JLabel uploadFileButton) {
		this.uploadFileButton = uploadFileButton;
	}

	public JLabel getUploadExpressionButton() {
		return uploadExpressionButton;
	}

	public void setUploadExpressionButton(JLabel uploadExpressionButton) {
		this.uploadExpressionButton = uploadExpressionButton;
	}

	public JLabel getExpressionIcon() {
		return expressionIcon;
	}

	public void setExpressionIcon(JLabel expressionIcon) {
		this.expressionIcon = expressionIcon;
	}

	public JLabel getTokenizeIcon() {
		return tokenizeIcon;
	}

	public void setTokenizeIcon(JLabel tokenizeIcon) {
		this.tokenizeIcon = tokenizeIcon;
	}

	public JLabel getTokenizeButton() {
		return tokenizeButton;
	}

	public void setTokenizeButton(JLabel tokenizeButton) {
		this.tokenizeButton = tokenizeButton;
	}

	public JLabel getCancelIcon() {
		return cancelIcon;
	}

	public void setCancelIcon(JLabel cancelIcon) {
		this.cancelIcon = cancelIcon;
	}

	public JLabel getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JLabel cancelButton) {
		this.cancelButton = cancelButton;
	}

	public ShowPanel getShowPanel() {
		return showPanel;
	}

	public void setShowPanel(ShowPanel showPanel) {
		this.showPanel = showPanel;
	}

}