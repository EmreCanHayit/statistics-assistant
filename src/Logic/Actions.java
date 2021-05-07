package Logic;

import Gui.MainGui;

import java.awt.*;
import java.awt.event.*;

public class Actions implements ActionListener, MouseListener, FocusListener, KeyListener {
    boolean clearData = false;
    private MainGui mainGui;

    public Actions(MainGui mainGui) {
        setMainGui(mainGui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getMainGui().getSectionInput().getBtnExit()) {
            System.exit(0);
        } else if (e.getSource() == getMainGui().getSectionInput().getCbOperation()) {
            if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 0) {
                getMainGui().getSectionInput().getTxtDataX().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataY().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataN().setEnabled(true);
                getMainGui().getSectionInput().getBtnAdd().setEnabled(false);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[0]);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[0]);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[0]);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 1) {
                getMainGui().getSectionInput().getTxtDataX().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataY().setEnabled(false);
                getMainGui().getSectionInput().getTxtDataN().setEnabled(true);
                getMainGui().getSectionInput().getBtnAdd().setEnabled(false);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[1]);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[1]);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[1]);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 2) {
                getMainGui().getSectionInput().getTxtDataX().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataY().setEnabled(false);
                getMainGui().getSectionInput().getTxtDataN().setEnabled(false);
                getMainGui().getSectionInput().getBtnAdd().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[2]);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[2]);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[2]);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 3) {
                getMainGui().getSectionInput().getTxtDataX().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataY().setEnabled(false);
                getMainGui().getSectionInput().getTxtDataN().setEnabled(false);
                getMainGui().getSectionInput().getBtnAdd().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[3]);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[3]);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[3]);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 4) {
                getMainGui().getSectionInput().getTxtDataX().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataY().setEnabled(false);
                getMainGui().getSectionInput().getTxtDataN().setEnabled(false);
                getMainGui().getSectionInput().getBtnAdd().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[4]);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[4]);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[4]);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 5) {
                getMainGui().getSectionInput().getTxtDataX().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataY().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataN().setEnabled(true);
                getMainGui().getSectionInput().getBtnAdd().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[5]);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[5]);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[5]);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 6) {
                getMainGui().getSectionInput().getTxtDataX().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataY().setEnabled(false);
                getMainGui().getSectionInput().getTxtDataN().setEnabled(false);
                getMainGui().getSectionInput().getBtnAdd().setEnabled(true);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[6]);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[6]);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[6]);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getBtnAdd()) {
            if (getMainGui().getSectionInput().getTxtDataX().getText().equals("xx")) {
                if (clearData) {
                    getMainGui().getSectionInput().getBtnAdd().setText("Ekle");
                    getMainGui().getSectionOutput().tableModel.setColumnCount(0);
                    getMainGui().getSectionOutput().tableModel.setRowCount(0);
                    String[] column = new String[]{"Veriler Temizlendi !"};
                    int[] columnWidth = new int[]{700};
                    getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);
                    getMainGui().getSectionInput().entry.clear();
                    clearData = false;
                }else {
                    getMainGui().getSectionInput().getBtnAdd().setText("Verileri Sil!");
                    clearData = true;
                }
            } else if (getMainGui().getSectionInput().getTxtDataX().getText().equals("xxx")) {
                getMainGui().getSectionInput().getBtnAdd().setText("Ekle");
                clearData = false;
            } else if (getMainGui().getSectionInput().getTxtDataX().getText().equals(getMainGui().getSettings().btnX[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])) {
                getMainGui().getSectionOutput().tableModel.setColumnCount(0);
                getMainGui().getSectionOutput().tableModel.setRowCount(0);
                String[] column = new String[]{"Eksik değer girdiniz !"};
                int[] columnWidth = new int[]{700};
                getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);
            } else {
                getMainGui().getSectionInput().entry.add(Double.valueOf(getMainGui().getSectionInput().getTxtDataX().getText()));
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getBtnCalculate()) {
            if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 0 && !getMainGui().getSectionInput().getTxtDataX().getText().equals(getMainGui().getSettings().btnX[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])) {
                getMainGui().getSimpleRandomSampling().simpleRandomSampling(getMainGui().getSectionInput().getTxtDataX().getText(), getMainGui().getSectionInput().getTxtDataY().getText(), getMainGui().getSectionInput().getTxtDataN().getText());
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 1) {
                getMainGui().getSystematicRandomSampling().systematicRandomSampling(getMainGui().getSectionInput().getTxtDataX().getText(), getMainGui().getSectionInput().getTxtDataN().getText());
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 2) {
                getMainGui().getSimpleSeries().simpleSeries(getMainGui().getSectionInput().entry);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 3) {
                getMainGui().getFrequencySeries().frequencySeries(getMainGui().getSectionInput().entry);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 4) {
                getMainGui().getFrequencyTable().frequencyTable(getMainGui().getSectionInput().entry);
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 5) {
                if (!getMainGui().getSectionInput().getTxtDataY().getText().equals(getMainGui().getSettings().btnY[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]) && !getMainGui().getSectionInput().getTxtDataN().getText().equals(getMainGui().getSettings().btnN[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])){
                    getMainGui().getCentralTendencyStandard().centralTendencyStandard(getMainGui().getSectionInput().entry);
                    getMainGui().getCentralTendencyStandard().centralTendencyExtra(getMainGui().getSectionInput().getTxtDataY().getText(), getMainGui().getSectionInput().getTxtDataN().getText());
                }else {
                    getMainGui().getCentralTendencyStandard().centralTendencyStandard(getMainGui().getSectionInput().entry);
                }
            } else if (getMainGui().getSectionInput().getCbOperation().getSelectedIndex() == 6) {
                getMainGui().getDistributionStandard().distributionStandard(getMainGui().getSectionInput().entry);
            } else {
                getMainGui().getSectionOutput().tableModel.setColumnCount(0);
                getMainGui().getSectionOutput().tableModel.setRowCount(0);
                String[] column = new String[]{"Eksik değer girdiniz !"};
                int[] columnWidth = new int[]{700};
                getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == getMainGui().getSectionInput().getBtnExit()) {
            getMainGui().getSectionInput().getBtnExit().setBackground(getMainGui().getSettings().btnHover);
        } else if (e.getSource() == getMainGui().getSectionInput().getBtnAdd()) {
            getMainGui().getSectionInput().getBtnAdd().setBackground(getMainGui().getSettings().btnHover);
        } else if (e.getSource() == getMainGui().getSectionInput().getBtnCalculate()) {
            getMainGui().getSectionInput().getBtnCalculate().setBackground(getMainGui().getSettings().btnHover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == getMainGui().getSectionInput().getBtnExit()) {
            getMainGui().getSectionInput().getBtnExit().setBackground(getMainGui().getSettings().btnDefault);
        } else if (e.getSource() == getMainGui().getSectionInput().getBtnAdd()) {
            getMainGui().getSectionInput().getBtnAdd().setBackground(getMainGui().getSettings().btnDefault);
        } else if (e.getSource() == getMainGui().getSectionInput().getBtnCalculate()) {
            getMainGui().getSectionInput().getBtnCalculate().setBackground(getMainGui().getSettings().btnDefault);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == getMainGui().getSectionInput().getTxtDataX()) {
            String txtX = getMainGui().getSectionInput().getTxtDataX().getText();
            if (txtX.equals(getMainGui().getSettings().btnX[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])) {
                getMainGui().getSectionInput().getTxtDataX().setCaretPosition(0);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getTxtDataY()) {
            String txtY = getMainGui().getSectionInput().getTxtDataY().getText();
            if (txtY.equals(getMainGui().getSettings().btnY[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])) {
                getMainGui().getSectionInput().getTxtDataY().setCaretPosition(0);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getTxtDataN()) {
            String txtN = getMainGui().getSectionInput().getTxtDataN().getText();
            if (txtN.equals(getMainGui().getSettings().btnN[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])) {
                getMainGui().getSectionInput().getTxtDataN().setCaretPosition(0);
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == getMainGui().getSectionInput().getTxtDataX()) {
            String txtX = getMainGui().getSectionInput().getTxtDataX().getText();
            if (txtX.equals("")) {
                getMainGui().getSectionInput().getTxtDataX().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
                getMainGui().getSectionInput().getTxtDataX().setForeground(Color.white);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getTxtDataY()) {
            String txtY = getMainGui().getSectionInput().getTxtDataY().getText();
            if (txtY.equals("")) {
                getMainGui().getSectionInput().getTxtDataY().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
                getMainGui().getSectionInput().getTxtDataY().setForeground(Color.white);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getTxtDataN()) {
            String txtN = getMainGui().getSectionInput().getTxtDataN().getText();
            if (txtN.equals("")) {
                getMainGui().getSectionInput().getTxtDataN().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
                getMainGui().getSectionInput().getTxtDataN().setForeground(Color.white);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == getMainGui().getSectionInput().getTxtDataX()) {
            String txtX = getMainGui().getSectionInput().getTxtDataX().getText();
            if (txtX.equals(getMainGui().getSettings().btnX[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])) {
                getMainGui().getSectionInput().getTxtDataX().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataX().setText(null);
                getMainGui().getSectionInput().getTxtDataX().setForeground(Color.white);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getTxtDataY()) {
            String txtY = getMainGui().getSectionInput().getTxtDataY().getText();
            if (txtY.equals(getMainGui().getSettings().btnY[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])) {
                getMainGui().getSectionInput().getTxtDataY().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataY().setText(null);
                getMainGui().getSectionInput().getTxtDataY().setForeground(Color.white);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getTxtDataN()) {
            String txtN = getMainGui().getSectionInput().getTxtDataN().getText();
            if (txtN.equals(getMainGui().getSettings().btnN[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()])) {
                getMainGui().getSectionInput().getTxtDataN().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataN().setText(null);
                getMainGui().getSectionInput().getTxtDataN().setForeground(Color.white);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == getMainGui().getSectionInput().getTxtDataX()) {
            String txtX = getMainGui().getSectionInput().getTxtDataX().getText();
            if (txtX.equals("")) {
                getMainGui().getSectionInput().getTxtDataX().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataX().setText(getMainGui().getSettings().btnX[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
                getMainGui().getSectionInput().getTxtDataX().setForeground(Color.white);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getTxtDataY()) {
            String txtY = getMainGui().getSectionInput().getTxtDataY().getText();
            if (txtY.equals("")) {
                getMainGui().getSectionInput().getTxtDataY().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataY().setText(getMainGui().getSettings().btnY[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
                getMainGui().getSectionInput().getTxtDataY().setForeground(Color.white);
            }
        } else if (e.getSource() == getMainGui().getSectionInput().getTxtDataN()) {
            String txtN = getMainGui().getSectionInput().getTxtDataN().getText();
            if (txtN.equals("")) {
                getMainGui().getSectionInput().getTxtDataN().setCaretPosition(0);
                getMainGui().getSectionInput().getTxtDataN().setText(getMainGui().getSettings().btnN[getMainGui().getSectionInput().getCbOperation().getSelectedIndex()]);
                getMainGui().getSectionInput().getTxtDataN().setForeground(Color.white);
            }
        }
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}
