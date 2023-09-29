package co.edu.unbosque.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;

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
	}
}
