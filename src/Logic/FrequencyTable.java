package Logic;

import Gui.MainGui;

import java.util.ArrayList;
import java.util.Collections;

public class FrequencyTable {
    private MainGui mainGui;

    public FrequencyTable(MainGui mainGui) {
        setMainGui(mainGui);
    }

    public void frequencyTable(ArrayList<Double> output) {
        double buffer = 0, counter = 0, x = 0, R = 0, k = 0, h = 0;
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
        System.out.println("n : " + output.size());
        R = output.get(output.size() - 1) - output.get(0);
        System.out.println("R : " + R);
        //k = (int) Math.sqrt(output.length)+1;
        k = (int) Math.ceil(Math.sqrt(output.size()));
        System.out.println("k : " + k);
        //h = (R / k) + 1;
        h = (int) Math.ceil(R / k);
        System.out.println("h : " + h);


        double[] classLimitsLower = new double[(int)k], classLimitsUpper = new double[(int)k], classBorderUpper = new double[(int)k], classBorderLower = new double[(int)k], classFrequency = new double[(int)k], classMidpoint = new double[(int)k], additionFrequency = new double[(int)k], proportionallyFrequency = new double[(int)k], proportionallyAdditionFrequency = new double[(int)k];
        /*-----Sınıf Limitleri-----*/
        /*alt*/
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                classLimitsLower[i] = output.get(0);
            } else {
                classLimitsLower[i] = output.get(0) + (h * i);
            }
        }
        /*üst*/
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                if (h > 10) {
                    classLimitsUpper[i] = classLimitsLower[1] - 1;
                }else{
                    classLimitsUpper[i] = classLimitsLower[1] - 0.1;
                }
            } else {
                classLimitsUpper[i] = classLimitsUpper[0] + (h * i);
            }
        }
        if (classLimitsUpper[(int)k - 1] < output.get(output.size() - 1)) {
            classLimitsUpper[(int)k - 1] = output.get(output.size() - 1);
        }

        /*-----Sınıf Sınırları-----*/
        /*üst*/
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                classBorderUpper[i] = (classLimitsLower[1] + classLimitsUpper[0]) / 2;
            } else {
                classBorderUpper[i] = classBorderUpper[0] + (h * i);
            }
        }
        /*alt*/
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                classBorderLower[i] = classBorderUpper[0] - h;
            } else {
                classBorderLower[i] = classBorderLower[0] + (h * i);
            }
        }

        /*-----Sınıf Frekansı-----*/
        for (int i = 0; i < k; i++) {
            counter = 0;
            for (int j = 0; j < output.size(); j++) {
                if (output.get(j) >= classBorderLower[i] && output.get(j) <= classBorderUpper[i]) {
                    counter++;
                }
            }
            classFrequency[i] = counter;
        }
        /*-----Sınıf Orta Noktası-----*/
        for (int i = 0; i < k; i++) {
            classMidpoint[i] = (classLimitsUpper[i] + classLimitsLower[i]) / 2;
        }
        /*-----Eklenik Frekans-----*/
        buffer = 0;
        for (int i = 0; i < k; i++) {
            buffer += classFrequency[i];
            additionFrequency[i] = buffer;
        }

        /*----- Orantısal Frekans-----*/
        for (int i = 0; i < k; i++) {
            proportionallyFrequency[i] = classFrequency[i] / output.size();
        }

        /*-----Orantısal Eklenik Frekans-----*/
        for (int i = 0; i < k; i++) {
            proportionallyAdditionFrequency[i] = additionFrequency[i] / output.size();
        }

        getMainGui().getSectionOutput().tableModel.setColumnCount(0);
        getMainGui().getSectionOutput().tableModel.setRowCount(0);
        String[] column = new String[]{"SL-", "SL+", "SS-", "SS+", "SF", "SON", "EF", "OF", "EOF"};
        int[] columnWidth = new int[]{80, 80, 80, 80, 75, 80, 75, 75, 75};
        getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);

        for (int i = 0; i < k; i++) {
            getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                    getMainGui().decimal.format(classLimitsLower[i]),
                    getMainGui().decimal.format(classLimitsUpper[i]),
                    getMainGui().decimal.format(classBorderLower[i]),
                    getMainGui().decimal.format(classBorderUpper[i]),
                    getMainGui().decimal.format(classFrequency[i]),
                    getMainGui().decimal.format(classMidpoint[i]),
                    getMainGui().decimal.format(additionFrequency[i]),
                    getMainGui().decimal.format(proportionallyFrequency[i]),
                    getMainGui().decimal.format(proportionallyAdditionFrequency[i])
            });
        }
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}