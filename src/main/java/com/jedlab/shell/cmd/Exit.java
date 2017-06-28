package com.jedlab.shell.cmd;

public class Exit implements Executable
{
    public Exit()
    {
        super();
    }

    public void execute(String[] args) throws Exception
    {
        System.out.println("Bye");
        System.exit(0);
    }

}
