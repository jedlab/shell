package com.jedlab.shell.cmd;

public class Clear implements Executable
{
    public Clear()
    {
        super();
    }

    public void execute(String[] args) throws Exception
    {
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }
}
