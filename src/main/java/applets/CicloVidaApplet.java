package applets;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class CicloVidaApplet extends JApplet {

	// To store the events/are produced
	List<String> list;

	public void init() {
		list = new ArrayList<String>();
		list.add("To execute init()");

		// To create the GUI
		add(new JLabel(""), BorderLayout.PAGE_START);
		MiPanel panel = new MiPanel();
		add(panel); // By default the panel is placed in the center
		JButton jButton = new JButton("Boton");
		jButton.addActionListener(new buttonListener());
		add(jButton, BorderLayout.PAGE_END);
	}

	public void start() {
		list.add("To execute start()");
	}

	public void stop() {
		list.add("To execute stop()");
	}

	public void destroy() {
		list.add("To execute destroy()");
	}

	class MiPanel extends JPanel {
		MiPanel() {
			super();
		}

		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			for (int i = 10, cont = 0; cont < list.size(); cont++, i = i + 15) {
				graphics.drawString(list.get(cont).toString(), 15, i);
			}
		}
	}

	class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			JOptionPane.showMessageDialog(null,
					"You have pressed the button",
					"Informativ message",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
