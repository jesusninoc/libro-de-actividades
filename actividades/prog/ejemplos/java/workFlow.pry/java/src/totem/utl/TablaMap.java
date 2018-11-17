/*-------------------------------
   Archivo    : TablaMap.java
   F.Creaci�n : 14-05-2003
   F.Ult.Mod. : 14-05-2003
   
-------------------------------*/
package totem.utl;


import javax.swing.table.*; 
import javax.swing.event.TableModelListener; 
import javax.swing.event.TableModelEvent; 


public class TablaMap extends AbstractTableModel implements TableModelListener 
{
   protected TableModel modelo; 

   //M�todos obligados de implementar  
   public int        getRowCount()               {return (modelo==null) ? 0 : modelo.getRowCount();}
   public int        getColumnCount()            {return (modelo==null) ? 0 : modelo.getColumnCount();}
   public Object     getValueAt(int fila, int col) { return modelo.getValueAt(fila, col); }
   
   //�M�todos opcionales?
   public Class      getColumnClass(int col) 	{return modelo.getColumnClass(col); }
   public String     getColumnName(int col)	{return modelo.getColumnName(col); }
   public TableModel getModel()           	{return modelo; }

   public boolean    isCellEditable(int fila, int col) { return modelo.isCellEditable(fila,col);}
   
   public void       setModel(TableModel modelo)  {this.modelo=modelo; modelo.addTableModelListener(this);}
   public void       setValueAt(Object val, int fila, int col) { modelo.setValueAt(val,fila,col); }
   public void       tableChanged(TableModelEvent e) {fireTableChanged(e);}
}