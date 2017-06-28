package com.jedlab.shell.cmd;

import com.jedlab.shell.rest.LsResource;

public class Ls implements Executable
{

    public Ls()
    {
        super();
    }

    public void execute(String[] args) throws Exception
    {
        LsResource lsResource = new LsResource();
        lsResource.ls();
    }
}