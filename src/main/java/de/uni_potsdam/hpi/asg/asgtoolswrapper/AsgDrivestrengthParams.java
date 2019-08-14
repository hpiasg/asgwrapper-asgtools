package de.uni_potsdam.hpi.asg.asgtoolswrapper;

/*
 * Copyright (C) 2018 - 2019 Norman Kluge
 * 
 * This file is part of ASGwrapper-asgtools.
 * 
 * ASGwrapper-asgtools is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ASGwrapper-asgtools is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ASGwrapper-asgtools.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;

public class AsgDrivestrengthParams {

    public enum Optimizer {
        SA, NOP, TOP, BOT, SFL, ESE, NSE, EDM, FO
    }

    private Optimizer optimizer;
    private Integer   optimizeDelayFactor;
    private Integer   optimizeEnergyFactor;
    private Integer   optimizePowerFactor;

    private Double    outputPinCapacitance;
    private Double    inputDrivenMaxCIn;

    private File      sdcOutFile;
    private File      logFile;

    private Boolean   skipFlattener;
    private Boolean   debug;

    public Optimizer getOptimizer() {
        return optimizer;
    }

    public void setOptimizer(Optimizer optimizer) {
        this.optimizer = optimizer;
    }

    public Double getOutputPinCapacitance() {
        return outputPinCapacitance;
    }

    public void setOutputPinCapacitance(Double outputPinCapacitance) {
        this.outputPinCapacitance = outputPinCapacitance;
    }

    public Double getInputDrivenMaxCIn() {
        return inputDrivenMaxCIn;
    }

    public void setInputDrivenMaxCIn(Double inputDrivenMaxCIn) {
        this.inputDrivenMaxCIn = inputDrivenMaxCIn;
    }

    public File getSdcOutFile() {
        return sdcOutFile;
    }

    public void setSdcOutFile(File sdcOutFile) {
        this.sdcOutFile = sdcOutFile;
    }

    public File getLogFile() {
        return logFile;
    }

    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public Boolean getSkipFlattener() {
        return skipFlattener;
    }

    public void setSkipFlattener(Boolean skipFlattener) {
        this.skipFlattener = skipFlattener;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public Integer getOptimizeDelayFactor() {
        return optimizeDelayFactor;
    }

    public void setOptimizeDelayFactor(Integer optimizeDelayFactor) {
        this.optimizeDelayFactor = optimizeDelayFactor;
    }

    public Integer getOptimizeEnergyFactor() {
        return optimizeEnergyFactor;
    }

    public void setOptimizeEnergyFactor(Integer optimizeEnergyFactor) {
        this.optimizeEnergyFactor = optimizeEnergyFactor;
    }

    public Integer getOptimizePowerFactor() {
        return optimizePowerFactor;
    }

    public void setOptimizePowerFactor(Integer optimizePowerFactor) {
        this.optimizePowerFactor = optimizePowerFactor;
    }
}
