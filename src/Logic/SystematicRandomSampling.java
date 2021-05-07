package Logic;

import Gui.MainGui;

import java.util.Random;

public class SystematicRandomSampling {
    private MainGui mainGui;
    public SystematicRandomSampling(MainGui mainGui){
        setMainGui(mainGui);
    }
    public void systematicRandomSampling(String X, String N){
        int dataX = Integer.parseInt(X), dataN = Integer.parseInt(N),k,a;
        int[] output = new int[dataN];
        k=dataX/dataN;
        Random random = new Random();
        int ss = 0;
        do {
            a=random.nextInt(k);
            ss++;
            System.out.println("Route -> "+ss);
        }while(a==0);

        for (int i = 0; i<dataN; i++){
            output[i] = a+(k*i);
        }
        getMainGui().getSectionOutput().tableModel.setColumnCount(0);
        getMainGui().getSectionOutput().tableModel.setRowCount(0);
        String[] column = new String[]{"Systematic Random Sampling"};
        int[] columnWidth = new int[]{700};
        getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);
        for (int entry : output){
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
