/**
 * 
 */
package view.viewJFrameMain.MainPanel;

import java.awt.Insets;
import java.awt.print.PrinterException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import view.Constants;
import view.CyFPaletteApp;

/**
 * @author Daniel Felipe Suarez Bohorquez
 * @date 17/05/2021
 */
public class MyJTableInfoTransaction extends JScrollPane {
	
	private static final long serialVersionUID = 1L;
	private JTable jTable;
	private Object[][] info;
	private String[] columnNames;
	public MyJTableInfoTransaction(Object[][] info) {
		super();
		this.info = info;
		this.columnNames = new String[]{
			Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_DATE),
			Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_TYPE_TRANSACTION),
			Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_AMOUNT)
		};
		init();
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(0, 0, 50, 0);
	}
	/**
	 * 
	 */
	private void init() {
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.getVerticalScrollBar().setOpaque(false);
		this.getHorizontalScrollBar().setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		
		DefaultTableCellRenderer cellRendererDate = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void setValue(Object value) {
				setFont(CyFPaletteApp.FONT_CONTENT);
				setForeground(CyFPaletteApp.COLOR_MAIN);
				setBackground(CyFPaletteApp.COLOR_BACKGROUND);
				super.setValue(value);
			}
		};
		cellRendererDate.setHorizontalAlignment(JLabel.CENTER);
		
		DefaultTableCellRenderer cellRendererType = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void setValue(Object value) {
				setFont(CyFPaletteApp.FONT_CONTENT);
				setForeground(CyFPaletteApp.COLOR_MAIN);
				setBackground(CyFPaletteApp.COLOR_BACKGROUND);
				super.setValue(value);
			}
		};
		cellRendererType.setHorizontalAlignment(JLabel.CENTER);
		
		DefaultTableCellRenderer cellRendererMoney = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void setValue(Object value) {
				setFont(CyFPaletteApp.FONT_CONTENT);
				setForeground(CyFPaletteApp.COLOR_MAIN);
				setBackground(CyFPaletteApp.COLOR_BACKGROUND);
				super.setValue("$ "+value);
			}
		};
		cellRendererMoney.setHorizontalAlignment(JLabel.CENTER);
		
		TableModel dataModel = new AbstractTableModel() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public int getColumnCount() {
				return columnNames.length;
			}
			@Override
			public int getRowCount() {
				return info.length;
			}
			@Override
			public Object getValueAt(int row, int col) {
				return info[row][col];
			}
			
			@Override
			public String getColumnName(int column) {
				return columnNames[column];
			}
			@Override
			public Class<? extends Object> getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
			@Override
			public void setValueAt(Object aValue, int row, int column) {
				info[row][column] = aValue;
			}
		};
		
		jTable = new JTable(dataModel);
		jTable.setOpaque(false);
		jTable.setFont(CyFPaletteApp.FONT_CONTENT);
		
		TableColumn dateColumn = jTable.getColumn(Constants.getInstance().getProperty(Constants.MESSAGE_JCOMBOBOX_DATE));
		TableColumn typeColumn = jTable.getColumn(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_TYPE_TRANSACTION));
		TableColumn moneyColumn = jTable.getColumn(Constants.getInstance().getProperty(Constants.MESSAGE_JLABEL_AMOUNT));
		
		dateColumn.setCellRenderer(cellRendererDate);
		typeColumn.setCellRenderer(cellRendererType);
		moneyColumn.setCellRenderer(cellRendererMoney);
		
		jTable.setRowHeight(100);
		
		this.setViewportView(jTable);
	}
	
	/**
	 * Metodo para imprimir la tabla de transacciones bancarias
	 */
	public void printTable() {
		try {
			this.jTable.print();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para filtrar la informacion de la tabla segun el filtro
	 * @param filter
	 * @param selection
	 */
	public void filter(String filter, int selection) {
		TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(jTable.getModel());
		trs.setRowFilter(RowFilter.regexFilter(filter, selection));
		jTable.setRowSorter(trs);
	}
}
