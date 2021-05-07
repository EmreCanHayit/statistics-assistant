package Logic;

import Gui.MainGui;

import java.util.Random;

public class SimpleRandomSampling {
    private MainGui mainGui;

    public SimpleRandomSampling(MainGui mainGui) {
        setMainGui(mainGui);
    }

    public void simpleRandomSampling(String X, String Y, String N) {
        int dataX = Integer.parseInt(X), dataY = Integer.parseInt(Y), dataN = Integer.parseInt(N);
        Random random = new Random();
        int[] output = new int[Integer.parseInt(N)];
        if ((dataX - dataY) < dataN) {
            for (int i = 0; i < dataN; i++) {
                output[i] = random.nextInt(dataX - dataY) + dataY;
            }
        } else {
            for (int i = 0; i < dataN; i++) {
                output[i] = random.nextInt(dataX - dataY) + dataY;
                for (int j = 0; j < i; j++) {
                    if (output[j] == output[i]) {
                        i--;
                    }
                }
            }
        }

        getMainGui().getSectionOutput().tableModel.setColumnCount(0);
        getMainGui().getSectionOutput().tableModel.setRowCount(0);
        String[] column = new String[]{"Simple Random Sampling"};
        int[] columnWidth = new int[]{700};
        getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);

        for (int entry : output) {
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
