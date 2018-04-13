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

public class AsgResynParams {

    public enum TackleComplexityStrategy {
        Straight, // no Decomposition 
        BreezeDeco, // Decomposition with p=common-cause d=breeze
    }

    public enum LogicSynthesisProcedure {
        PPPP, PPNP, PPPI, PAAA, MPPP, MPNP, MPPI, MAAA
    }

    private TackleComplexityStrategy tackleComplexityStrategy;
    private LogicSynthesisProcedure  logicSynthesisProcedure;
    private Boolean                  optimiseDataPath;

    private Boolean                  useDesiJbreeze2stg;
    private File                     breezeExprFile;
    private String                   asgLogicParams;

    private File                     zipFile;
    private File                     logFile;
    private File                     stgOutFile;

    private File                     configFile;
    private File                     toolConfigFile;

    private Boolean                  skipSubComponents;
    private Boolean                  skipDataPath;
    private Boolean                  debug;

    public TackleComplexityStrategy getTackleComplexityStrategy() {
        return tackleComplexityStrategy;
    }

    public void setTackleComplexityStrategy(TackleComplexityStrategy tackleComplexityStrategy) {
        this.tackleComplexityStrategy = tackleComplexityStrategy;
    }

    public LogicSynthesisProcedure getLogicSynthesisProcedure() {
        return logicSynthesisProcedure;
    }

    public void setLogicSynthesisProcedure(LogicSynthesisProcedure logicSynthesisProcedure) {
        this.logicSynthesisProcedure = logicSynthesisProcedure;
    }

    public Boolean getSkipSubComponents() {
        return skipSubComponents;
    }

    public void setSkipSubComponents(Boolean skipSubComponents) {
        this.skipSubComponents = skipSubComponents;
    }

    public Boolean getOptimiseDataPath() {
        return optimiseDataPath;
    }

    public void setOptimiseDataPath(Boolean optimiseDataPath) {
        this.optimiseDataPath = optimiseDataPath;
    }

    public Boolean getSkipDataPath() {
        return skipDataPath;
    }

    public void setSkipDataPath(Boolean skipDataPath) {
        this.skipDataPath = skipDataPath;
    }

    public Boolean getUseDesiJbreeze2stg() {
        return useDesiJbreeze2stg;
    }

    public void setUseDesiJbreeze2stg(Boolean useDesiJbreeze2stg) {
        this.useDesiJbreeze2stg = useDesiJbreeze2stg;
    }

    public File getBreezeExprFile() {
        return breezeExprFile;
    }

    public void setBreezeExprFile(File breezeExprFile) {
        this.breezeExprFile = breezeExprFile;
    }

    public String getAsgLogicParams() {
        return asgLogicParams;
    }

    public void setAsgLogicParams(String asgLogicParams) {
        this.asgLogicParams = asgLogicParams;
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

    public File getStgOutFile() {
        return stgOutFile;
    }

    public void setStgOutFile(File stgOutFile) {
        this.stgOutFile = stgOutFile;
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
