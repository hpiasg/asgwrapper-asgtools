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
import java.util.Arrays;
import java.util.List;

import de.uni_potsdam.hpi.asg.common.invoker.ExternalToolsInvoker;
import de.uni_potsdam.hpi.asg.common.invoker.InvokeReturn;
import de.uni_potsdam.hpi.asg.common.technology.Technology;
import de.uni_potsdam.hpi.asg.protocols.io.main.Protocol;

public class AsgResynInvoker extends ExternalToolsInvoker {

    private AsgResynInvoker() {
        super("asgresyn");
    }

    public static InvokeReturn resynthesise(File breezeFile, AsgResynParams params, Technology tech, Protocol protocol, File outFile) {
        return new AsgResynInvoker().internalResynthesise(breezeFile, params, tech, protocol, outFile);
    }

    private InvokeReturn internalResynthesise(File breezeFile, AsgResynParams params, Technology tech, Protocol protocol, File outFile) {
        List<String> resynArgs = new ArrayList<String>();

        if(tech == null) {
            return null;
        }
        resynArgs.add("-tech");
        resynArgs.add(tech.getName());

        if(protocol == null) {
            return null;
        }
        resynArgs.add("-hs");
        resynArgs.add(protocol.getName());

        if(outFile == null) {
            return null;
        }
        resynArgs.add("-sout");
        resynArgs.add(outFile.getName());
        addOutputFilesToExport(outFile);

        if(params != null) {
            if(params.getTackleComplexityStrategy() != null) {
                switch(params.getTackleComplexityStrategy()) {
                    case BreezeDeco:
                        resynArgs.addAll(Arrays.asList("-tc", "D", "-p", "common-cause", "-d", "breeze"));
                        break;
                    case Straight:
                        resynArgs.addAll(Arrays.asList("-tc", "S"));
                        break;
                }
            }

            if(params.getLogicSynthesisProcedure() != null) {
                resynArgs.add("-ls");
                resynArgs.add(params.getLogicSynthesisProcedure().toString());
            }

            if(params.getOptimiseDataPath() != null && params.getOptimiseDataPath()) {
                resynArgs.add("-odp");
            }

            if(params.getUseDesiJbreeze2stg() != null && params.getUseDesiJbreeze2stg()) {
                resynArgs.add("-desijbreeze2stg");
                if(params.getBreezeExprFile() != null) {
                    resynArgs.add("-breezeexpr");
                    resynArgs.add(params.getBreezeExprFile().getName());
                    addInputFilesToCopy(params.getBreezeExprFile());
                }
            }

            if(params.getAsgLogicParams() != null) {
                resynArgs.add("-ASGlogicParams");
                resynArgs.add(params.getAsgLogicParams());
            }

            if(params.getZipFile() != null) {
                resynArgs.add("-zip");
                resynArgs.add(params.getZipFile().getName());
                addOutputFilesToExport(params.getZipFile());
            }

            if(params.getLogFile() != null) {
                resynArgs.add("-log");
                resynArgs.add(params.getLogFile().getName());
                addOutputFilesToExport(params.getLogFile());
            }

            if(params.getStgOutFile() != null) {
                resynArgs.add("-stgout");
                resynArgs.add(params.getStgOutFile().getName());
                addOutputFilesToExport(params.getStgOutFile());
            }

            if(params.getConfigFile() != null) {
                resynArgs.add("-cfg");
                resynArgs.add(params.getConfigFile().getAbsolutePath());
            }

            if(params.getToolConfigFile() != null) {
                resynArgs.add("-toolcfg");
                resynArgs.add(params.getToolConfigFile().getAbsolutePath());
            }

            if(params.getSkipSubComponents() != null && params.getSkipSubComponents()) {
                resynArgs.add("-ssc");
            }

            if(params.getSkipDataPath() != null && params.getSkipDataPath()) {
                resynArgs.add("-sdp");
            }

            if(params.getDebug() != null && params.getDebug()) {
                resynArgs.add("-debug");
            }
        }

        if(breezeFile == null) {
            return null;
        }
        resynArgs.add(breezeFile.getAbsolutePath());
        addInputFilesToCopy(breezeFile);

        InvokeReturn ret = run(resynArgs, "asgresyn_" + breezeFile.getName());
        errorHandling(ret);
        return ret;
    }
}
