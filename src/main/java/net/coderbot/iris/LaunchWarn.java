package net.coderbot.iris;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URI;

public class LaunchWarn {
	public static void main(String[] args) {
		// TODO: make this translatable
		String message = "This file is the Forge version of Oculus, meant to be installed as a mod. Would you like to get the Forge Installer instead?";
		String fallback = "This file is the Forge version of Oculus, meant to be installed as a mod. Please download the Forge Installer from https://neoforged.net/";
		if (GraphicsEnvironment.isHeadless()) {
			System.err.println(fallback);
		} else {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ReflectiveOperationException | UnsupportedLookAndFeelException ignored) {
				// Ignored
			}

			if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				int option = JOptionPane.showOptionDialog(null, message, "Oculus Installer", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if (option == JOptionPane.YES_OPTION) {
					try {
						Desktop.getDesktop().browse(URI.create("https://neoforged.net"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// Fallback for Linux, etc users with no "default" browser
				JOptionPane.showMessageDialog(null, fallback);
			}
		}

		System.exit(0);
	}
}
