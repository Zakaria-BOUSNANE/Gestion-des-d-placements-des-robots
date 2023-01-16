import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;

public class MyWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public MyWindow(){
        super("Jeu de Robots");
        this.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        this.setSize(800, 500);
        this.setLocationRelativeTo( null );

        JPanel ContentPane = (JPanel) this.getContentPane();

        ContentPane.add(creatToolBar(), BorderLayout.NORTH);
        ContentPane.add(createWest(), BorderLayout.WEST);
        ContentPane.add(creatRightPanel(), BorderLayout.EAST);
        ContentPane.add(creatStatusBar(), BorderLayout.SOUTH);
        ContentPane.add(CreatTextArea(), BorderLayout.CENTER);
        
        this.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		int ClickedButton = JOptionPane.showConfirmDialog(MyWindow.this, 
        				"Are you sure to quit ?", "", JOptionPane.YES_NO_OPTION);
        		if(ClickedButton == JOptionPane.YES_OPTION) MyWindow.this.dispose();
        	}
		});
        
    }

	
	
	// - - - - - - - - NORTH - - - - - - - - - - 
    private JToolBar creatToolBar(){
        JToolBar toolBar = new JToolBar();

        JButton btnPush = new JButton("push");
        btnPush.addActionListener( this::btnPushListener );

        JButton btnClick = new JButton("Click");
        btnClick.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnClick.setForeground(Color.black);
        	}
        	
        	@Override
        	public void mouseEntered(MouseEvent e) {
				btnClick.setForeground(Color.red);
			}
		});
        
        JCheckBox chkCheck = new JCheckBox("Check");
        JTextField txtEdit = new JTextField("Edit");
        txtEdit.setPreferredSize(new Dimension(140,30));

        toolBar.add(btnPush);
        toolBar.add(btnClick);
        toolBar.add(chkCheck);
        toolBar.add(txtEdit);

        return toolBar;
    }
    // - - - - - - - - - - - - - - - - - - - - -  
    
	// - - - - - - - - WEST - - - - - - - - - - 
    private JScrollPane createWest() {
    	JScrollPane westComponent = new JScrollPane(new JTree());
        westComponent.setPreferredSize(new Dimension(150,0));
        return westComponent;
    }
    // - - - - - - - - - - - - - - - - - - - - -  
    
	// - - - - - - - - EAST - - - - - - - - - - 
    private JPanel creatRightPanel(){
        JPanel panel = new JPanel(new GridLayout(4,1));

        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        panel.add(new JButton("Button 4"));

        return panel;
    }
    // - - - - - - - - - - - - - - - - - - - - - 
    
    // - - - - - - - - SOUTH - - - - - - - - - - 
    private JPanel creatStatusBar(){
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblStatus1 = new JLabel("Message 1");
        lblStatus1.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus1);

        JLabel lblStatus2 = new JLabel("Message 2");
        lblStatus2.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus2);

        JLabel lblStatus3 = new JLabel("Message 3");
        lblStatus3.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus3);

        return statusBar;
    }
    // - - - - - - - - - - - - - - - - - - - - - 
    
    // - - - - - - - - CENTER - - - - - - - - - - 
	private JScrollPane CreatTextArea() {
	    JTextArea txtContent = new JTextArea("The content of this editor");
	    JScrollPane scrContent = new JScrollPane(txtContent);
	    // scrContent.setPreferredSize(new Dimension(100,100));
	    return scrContent;
	}
	// - - - - - - - - - - - - - - - - - - - - - 
    
    

    // Listener functions
    private void btnPushListener(ActionEvent event){
        System.out.println("btnPush clicked");
    }
    

}


// ----------