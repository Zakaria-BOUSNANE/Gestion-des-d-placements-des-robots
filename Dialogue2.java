import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dialogue2 extends JDialog {
	
	private static final long serialVersionUID = 3996801319419496789L;

	public Dialogue2() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setTitle("Attention");
		this.setLayout(new GridLayout(2,1));
		
		JLabel myJLabel = new JLabel("Vous devez créer un monde");
		Font font = new Font(null,Font.BOLD,14);
		myJLabel.setFont(font);
		myJLabel.setHorizontalAlignment(JLabel.CENTER);

		//JPanel myJPanel = new JPanel();
	
		this.add(myJLabel);
	    JButton okButton = new JButton("OK");
	    JPanel okJPanel = new JPanel();
	    okButton.setPreferredSize(new Dimension(80,30));
	    okJPanel.add(okButton);
	    this.add(okJPanel);
	    okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		} );
	
	}
	
}
