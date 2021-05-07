package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SectionInput {
    private MainGui mainGui;
    JPanel jpInput = null;
    JTextField txtDataX = null, txtDataY = null, txtDataN = null;
    JComboBox cbOperation = null;
    JButton btnExit = null, btnCalculate = null, btnAdd = null;
    SpringLayout springLayout = new SpringLayout();
    String[] operationList = new String[]{"Simple Random Sampling", "Systematic Random Sampling", "Simple Series", "Frequency Series", "Frequency Table", "Central Tendency Standard", "Distribution Standard"};
    public ArrayList<Double> entry = new ArrayList<Double>();

    Color btnDefault = new Color(59, 89, 182);

    public SectionInput(MainGui mainGui) {
        entry.add(520.0);
        entry.add(660.0);
        entry.add(740.0);
        entry.add(800.0);
        entry.add(840.0);
        entry.add(930.0);
        entry.add(570.0);
        entry.add(685.0);
        entry.add(760.0);
        entry.add(810.0);
        entry.add(850.0);
        entry.add(940.0);
        entry.add(595.0);
        entry.add(710.0);
        entry.add(780.0);
        entry.add(810.0);
        entry.add(860.0);
        entry.add(990.0);
        entry.add(610.0);
        entry.add(730.0);
        entry.add(790.0);
        entry.add(810.0);
        entry.add(860.0);
        entry.add(1045.0);
        entry.add(635.0);
        entry.add(740.0);
        entry.add(790.0);
        entry.add(840.0);
        entry.add(890.0);
        entry.add(1080.0);

        setMainGui(mainGui);
        getJpInput().add(getCbOperation());
        getJpInput().add(getTxtDataX());
        getJpInput().add(getTxtDataY());
        getJpInput().add(getTxtDataN());
        getJpInput().add(getBtnExit());
        getJpInput().add(getBtnAdd());
        getJpInput().add(getBtnCalculate());
    }

    public JPanel getJpInput() {
        if (jpInput == null) {
            jpInput = new JPanel();
            jpInput.setSize(new Dimension(300, 600));
            jpInput.setLocation(700, 0);
            jpInput.setBackground(new Color(64, 115, 158)); // naval
            jpInput.setLayout(springLayout);
        }
        return jpInput;
    }

    public JButton getBtnExit() {
        if (btnExit == null) {
            btnExit = new JButton("X");
            btnExit.setBackground(btnDefault);
            btnExit.setForeground(Color.white);
            btnExit.setFocusPainted(false);
            btnExit.setBorder(null);
            btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
            btnExit.addActionListener(getMainGui().getActions());
            btnExit.addMouseListener(getMainGui().getActions());
            springLayout.putConstraint(SpringLayout.EAST, btnExit, 0, SpringLayout.EAST, getJpInput());
            springLayout.putConstraint(SpringLayout.NORTH, btnExit, 0, SpringLayout.NORTH, getJpInput());
            springLayout.getConstraints(btnExit).setHeight(Spring.constant(50));
            springLayout.getConstraints(btnExit).setWidth(Spring.constant(50));
        }
        return btnExit;
    }

    public JButton getBtnCalculate() {
        if (btnCalculate == null) {
            btnCalculate = new JButton("Hesapla");
            btnCalculate.setBackground(btnDefault);
            btnCalculate.setForeground(Color.white);
            btnCalculate.setFocusPainted(false);
            btnCalculate.setBorder(null);
            btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 12));
            btnCalculate.addActionListener(getMainGui().getActions());
            btnCalculate.addMouseListener(getMainGui().getActions());
            springLayout.putConstraint(SpringLayout.NORTH, btnCalculate, 20, SpringLayout.SOUTH, getBtnAdd());
            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnCalculate, 0, SpringLayout.HORIZONTAL_CENTER, getJpInput());
            springLayout.getConstraints(btnCalculate).setHeight(Spring.constant(50));
            springLayout.getConstraints(btnCalculate).setWidth(Spring.constant(200));
        }
        return btnCalculate;
    }

    public JButton getBtnAdd() {
        if (btnAdd == null) {
            btnAdd = new JButton("Ekle");
            btnAdd.setBackground(btnDefault);
            btnAdd.setForeground(Color.white);
            btnAdd.setFocusPainted(false);
            btnAdd.setBorder(null);
            btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
            btnAdd.setEnabled(false);
            btnAdd.addActionListener(getMainGui().getActions());
            btnAdd.addMouseListener(getMainGui().getActions());

            springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 20, SpringLayout.SOUTH, getTxtDataN());
            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAdd, 0, SpringLayout.HORIZONTAL_CENTER, getJpInput());
            springLayout.getConstraints(btnAdd).setHeight(Spring.constant(50));
            springLayout.getConstraints(btnAdd).setWidth(Spring.constant(200));
        }
        return btnAdd;
    }

    public JComboBox getCbOperation() {
        if (cbOperation == null) {
            cbOperation = new JComboBox(operationList);
            cbOperation.setEditable(false);
            cbOperation.setOpaque(false);
            cbOperation.setBackground(new Color(64, 115, 158));
            cbOperation.setForeground(Color.white);
            cbOperation.setFont(new Font("Tahoma", Font.BOLD, 12));
            //cbOperation.setRenderer(new IndentedRenderer());
            cbOperation.addActionListener(getMainGui().getActions());

            /*springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, cbOperation, -120, SpringLayout.VERTICAL_CENTER, getJpInput());
            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, cbOperation,0, SpringLayout.HORIZONTAL_CENTER, getJpInput());*/
            springLayout.putConstraint(SpringLayout.EAST, cbOperation, 0, SpringLayout.WEST, getBtnExit());
            springLayout.putConstraint(SpringLayout.NORTH, cbOperation, 0, SpringLayout.NORTH, getJpInput());
            springLayout.getConstraints(cbOperation).setHeight(Spring.constant(50));
            springLayout.getConstraints(cbOperation).setWidth(Spring.constant(250));
        }
        return cbOperation;
    }

    public JTextField getTxtDataX() {
        if (txtDataX == null) {
            txtDataX = new JTextField(getMainGui().getSettings().btnX[0], 15);
            txtDataX.setOpaque(false);
            txtDataX.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white, 1),
                    BorderFactory.createEmptyBorder(5, 25, 5, 25)));
            txtDataX.setForeground(Color.white);
            txtDataX.setFont(new Font("Tahoma", Font.BOLD, 12));
            txtDataX.addFocusListener(getMainGui().getActions());
            txtDataX.addKeyListener(getMainGui().getActions());

            springLayout.putConstraint(SpringLayout.NORTH, txtDataX, 20, SpringLayout.SOUTH, getCbOperation());
            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtDataX, 0, SpringLayout.HORIZONTAL_CENTER, getJpInput());
            springLayout.getConstraints(txtDataX).setHeight(Spring.constant(50));
            springLayout.getConstraints(txtDataX).setWidth(Spring.constant(200));
        }
        return txtDataX;
    }

    public JTextField getTxtDataY() {
        if (txtDataY == null) {
            txtDataY = new JTextField(getMainGui().getSettings().btnY[0], 15);
            txtDataY.setOpaque(false);
            txtDataY.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white, 1),
                    BorderFactory.createEmptyBorder(5, 25, 5, 25)));
            txtDataY.setForeground(Color.white);
            txtDataY.setFont(new Font("Tahoma", Font.BOLD, 12));
            txtDataY.addFocusListener(getMainGui().getActions());
            txtDataY.addKeyListener(getMainGui().getActions());

            springLayout.putConstraint(SpringLayout.NORTH, txtDataY, 20, SpringLayout.SOUTH, getTxtDataX());
            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtDataY, 0, SpringLayout.HORIZONTAL_CENTER, getJpInput());
            springLayout.getConstraints(txtDataY).setHeight(Spring.constant(50));
            springLayout.getConstraints(txtDataY).setWidth(Spring.constant(200));
        }
        return txtDataY;
    }

    public JTextField getTxtDataN() {
        if (txtDataN == null) {
            txtDataN = new JTextField(getMainGui().getSettings().btnN[0], 15);
            txtDataN.setOpaque(false);
            txtDataN.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white, 1),
                    BorderFactory.createEmptyBorder(5, 25, 5, 25)));
            txtDataN.setForeground(Color.white);
            txtDataN.setFont(new Font("Tahoma", Font.BOLD, 12));
            txtDataN.addFocusListener(getMainGui().getActions());
            txtDataN.addKeyListener(getMainGui().getActions());

            springLayout.putConstraint(SpringLayout.NORTH, txtDataN, 20, SpringLayout.SOUTH, getTxtDataY());
            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtDataN, 0, SpringLayout.HORIZONTAL_CENTER, getJpInput());
            springLayout.getConstraints(txtDataN).setHeight(Spring.constant(50));
            springLayout.getConstraints(txtDataN).setWidth(Spring.constant(200));
        }
        return txtDataN;
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}
/*class IndentedRenderer extends DefaultListCellRenderer
{
    public Component getListCellRendererComponent(JList list,Object value, int index,boolean isSelected,boolean cellHasFocus)
    {
        JLabel lbl = (JLabel)super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        lbl.setBorder(BorderFactory.createEmptyBorder(0,24,0,24));
        return lbl;
    }
}*/
