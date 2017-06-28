package com.jedlab.shell.rest;

import java.io.File;

import com.jedlab.shell.registry.PathRegistry;
import com.jedlab.shell.util.CommandLineExecutor;



public class LsResource
{
    public LsResource()
    {
        super();
    }
    
    public void ls()
    {
        CommandLineExecutor cmd = new CommandLineExecutor("ls");
        try
        {
            if(PathRegistry.getInstance().getPath() != null)
                cmd.execute(new String[]{System.getProperty("user.home") + File.separator + PathRegistry.getInstance().getPath()});
            else
                cmd.execute(null);
                
             
            System.out.println(cmd.getOutput());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }

    
}
