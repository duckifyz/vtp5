package vtp5.gui;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.alee.laf.label.WebLabel;

/*VTP5 Copyright (C) 2015  Abdel-Rahim Abdalla, Minghua Yin, Yousuf Mohamed-Ahmed and Nikunj Paliwal

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class HyperlinkLabel extends WebLabel {
	private static final long serialVersionUID = 1L;

	public HyperlinkLabel(String text, final String link) {
		this.setText("<html><a href=\"" + link + "\">" + text + "</a></html>");
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(new URI(link));
				} catch (URISyntaxException | IOException e1) {
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									null,
									"The following error occurred:\n\n"
											+ e1.toString()
											+ "\n\nThat's really sad :(. This may have happened because you're not connected to the internet. Please report the problem if it keeps happening.",
									"VTP5", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
