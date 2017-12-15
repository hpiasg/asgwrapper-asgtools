package de.uni_potsdam.hpi.asg.asgtoolswrapper;

/*
 * Copyright (C) 2017 Norman Kluge
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

public class AsgLogicInvoker extends ExternalToolsInvoker {

    private AsgLogicInvoker() {
        super("asglogic");
    }

    public static InvokeReturn synthesise(File inFile, File libFile, String resetType, String additionalParams, File logFile, File zipFile, File outFile) {
        return new AsgLogicInvoker().internalSynthesise(inFile, libFile, resetType, additionalParams, logFile, zipFile, outFile);
    }

    private InvokeReturn internalSynthesise(File inFile, File libFile, String resetType, String additionalParams, File logFile, File zipFile, File outFile) {
        if(zipFile == null) {
            zipFile = new File(logFile.getParentFile(), logFile.getName().replace(".log", ".zip"));
        }

        List<String> params = new ArrayList<>();
        //@formatter:off
        params.addAll(Arrays.asList(
            "-debug", 
            "-out", outFile.getName(),
            "-lib", libFile.getName(), 
            "-log", logFile.getName(), 
            "-zip", zipFile.getName(), 
            "-rst", resetType
        ));
        //@formatter:on
        if(additionalParams != null && !additionalParams.equals("")) {
            params.addAll(Arrays.asList(additionalParams.split(" ")));
        }
        params.add(inFile.getName());

        addInputFilesToCopy(inFile, libFile);
        addOutputFilesToExport(outFile, logFile, zipFile);

        InvokeReturn ret = run(params, "asglogic_" + inFile.getName());
        errorHandling(ret);
        return ret;
    }
}
