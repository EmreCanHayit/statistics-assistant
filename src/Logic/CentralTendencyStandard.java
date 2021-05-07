package Logic;

import Gui.MainGui;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class CentralTendencyStandard {
    private MainGui mainGui;

    public CentralTendencyStandard(MainGui mainGui) {
        setMainGui(mainGui);
    }

    public void centralTendencyExtra(String N, String R) {
        int dataN = Integer.parseInt(N), dataR = Integer.parseInt(R);
        BigInteger bufferN = new BigInteger("1"), bufferR = new BigInteger("1"), bufferNR = new BigInteger("1");
        BigInteger combination = new BigInteger("1"), permutation = new BigInteger("1");
        for (int i = 1; i <= dataN; i++) {
            bufferN = bufferN.multiply(new BigInteger(i + ""));
        }
        for (int i = 1; i <= dataR; i++) {
            bufferR = bufferR.multiply(new BigInteger(i + ""));
        }
        for (int i = 1; i <= dataN - dataR; i++) {
            bufferNR = bufferNR.multiply(new BigInteger(i + ""));
        }
        combination = bufferN.divide(bufferR.multiply(bufferNR));
        permutation = bufferN.divide(bufferNR);
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Combinasyon",
                getMainGui().decimal.format(combination)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Permutasyon",
                getMainGui().decimal.format(permutation)
        });
    }

    public void centralTendencyStandard(ArrayList<Double> output) {
        Collections.sort(output);
        double buffer = 0, counter = 0, arithmeticAverage = 0, median = 0, mode = 0, geometricAverage = 0;
        double harmonicAverage = 0;
        double x = 1;
        double y = 0;

        for (double data : output) {
            buffer += data;
            x *= data;
            y += 1 / data;
        }
        arithmeticAverage = buffer / output.size();

        if ((output.size() % 2) == 1) {
            median = output.get((output.size()) / 2);
        } else {
            median = (output.get((output.size() / 2) - 1) + output.get((output.size() / 2))) / 2;
        }

        ArrayList<Double> xi = new ArrayList<Double>(), fi = new ArrayList<Double>();
        for (int i = 0; i < output.size(); i++) {
            counter = 0;
            for (int j = 0; j < output.size(); j++) {
                if (output.get(i).equals(output.get(j))) {
                    counter++;
                }
            }
            if (buffer != output.get(i)) {
                xi.add(output.get(i));
                fi.add(counter);
                buffer = output.get(i);
            }
        }

        for (int i = 0; i < fi.size(); i++) {
            if (Collections.max(fi).equals(fi.get(i))) {
                mode = xi.get(i);
            }
        }

        geometricAverage = (int) Math.pow(x, 1.0 / (double) output.size());
        harmonicAverage = output.size() / y;

        getMainGui().getSectionOutput().tableModel.setColumnCount(0);
        getMainGui().getSectionOutput().tableModel.setRowCount(0);
        String[] column = new String[]{"Name", "Value"};
        int[] columnWidth = new int[]{200, 500};
        getMainGui().getSectionOutput().DefaultTableCellModify(columnWidth, column);
            /*getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                    getMainGui().decimal.format(arithmeticAverage),
                    getMainGui().decimal.format(median),
                    getMainGui().decimal.format(mode),
                    getMainGui().decimal.format(geometricAverage),
                    getMainGui().decimal.format(harmonicAverage)
            });*/
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Aritmetik",
                getMainGui().decimal.format(arithmeticAverage)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Medyan",
                getMainGui().decimal.format(median)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Mod",
                getMainGui().decimal.format(mode)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Geo",
                getMainGui().decimal.format(geometricAverage)
        });
        getMainGui().getSectionOutput().tableModel.addRow(new Object[]{
                "Harmonik",
                getMainGui().decimal.format(harmonicAverage)
        });
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}
