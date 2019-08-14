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
import java.util.ArrayList;
import java.util.List;

import de.uni_potsdam.hpi.asg.common.invoker.ExternalToolsInvoker;
import de.uni_potsdam.hpi.asg.common.invoker.InvokeReturn;
import de.uni_potsdam.hpi.asg.common.technology.Technology;

public class AsgDrivestrengthInvoker extends ExternalToolsInvoker {

    private AsgDrivestrengthInvoker() {
        super("asgdrivestrength");
    }

    /**
     * may only work with local invoker
     * 
     * @param vInFile
     * @param params
     * @param tech
     * @param vOutFile
     * @return
     */
    public static InvokeReturn invoke(File vInFile, AsgDrivestrengthParams params, Technology tech, File vOutFile) {
        return new AsgDrivestrengthInvoker().internalInvoke(vInFile, params, tech, vOutFile);
    }

    private InvokeReturn internalInvoke(File vInFile, AsgDrivestrengthParams params, Technology tech, File vOutFile) {
        List<String> dsArgs = new ArrayList<String>();

        if(tech == null) {
            return null;
        }
        dsArgs.add("-lib");
        dsArgs.add(tech.getLibertyFile().getAbsolutePath());
        if(tech.getAdditionalInfoFile() != null) {
            dsArgs.add("-cellInfoJson");
            dsArgs.add(tech.getAdditionalInfoFile().getAbsolutePath());
        }

        if(vOutFile == null) {
            return null;
        }
        dsArgs.add("-out");
        dsArgs.add(vOutFile.getName());
        addOutputFilesToExport(vOutFile);

        if(params != null) {
            if(params.getOptimizer() != null) {
                dsArgs.add("-optimizer");
                dsArgs.add(params.getOptimizer().toString());
            }

//            if(params.getOptimizeDelayFactor() != null && params.getOptimizeEnergyFactor() != null && params.getOptimizePowerFactor() != null) {
//                dsArgs.add("-optimizeEnergyPercentage");
//                Integer val = 0;
//                if(params.getOptimizeDelayFactor() > 0) {
//                    val = 0;
//                } else if(params.getOptimizePowerFactor() > 0) {
//                    val = 100;
//                }
//                dsArgs.add(val.toString());
//            }

            if(params.getOptimizeDelayFactor() != null) {
                dsArgs.add("-optimizeDelayFactor");
                dsArgs.add(params.getOptimizeDelayFactor().toString());
            }

            if(params.getOptimizeEnergyFactor() != null) {
                dsArgs.add("-optimizeEnergyFactor");
                dsArgs.add(params.getOptimizeEnergyFactor().toString());
            }

            if(params.getOptimizePowerFactor() != null) {
                dsArgs.add("-optimizePowerFactor");
                dsArgs.add(params.getOptimizePowerFactor().toString());
            }

            if(params.getOutputPinCapacitance() != null) {
                dsArgs.add("-outputPinCapacitance");
                dsArgs.add(params.getOutputPinCapacitance().toString());
            }

            if(params.getInputDrivenMaxCIn() != null) {
                dsArgs.add("-inputDrivenMaxCIn");
                dsArgs.add(params.getInputDrivenMaxCIn().toString());
            }

            if(params.getSdcOutFile() != null) {
                dsArgs.add("-outSdc");
                dsArgs.add(params.getSdcOutFile().getName());
                addOutputFilesToExport(params.getSdcOutFile());
            }

            if(params.getLogFile() != null) {
                dsArgs.add("-log");
                dsArgs.add(params.getLogFile().getName());
                addOutputFilesToExport(params.getLogFile());
            }

            if(params.getSkipFlattener() != null && params.getSkipFlattener()) {
                dsArgs.add("-skipFlattener");
            }

            if(params.getDebug() != null && params.getDebug()) {
                dsArgs.add("-debug");
            }
        }

        if(vInFile == null) {
            return null;
        }
        dsArgs.add(vInFile.getAbsolutePath());
        addInputFilesToCopy(vInFile);

        InvokeReturn ret = run(dsArgs, "asgdrivestrength_" + vInFile.getName());
        errorHandling(ret);
        return ret;
    }
}
