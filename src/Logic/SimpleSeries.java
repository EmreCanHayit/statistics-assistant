package Logic;

import Gui.MainGui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SimpleSeries {
    private MainGui mainGui;

    public SimpleSeries(MainGui mainGui) {
        setMainGui(mainGui);
    }

    public void simpleSeries(ArrayList<Double> output) {
        /*int buffer = 0;
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                if (output[i] <= output[j]) {
                    buffer = output[j];
                    output[j] = output[i];
                    output[i] = buffer;
                }
            }
        }*/
        Collections.sort(output);
        getMainGui().getSectionOutput().tableModel.setColumnCount(0);
        getMainGui().getSectionOutput().tableModel.setRowCount(0);
        String[] column = new String[]{"Simple Series"};
        int[] columnWidth = new int[]{700};
        getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);
        for (double entry : output) {
            getMainGui().getSectionOutput().tableModel.addRow(new Object[]{entry});
        }
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}
