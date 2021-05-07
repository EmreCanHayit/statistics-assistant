package Logic;

import Gui.MainGui;

import java.util.ArrayList;
import java.util.Collections;

public class FrequencySeries {
    private MainGui mainGui;

    public FrequencySeries(MainGui mainGui) {
        setMainGui(mainGui);
    }

    public void frequencySeries(ArrayList<Double> output) {
        int counter = 0;
        double buffer = -1;
        /*for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                if (output[i] <= output[j]) {
                    buffer = output[j];
                    output[j] = output[i];
                    output[i] = buffer;
                }
            }
        }*/
        Collections.sort(output);
        /*for (int i = 0; i < output.size(); i++) {
            if (buffer != output.get(i)) {
                buffer = output.get(i);
                counter++;
            }
        }*/
        ArrayList<Double> xi = new ArrayList<Double>(), fi = new ArrayList<Double>();
        //int[] xi = new int[counter], fi = new int[counter];
        for (int i = 0; i < output.size(); i++) {
            counter = 0;
            for (int j = 0; j < output.size(); j++) {
                if (output.get(i).equals(output.get(j))) {
                    counter++;
                }
            }
            if (buffer != output.get(i)) {
                xi.add(output.get(i));
                fi.add((double)counter);
                buffer = output.get(i);
            }
        }

        getMainGui().getSectionOutput().tableModel.setColumnCount(0);
        getMainGui().getSectionOutput().tableModel.setRowCount(0);
        String[] column = new String[]{"Frequency Series xi", "Frequency Series fi"};
        int[] columnWidth = new int[]{350, 350};
        getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);
        for (int i = 0; i < xi.size(); i++) {
            getMainGui().getSectionOutput().tableModel.addRow(new Object[]{xi.get(i), fi.get(i)});
        }
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}
