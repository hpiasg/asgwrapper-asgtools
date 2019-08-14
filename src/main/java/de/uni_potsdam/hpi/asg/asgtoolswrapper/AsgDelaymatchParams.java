package de.uni_potsdam.hpi.asg.asgtoolswrapper;

/*
 * Copyright (C) 2018 Norman Kluge
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

public class AsgDelaymatchParams {

    private Boolean futureAlgorithm;
    private File    pastAlgorithmStgFile;

    private Boolean verifyOnly;

    private File    sdfInFile;
    private File    sdfOutFile;
    private File    sdcInFile;
    private File    sdcOutFile;
    private File    valInFile;
    private File    valOutFile;

    private File    zipFile;
    private File    logFile;

    private File    configFile;
    private File    toolConfigFile;

    private Boolean debug;

    public Boolean getFutureAlgorithm() {
        return futureAlgorithm;
    }

    public void setFutureAlgorithm(boolean futureAlgorithm) {
        this.futureAlgorithm = futureAlgorithm;
    }

    public File getPastAlgorithmStgFile() {
        return pastAlgorithmStgFile;
    }

    public void setPastAlgorithmStgFile(File pastAlgorithmStgFile) {
        this.pastAlgorithmStgFile = pastAlgorithmStgFile;
    }

    public Boolean getVerifyOnly() {
        return verifyOnly;
    }

    public void setVerifyOnly(boolean verifyOnly) {
        this.verifyOnly = verifyOnly;
    }

    public File getSdfInFile() {
        return sdfInFile;
    }

    public void setSdfInFile(File sdfInFile) {
        this.sdfInFile = sdfInFile;
    }

    public File getSdfOutFile() {
        return sdfOutFile;
    }

    public void setSdfOutFile(File sdfOutFile) {
        this.sdfOutFile = sdfOutFile;
    }

    public File getSdcInFile() {
        return sdcInFile;
    }

    public void setSdcInFile(File sdcInFile) {
        this.sdcInFile = sdcInFile;
    }

    public File getSdcOutFile() {
        return sdcOutFile;
    }

    public void setSdcOutFile(File sdcOutFile) {
        this.sdcOutFile = sdcOutFile;
    }

    public File getValInFile() {
        return valInFile;
    }

    public void setValInFile(File valInFile) {
        this.valInFile = valInFile;
    }

    public File getValOutFile() {
        return valOutFile;
    }

    public void setValOutFile(File valOutFile) {
        this.valOutFile = valOutFile;
    }

    public File getZipFile() {
        return zipFile;
    }

    public void setZipFile(File zipFile) {
        this.zipFile = zipFile;
    }

    public File getLogFile() {
        return logFile;
    }

    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public File getConfigFile() {
        return configFile;
    }

    public void setConfigFile(File configFile) {
        this.configFile = configFile;
    }

    public File getToolConfigFile() {
        return toolConfigFile;
    }

    public void setToolConfigFile(File toolConfigFile) {
        this.toolConfigFile = toolConfigFile;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }
}
