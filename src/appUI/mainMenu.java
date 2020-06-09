package appUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class mainMenu  extends styleSetter implements ActionListener{
	
	private JFrame frame = new JFrame("STOU ZAAB : In-house Operation App");
	
	JButton btnMainMenu, btnMainMenu2;
	JPanel topMenu;

	static JPanel mainBody;
	JTable tFood;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu window = new mainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public mainMenu() {
		frame.setBounds(100, 50, 395, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*topMenu*/
		topMenu = new JPanel();
		setPanel(topMenu,0, 0, 375, 80,colorRed1,frame);
		setLabel ("STOU ZAAB", "h3",20, 40, 200, 24,colorWhite, topMenu);
		
		btnMainMenu = new JButton("������ѡ");
		setButton(btnMainMenu,264, 30, 100, 40,colorRed1,colorWhite,topMenu);
		btnMainMenu.addActionListener(this);
		
		/*mainBody*/
		mainBody = new JPanel();
		setPanel(mainBody,0,80,375,587,colorWhite,frame);
		pageHome pHome = new pageHome();
		mainBody.add(pHome.setPage());
		
	} //END mainMenu
	
	public void toHome() {
		mainBody.removeAll();
		pageHome pHome = new pageHome();
		mainBody.add(pHome.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toFood() {
		mainBody.removeAll();
		pageFood pFood = new pageFood();
		mainBody.add(pFood.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toEditFood() {
		mainBody.removeAll();
		editFood eFood = new editFood();
		mainBody.add(eFood.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public static void toCustomer() {
		mainBody.removeAll();
		pageCustomer pCust = new pageCustomer();
		mainBody.add(pCust.setPage());
		mainBody.revalidate();
		mainBody.repaint();
	}
	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == btnMainMenu) {
			toHome();
		}
	};
	
}


