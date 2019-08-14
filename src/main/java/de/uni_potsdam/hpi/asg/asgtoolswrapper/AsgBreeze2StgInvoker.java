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
import de.uni_potsdam.hpi.asg.protocols.io.main.Protocol;

public class AsgBreeze2StgInvoker extends ExternalToolsInvoker {

    private AsgBreeze2StgInvoker() {
        super("asgbreeze2stg");
    }

    public static InvokeReturn breeze2stg(File outFile, File inFile, Protocol hsProtocol) {
        return new AsgBreeze2StgInvoker().internalBreeze2stg(outFile, inFile, hsProtocol);
    }

    private InvokeReturn internalBreeze2stg(File outFile, File inFile, Protocol hsProtocol) {
        List<String> params = new ArrayList<>();
        //@formatter:off
        params.addAll(Arrays.asList(
            "-debug", 
            "-out", outFile.getName(),
            "-hs", hsProtocol.getName(),
            inFile.getName()
        ));
        //@formatter:on

        addInputFilesToCopy(inFile);
        addOutputFilesToExport(outFile);

        InvokeReturn ret = run(params, "breeze2stg");
        errorHandling(ret);
        return ret;
    }
}