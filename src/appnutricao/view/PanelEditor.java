package appnutricao.view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class PanelEditor extends AbstractCellEditor implements TableCellEditor {

    private JPanel painel;
    private JButton btnEditar;
    private JButton btnExcluir;

    public PanelEditor(JTable table) {
        painel = new JPanel(new GridBagLayout());
        btnEditar = new JButton(new ImageIcon("src/images/lapis.png"));
        btnEditar.setToolTipText("Editar");
        btnExcluir = new JButton(new ImageIcon("src/images/lixeira.png"));
        btnExcluir.setToolTipText("Excluir");

        GridBagConstraints posicaoBtnEditar = new GridBagConstraints();
        posicaoBtnEditar.gridx = 0;
        posicaoBtnEditar.gridy = 0;
        posicaoBtnEditar.weightx = 0;
        posicaoBtnEditar.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBtnEditar.anchor = GridBagConstraints.CENTER;
        posicaoBtnEditar.fill = GridBagConstraints.NONE;
        posicaoBtnEditar.insets = new Insets(0, 0, 0,15); // margem superior
        painel.add(btnEditar, posicaoBtnEditar);
        
        GridBagConstraints posicaoBtnExcluir = new GridBagConstraints();
        posicaoBtnExcluir.gridx = 1;
        posicaoBtnExcluir.gridy = 0;
        posicaoBtnExcluir.weightx = 0;
        posicaoBtnExcluir.weighty = 0; // ← isso força ele a ficar no topo
        posicaoBtnExcluir.anchor = GridBagConstraints.CENTER;
        posicaoBtnExcluir.fill = GridBagConstraints.NONE;
        posicaoBtnExcluir.insets = new Insets(0, 0, 0, 0); // margem superior
        painel.add(btnExcluir, posicaoBtnExcluir);

        btnEditar.addActionListener(e -> {
            int row = table.getEditingRow();
            String nome = table.getValueAt(row, 0).toString();
            JOptionPane.showMessageDialog(table, "Editar " + nome);
            fireEditingStopped();
        });

        btnExcluir.addActionListener(e -> {
            int row = table.getEditingRow();
            String nome = table.getValueAt(row, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(table, "Excluir " + nome + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                ((DefaultTableModel) table.getModel()).removeRow(row);
            }

            fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        return painel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}
