package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class SectionOutput {
    JScrollPane jpOutput = null;
    public DefaultTableModel tableModel;
    public JTable table;
    public String[] column = new String[]{"Simple Random Sampling"};
    int[] columnWidth = new int[]{700};

    public SectionOutput() {
    }

    public JScrollPane getJpOutput() {
        if (jpOutput == null) {
            tableModel = new DefaultTableModel();
            table = new JTable(tableModel);
            jpOutput = new JScrollPane(table);

            jpOutput.setSize(new Dimension(700, 600));
            jpOutput.setLocation(0, 0);
            jpOutput.setBackground(new Color(32, 136, 203));
            jpOutput.setBorder(BorderFactory.createLineBorder(Color.black, 0));

            UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(15, 10, 15, 10));

            DefaultTableCellModify(columnWidth, column);

            table.setBackground(Color.white);
            table.setFont(new Font("Seoge UI", Font.BOLD, 15));
            table.setFocusable(false);
            table.setRowHeight(35);
            table.setSelectionBackground(new Color(32, 136, 203));
            table.setSelectionForeground(new Color(255, 255, 255));
            table.setShowVerticalLines(false);
            table.setIntercellSpacing(new Dimension(0, 0));

            table.getTableHeader().setFont(new Font("Seoge UI", Font.BOLD, 15));
            table.getTableHeader().setOpaque(false);
            table.getTableHeader().setBackground(new Color(32, 136, 203));
            table.getTableHeader().setForeground(new Color(255, 255, 255));
            table.getTableHeader().setBorder(null);
            table.getTableHeader().setReorderingAllowed(true);
            table.getTableHeader().setResizingAllowed(true);
        }
        return jpOutput;
    }

    public void DefaultTableCellModify(int[] columnWidth, String[] column) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < column.length; i++) {
            tableModel.addColumn(column[i]);
        }
        for (int i = 0; i < column.length; i++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(i);
            tableColumn.setPreferredWidth(columnWidth[i]);
            tableColumn.setCellRenderer(centerRenderer);
        }
    }
}
