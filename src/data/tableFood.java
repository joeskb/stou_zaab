package data;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import appUI.editFood;
import appUI.mainMenu; 
import appUI.styleSetter;

public class tableFood extends styleSetter{
	
	private DefaultTableModel modelFood;
	JTable tFood;
	Connection conn = MyConnect.getConnection();
	String foodID,foodName, foodPrice;
	
	public JTable dataTable() {
		
		tFood = new JTable();
		Object data[][] = {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null}
		};
		String columns[] = {"","��������","�Ҥ�", ""};
		DefaultTableModel tableModel = new DefaultTableModel(data,columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tFood.setModel(tableModel);
		setStyle(tFood);
		
		modelFood = (DefaultTableModel)tFood.getModel();
		showData();
		
		tFood.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int rowClick = tFood.getSelectedRow();
				foodID = tFood.getValueAt(rowClick, 0).toString();
	            foodName = tFood.getValueAt(rowClick, 1).toString();
	            foodPrice = tFood.getValueAt(rowClick, 2).toString();
	            editFood.getData(foodID,foodName,foodPrice);
	            mainMenu.toEditFood();
			}
		});

		return tFood;
		
	}
	
	public void showData() {
		try {
			int totalRow = tFood.getRowCount()-1;
			while(totalRow>-1) {
				modelFood.removeRow(totalRow);
				totalRow--;
			}
			String sql = "SELECT * FROM food";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			int row = 0;
			while(rs.next()) {
				modelFood.addRow(new Object[0]);
				modelFood.setValueAt(rs.getString("food_id"), row, 0);
				modelFood.setValueAt(rs.getString("food_name"), row, 1);
				modelFood.setValueAt(rs.getString("food_cost"), row, 2);
				modelFood.setValueAt("���", row, 3);
				row++;
			}
			tFood.setModel(modelFood);
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	
	

}
