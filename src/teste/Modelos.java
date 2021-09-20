package teste;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



public class Modelos extends AbstractTableModel{

	private ArrayList<Estudante> list;
	private String[] cabecalho = {"Nome", "Endereço", "Matricula", "Sexo"};
	
	public Modelos(ArrayList<Estudante> list) {
		this.list = list;
	}
	public String getColumnName(int col) {
		return cabecalho[col];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Estudante estudante = list.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return estudante.getNome();
			case 1: 
				return estudante.getEndereco();
			case 2: 
				return estudante.getMatricula();
			case 3: 
				return estudante.getSexo();
			default:
				return null;
		}
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}
	
	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}
	
       @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Estudante s = list.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    if (aValue instanceof String) {
                        s.setNome(aValue.toString());
                    }
                    break;
                case 1:
                    if (aValue instanceof String) {
                        s.setEndereco(aValue.toString());
                    }
                    break;
                case 2:
                    if (aValue instanceof String) {
                    	s.setMatricula(Integer.parseInt(aValue.toString()));
                    }
                    break;
                case 3:
                    if (aValue instanceof String) {
                    	s.setSexo(aValue.toString().charAt(0));
                    }
                    break;
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        }

}
