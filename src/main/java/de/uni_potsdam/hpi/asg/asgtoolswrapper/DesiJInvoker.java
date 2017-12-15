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

public class DesiJInvoker extends ExternalToolsInvoker {

    private DesiJInvoker() {
        super("desij");
    }

    public static InvokeReturn killDummies(File outFile, File inFile) {
        return new DesiJInvoker().internalKillDummies(outFile, inFile);
    }

    public static InvokeReturn decompose(String decompositionStrategy, String partitionStrategy, File inFile) {
        return new DesiJInvoker().internalDecompose(decompositionStrategy, partitionStrategy, inFile);
    }

    public static InvokeReturn breeze2stg(File outFile, File inFile, boolean withDeco, File breezeExprFile) {
        return new DesiJInvoker().internalBreeze2stg(outFile, inFile, withDeco, breezeExprFile);
    }

    private InvokeReturn internalKillDummies(File outFile, File inFile) {
        //@formatter:off
        List<String> params = Arrays.asList(
            "-Y", "-t", 
            "operation=killdummiesrelaxed", 
            "outfile=" + outFile.getName(),
            inFile.getName()
        );
        //@formatter:on

        addInputFilesToCopy(inFile);
        addOutputFilesToExport(outFile);

        InvokeReturn ret = run(params, "killdummies");
        errorHandling(ret);
        return ret;
    }

    private InvokeReturn internalDecompose(String decompositionStrategy, String partitionStrategy, File inFile) {
        //@formatter:off
        List<String> params = Arrays.asList(
            "-Y", "-t", 
            "operation=decompose", 
            "version=" + decompositionStrategy, 
            "partition=" + partitionStrategy, 
            inFile.getName()
        );
        //@formatter:on

        addInputFilesToCopy(inFile);
        addOutputFilesToCopyStartsWith(inFile.getName() + "__final_");

        InvokeReturn ret = run(params, "decompose");
        errorHandling(ret);
        return ret;
    }

    private InvokeReturn internalBreeze2stg(File outFile, File inFile, boolean withDeco, File breezeExprFile) {
        List<String> params = new ArrayList<>();
        params.add("-Y");
        if(withDeco) {
            params.add("-g");
        }
        params.add("operation=breeze");
        if(breezeExprFile != null) {
            params.add("breezeexpressionsfile=" + breezeExprFile.getName());
        }
        params.add("outfile=" + outFile.getName());
        params.add(inFile.getName());

        addInputFilesToCopy(inFile);
        if(breezeExprFile != null) {
            addInputFilesToCopy(breezeExprFile);
        }
        addOutputFilesToExport(outFile);

        InvokeReturn ret = run(params, "breeze2stg");
        errorHandling(ret);
        return ret;
    }
}
