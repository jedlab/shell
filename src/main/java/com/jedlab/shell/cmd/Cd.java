package com.jedlab.shell.cmd;

import java.io.File;

import com.jedlab.shell.registry.PathRegistry;
import com.jedlab.shell.util.CommandLineExecutor;

public class Cd implements Executable
{

    public Cd()
    {
        super();
    }

    public void execute(String[] args) throws Exception
    {
        CommandLineExecutor cmd = new CommandLineExecutor(args[0]);
        String[] newArgs = new String[args.length];
        for (int i = 1; i < args.length; i++)
        {
            newArgs[i] = System.getProperty("user.home") + File.separator + args[i];
        }
        cmd.execute(newArgs);
        String output = cmd.getOutput();
        PathRegistry.getInstance().forwardPath(args[1]);
        System.out.println(PathRegistry.getInstance().getPath());
    }
}