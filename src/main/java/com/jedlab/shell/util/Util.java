package com.jedlab.shell.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Util
{
    public static String getArg() throws Exception
    {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferRead.readLine();
        line = line.trim();
        return line;
    }

    public static String[] getArgs() throws Exception
    {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferRead.readLine();
        line = line.trim();
        String args[] = line.split(" ");
        return args;
    }

}
