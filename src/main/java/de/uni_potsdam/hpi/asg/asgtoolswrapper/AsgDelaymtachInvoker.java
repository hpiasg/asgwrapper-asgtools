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
import java.util.ArrayList;
import java.util.List;

import de.uni_potsdam.hpi.asg.common.invoker.ExternalToolsInvoker;
import de.uni_potsdam.hpi.asg.common.invoker.InvokeReturn;
import de.uni_potsdam.hpi.asg.common.technology.Technology;
import de.uni_potsdam.hpi.asg.protocols.io.main.Protocol;

public class AsgDelaymtachInvoker extends ExternalToolsInvoker {

    private AsgDelaymtachInvoker() {
        super("asgdelaymatch");
    }

    public static InvokeReturn resynthesise(File vInFile, AsgDelaymatchParams params, Technology tech, Protocol protocol, File vOutFile) {
        return new AsgDelaymtachInvoker().internalResynthesise(vInFile, params, tech, protocol, vOutFile);
    }

    private InvokeReturn internalResynthesise(File vInFile, AsgDelaymatchParams params, Technology tech, Protocol protocol, File vOutFile) {
        List<String> dmArgs = new ArrayList<String>();

        if(tech == null) {
            return null;
        }
        dmArgs.add("-tech");
        dmArgs.add(tech.getName());

        if(protocol == null) {
            return null;
        }
        dmArgs.add("-hs");
        dmArgs.add(protocol.getName());

        if(vOutFile == null) {
            return null;
        }
        dmArgs.add("-out");
        dmArgs.add(vOutFile.getName());
        addOutputFilesToExport(vOutFile);

        if(params != null) {

            if(params.getFutureAlgorithm() != null && params.getFutureAlgorithm()) {
                dmArgs.add("-future");
            }

            if(params.getPastAlgorithmStgFile() != null) {
                dmArgs.add("-past");
                dmArgs.add(params.getPastAlgorithmStgFile().getName());
                addInputFilesToCopy(params.getPastAlgorithmStgFile());
            }

            if(params.getVerifyOnly() != null && params.getVerifyOnly()) {
                dmArgs.add("-verifyOnly");
            }

            if(params.getSdfInFile() != null) {
                dmArgs.add("-sdfIn");
                dmArgs.add(params.getSdfInFile().getName());
                addInputFilesToCopy(params.getSdfInFile());
            }

            if(params.getSdfOutFile() != null) {
                dmArgs.add("-sdfOut");
                dmArgs.add(params.getSdfOutFile().getName());
                addOutputFilesToExport(params.getSdfOutFile());
            }

            if(params.getSdcInFile() != null) {
                dmArgs.add("-sdcIn");
                dmArgs.add(params.getSdcInFile().getName());
                addInputFilesToCopy(params.getSdcInFile());
            }

            if(params.getSdcOutFile() != null) {
                dmArgs.add("-sdcOut");
                dmArgs.add(params.getSdcOutFile().getName());
                addOutputFilesToExport(params.getSdcOutFile());
            }

            if(params.getValInFile() != null) {
                dmArgs.add("-valIn");
                dmArgs.add(params.getValInFile().getName());
                addInputFilesToCopy(params.getValInFile());
            }

            if(params.getValOutFile() != null) {
                dmArgs.add("-valOut");
                dmArgs.add(params.getValOutFile().getName());
                addOutputFilesToExport(params.getValOutFile());
            }

            if(params.getZipFile() != null) {
                dmArgs.add("-zip");
                dmArgs.add(params.getZipFile().getName());
                addOutputFilesToExport(params.getZipFile());
            }

            if(params.getLogFile() != null) {
                dmArgs.add("-log");
                dmArgs.add(params.getLogFile().getName());
                addOutputFilesToExport(params.getLogFile());
            }

            if(params.getConfigFile() != null) {
                dmArgs.add("-cfg");
                dmArgs.add(params.getConfigFile().getAbsolutePath());
            }

            if(params.getToolConfigFile() != null) {
                dmArgs.add("-toolcfg");
                dmArgs.add(params.getToolConfigFile().getAbsolutePath());
            }

            if(params.getDebug() != null && params.getDebug()) {
                dmArgs.add("-debug");
            }
        }

        if(vInFile == null) {
            return null;
        }
        dmArgs.add(vInFile.getAbsolutePath());
        addInputFilesToCopy(vInFile);

        InvokeReturn ret = run(dmArgs, "asgdelaymatch_" + vInFile.getName());
        errorHandling(ret);
        return ret;
    }
}
