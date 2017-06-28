package com.jedlab.shell;

import static com.jedlab.shell.util.Constant.CD;
import static com.jedlab.shell.util.Constant.CLEAR;
import static com.jedlab.shell.util.Constant.EXIT;
import static com.jedlab.shell.util.Constant.LS;

import java.net.SocketException;

import com.jedlab.shell.cmd.Cd;
import com.jedlab.shell.cmd.Clear;
import com.jedlab.shell.cmd.Executable;
import com.jedlab.shell.cmd.Exit;
import com.jedlab.shell.cmd.Ls;
import com.jedlab.shell.registry.PathRegistry;
import com.jedlab.shell.util.Banner;
import com.jedlab.shell.util.Util;

public class Launcher
{

    public static void main(String[] args) throws Exception
    {
        System.out.println(Banner.get());
        shell();
    }

    private static void shell() throws Exception
    {
        while (true)
        {
            try
            {
                prompt();
                String[] args = Util.getArgs();
                commandSelector(args);
            }
            catch (SocketException e)
            {
                System.out.println("Network is unreachable");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        }
    }

    private static void commandSelector(String[] args) throws Exception
    {
        final String command = args[0];
        Executable exec = null;
        
        if (LS.equals(command))
        {
            exec = new Ls();
        }        
        else if (CD.equals(command))
        {
            exec = new Cd();
        }
        else if (CLEAR.equals(command))
        {
            exec = new Clear();
        }
        else if (EXIT.equals(command))
        {
            exec = new Exit();
        }
        if(exec == null)
        {
            System.out.println("invalid command");
        }
        else
        {
            exec.execute(args);    
        }
        
    }



    private static void prompt()
    {
        PathRegistry pathRegistry = PathRegistry.getInstance();
        
    }
}
