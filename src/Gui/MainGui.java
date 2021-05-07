package Gui;

import Logic.*;

import javax.swing.*;
import java.text.DecimalFormat;

public class MainGui {
    JFrame jf = null;
    JPanel jp = null;
    SectionInput sectionInput = null;
    SectionOutput sectionOutput = null;
    private Actions actions = null;
    private Settings settings = null;
    private SimpleRandomSampling simpleRandomSampling = null;
    private SystematicRandomSampling systematicRandomSampling = null;
    private SimpleSeries simpleSeries = null;
    private FrequencySeries frequencySeries = null;
    private FrequencyTable frequencyTable = null;
    private CentralTendencyStandard centralTendencyStandard = null;
    private DistributionStandard distributionStandard = null;
    public DecimalFormat decimal = new DecimalFormat("#.##");

    public MainGui() {
        getJf().add(getSectionOutput().getJpOutput());
        getJf().add(getSectionInput().getJpInput());
        getJf().setVisible(true);
    }

    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("Olasılık ve İstatistik Sıralama");
            jf.setSize(1000, 600);
            LocationCenter locationCenter = new LocationCenter(jf);
            MouseDragged mouseDragged = new MouseDragged(this);
            jf.addMouseListener(mouseDragged);
            jf.addMouseMotionListener(mouseDragged);
            jf.getRootPane().setDefaultButton(getSectionInput().btnAdd);
            jf.setUndecorated(true);
            jf.setLayout(null);
        }
        return jf;
    }

    public SectionInput getSectionInput() {
        if (sectionInput == null) {
            sectionInput = new SectionInput(this);
        }
        return sectionInput;
    }

    public SectionOutput getSectionOutput() {
        if (sectionOutput == null) {
            sectionOutput = new SectionOutput();
        }
        return sectionOutput;
    }

    public SimpleRandomSampling getSimpleRandomSampling() {
        if (simpleRandomSampling == null) {
            simpleRandomSampling = new SimpleRandomSampling(this);
        }
        return simpleRandomSampling;
    }

    public void setSimpleRandomSampling(SimpleRandomSampling simpleRandomSampling) {
        this.simpleRandomSampling = simpleRandomSampling;
    }

    public Actions getActions() {
        if (actions == null) {
            actions = new Actions(this);
        }
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public SystematicRandomSampling getSystematicRandomSampling() {
        if (systematicRandomSampling == null) {
            systematicRandomSampling = new SystematicRandomSampling(this);
        }
        return systematicRandomSampling;
    }

    public void setSystematicRandomSampling(SystematicRandomSampling systematicRandomSampling) {
        this.systematicRandomSampling = systematicRandomSampling;
    }

    public SimpleSeries getSimpleSeries() {
        if (simpleSeries == null) {
            simpleSeries = new SimpleSeries(this);
        }
        return simpleSeries;
    }

    public void setSimpleSeries(SimpleSeries simpleSeries) {
        this.simpleSeries = simpleSeries;
    }

    public FrequencySeries getFrequencySeries() {
        if (frequencySeries == null) {
            frequencySeries = new FrequencySeries(this);
        }
        return frequencySeries;
    }

    public void setFrequencySeries(FrequencySeries frequencySeries) {
        this.frequencySeries = frequencySeries;
    }

    public FrequencyTable getFrequencyTable() {
        if (frequencyTable == null) {
            frequencyTable = new FrequencyTable(this);
        }
        return frequencyTable;
    }

    public void setFrequencyTable(FrequencyTable frequencyTable) {
        this.frequencyTable = frequencyTable;
    }

    public CentralTendencyStandard getCentralTendencyStandard() {
        if (centralTendencyStandard == null){
            centralTendencyStandard = new CentralTendencyStandard(this);
        }
        return centralTendencyStandard;
    }

    public void setCentralTendencyStandard(CentralTendencyStandard centralTendencyStandard) {
        this.centralTendencyStandard = centralTendencyStandard;
    }

    public DistributionStandard getDistributionStandard() {
        if (distributionStandard == null){
            distributionStandard = new DistributionStandard(this);
        }
        return distributionStandard;
    }

    public void setDistributionStandard(DistributionStandard distributionStandard) {
        this.distributionStandard = distributionStandard;
    }

    public Settings getSettings() {
        if (settings == null){
            settings = new Settings();
        }
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
