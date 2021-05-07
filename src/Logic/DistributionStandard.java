package Logic;

import Gui.MainGui;

import java.util.ArrayList;

public class DistributionStandard {
    private MainGui mainGui;

    public DistributionStandard(MainGui mainGui) {
        setMainGui(mainGui);
    }

    public void distributionStandard(ArrayList<Double> output) {
        double R = 0, k = 0, h = 0, xAverage = 0, xDuo = 0, xTri = 0, xTet = 0, xAbs = 0, Q1 = 0, Q3 = 0, L1 = 0, L3 = 0, J1 = 0, J3 = 0, fQ1 = 0, fQ3 = 0, n1 = 0, n3 = 0, counter, xx = 0;
        double sampleVariance = 0, standardDeviation = 0, averageAbsoluteDeviation = 0, distortionCriterion = 0, pointednessCriterion = 0, variationCoefficient = 0;

        for (double data : output) {
            xAverage += data;
        }
        xAverage = xAverage / output.size();

        for (double data : output) {
            xDuo += Math.pow((data - xAverage), 2.0);
            xTri += Math.pow((data - xAverage), 3.0);
            xTet += Math.pow((data - xAverage), 4.0);
            xAbs += Math.abs(data - xAverage);
        }
        sampleVariance = xDuo / (double) (output.size() - 1);
        standardDeviation = Math.sqrt(sampleVariance);
        averageAbsoluteDeviation = xAbs / output.size();

        R = output.get(output.size() - 1) - output.get(0);
        k = Math.ceil(Math.sqrt(output.size()));
        h = Math.ceil(R / k);

        double[] classBorderUpper = new double[(int) k], classBorderLower = new double[(int) k], classLimitsUpper = new double[(int) k], classLimitsLower = new double[(int) k], classFrequency = new double[(int) k];
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
                classLimitsUpper[i] = classLimitsLower[1] - 1;
            } else {
                classLimitsUpper[i] = classLimitsUpper[0] + (h * i);
            }
        }
        if (classLimitsUpper[(int) k - 1] < output.get(output.size() - 1)) {
            classLimitsUpper[(int) k - 1] = output.get(output.size() - 1);
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

        xx = (double) output.size() / 4;
        int i = 0;
        while (n1 <= xx) {
            n1 += classFrequency[i];
            i++;
        }
        n1 -= classFrequency[i - 1];
        J1 = xx - n1;
        L1 = classBorderLower[i - 1];
        fQ1 = classFrequency[i - 1];
        Q1 = L1 + ((J1 * h) / fQ1);

        xx = (double) (3 * output.size()) / 4;
        i = 0;
        while (n3 <= xx) {
            n3 += classFrequency[i];
            i++;
        }
        n3 -= classFrequency[i - 1];
        J3 = xx - n3;
        L3 = classBorderLower[i - 1];
        fQ3 = classFrequency[i - 1];
        Q3 = L3 + ((J3 * h) / fQ3);

        distortionCriterion = xTri / (output.size() - 1);
        pointednessCriterion = xTet / (output.size() - 1);
        variationCoefficient = standardDeviation / xAverage;

        getMainGui().getSectionOutput().tableModel.setColumnCount(0);
        getMainGui().getSectionOutput().tableModel.setRowCount(0);
        String[] column = new String[]{"Name", "Value"};
        int[] columnWidth = new int[]{350, 350};
        getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Örneklem Varyansı",
                getMainGui().decimal.format(sampleVariance)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Standart Sapma",
                getMainGui().decimal.format(standardDeviation)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Ortalama Mutlak Sapma",
                getMainGui().decimal.format(averageAbsoluteDeviation)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Çeyrekler Q1",
                getMainGui().decimal.format(Q1)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Çeyrekler Q3",
                getMainGui().decimal.format(Q3)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Çarpıklık Ölçütü",
                getMainGui().decimal.format(distortionCriterion)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Basıklık Ölçütü",
                getMainGui().decimal.format(pointednessCriterion)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Değişim Katsayısı",
                getMainGui().decimal.format(variationCoefficient)
        });
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}
