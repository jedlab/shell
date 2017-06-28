package com.jedlab.shell.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteResultHandler;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

import com.jedlab.shell.cmd.Executable;

public class CommandLineExecutor implements Executable
{

    private String commandLine;
    private String output;

    public CommandLineExecutor(String commandLine)
    {
        this.commandLine = commandLine;
    }

    public void execute(String[] args) throws Exception
    {
        CommandLine cmdLine = new CommandLine(commandLine);
        if(args != null && args.length > 0)
        {
            for (int i = 0; i < args.length; i++)
            {
                cmdLine.addArgument(args[i]);
            }
        }
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        DefaultExecutor executor = new DefaultExecutor();
        executor.setWorkingDirectory(new File(System.getProperty("user.home")));        
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        PumpStreamHandler stream = new PumpStreamHandler(System.out);
        PumpStreamHandler stream = new PumpStreamHandler(bao);
        executor.setStreamHandler(stream);
        ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
        executor.setWatchdog(watchdog);
        try
        {
            executor.execute(cmdLine, resultHandler);
            resultHandler.waitFor(3000);
            output = new String(bao.toByteArray(), "UTF-8");
        }
        catch (ExecuteException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public String getOutput()
    {
        return output;
    }
    
    
    
    

}
