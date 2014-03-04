


	import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

	import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

	@SuppressWarnings("unused")
	public class Interface implements ActionListener,ListSelectionListener{
	JTable table=null;
	JPanel panel=new JPanel();
	JPanel panel1=new JPanel();
	JFrame f=new JFrame();
	ListSelectionModel selectionMode=null;
	public int[][] init=new int[9][9];
	String[][] data=new String[9][9];

	public Interface(){
	    
	    String[] name={"","","","","","","","",""};
	    String[][] data=new String[9][9];
	    
	    int value=1;         //initial the table
	    for(int i=0;i<data.length;i++){
	      for (int j=0;j<data.length;j++){
	        data[i][j]="0";
	      }
	    }
	    
	    table=new JTable(data,name);
	    table.setPreferredScrollableViewportSize(new Dimension(250, 250));
	    table.setCellSelectionEnabled(true);//使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数据时以整列为单位.
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.setRowHeight(25);

	    for(int i=0;i<9;i++)
	    {
	    	TableColumn firsetColumn = table.getColumnModel().getColumn(i);
	    	firsetColumn.setPreferredWidth(25);
	    }
	    selectionMode=table.getSelectionModel();//取得table的ListSelectionModel.
	    selectionMode.addListSelectionListener(this);
	    selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
	    JScrollPane s=new JScrollPane(table);
	    
	    JButton b = new JButton("Submit");
	    b.addActionListener(this);
	    panel.add(table);
	    
	   
	    Container contentPane=f.getContentPane();
	    contentPane.add(panel,BorderLayout.NORTH);
	    contentPane.add(b,BorderLayout.SOUTH);
	    contentPane.add(s,BorderLayout.CENTER);
	    

	    f.setTitle("Soduku");
	    f.pack();
	    f.setVisible(true);
	    f.addWindowListener(new WindowAdapter() {
	                        public void windowClosing(WindowEvent e) {
	                          System.exit(0);
	                        }
	                      });
	}
	//Button
	public void actionPerformed(ActionEvent e){
		 if(e.getActionCommand().equals("Submit")){
			 
			 Object c;
			 String t;
			 for(int i=0;i<9;i++)
			 {
				 for(int j=0;j<9;j++)
					 {
					 c=table.getValueAt(i,j); 
	                 t= c.toString();
	                 init[i][j] = Integer.parseInt(t);
					 }
			 }	
			 int[][] B=init;
			 String[] name={"","","","","","","","",""};
			 Soudu_corp s1=new Soudu_corp(B);
			 s1.Init_Seeds();
			 s1.Sorted_List();
			 Seed it=s1.List_Tab.get(s1.List_Order.get(0));
			 s1.Fill_List(it);
			 s1.Afficher_Sys();
			 List<Seed> A=new ArrayList<Seed>();
			 A = s1.getList_Tab();
			 for(int i=0;i<9;i++)
			 {
				 for(int j=0;j<9;j++)
					 {
	                 init[i][j]=A.get(i*9+j).getValue();
	                 data[i][j]=String.valueOf(init[i][j]);
					 }
			 }
			 
			 
			
			if(table.isEditing()){
	            table.getCellEditor().stopCellEditing();
	        } 
			panel.removeAll();; 
			
			table= new JTable(data,name);
			
			 /*********************************************************/
			    table.setPreferredScrollableViewportSize(new Dimension(250, 250));
			    table.setCellSelectionEnabled(true);//使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数据时以整列为单位.
			    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    table.setRowHeight(25);
			    for(int i=0;i<9;i++)
			    {
			    	TableColumn firsetColumn = table.getColumnModel().getColumn(i);
			    	firsetColumn.setPreferredWidth(25);
			    }
			 /*********************************************************/
			    for(int i=0;i<9;i++)
			 {
				 for(int j=0;j<9;j++)
					 if(s1.Is_in( i*9+j))
					 {
						 //s1.Init_T.add(i*9+j);
						 table.setValueAt(changeColor(i,j), i, j); 
					 }
			 }
			 
			   panel.add(table);
			   panel.updateUI();
		 }
	    
	}

	public Object changeColor(int row, int col) {
		
	       return   "<html><font  size=6 color=blue>"+data[row][col]+"</font></html>"; 
	    
	}

	public void valueChanged(ListSelectionEvent el){
	    String tempString="";
	    int[] rows=table.getSelectedRows();
	    int[] columns=table.getSelectedColumns();
	    for (int i=0;i<rows.length;i++){
	      for (int j=0;j<columns.length;j++)
	        tempString = tempString+" "+(String)table.getValueAt(rows[i], columns[j]);
	    }
	}

	public JTable getJTable(){
		return table;
	}
	public static void main(String[] args){
		
		Interface A=new Interface();
	}

	}


