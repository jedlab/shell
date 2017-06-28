package com.jedlab.shell.registry;

import java.util.ArrayList;
import java.util.List;

public class PathRegistry
{
    private static PathRegistry instance = null;

    private List<String> registry;

    private PathRegistry()
    {
        registry = new ArrayList<String>();
    }

    public static PathRegistry getInstance()
    {
        if (instance == null)
        {
            synchronized (PathRegistry.class)
            {
                if (instance == null)
                {
                    instance = new PathRegistry();
                }
            }
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public void forwardPath(String folderName)
    {
        if (folderName == null || folderName.length() == 0) throw new NullPointerException("folderName arg is either null or empty.");
        registry.add(folderName);
    }

    public String backwardPath()
    {
        String lastFolder = registry.get(registry.size() - 1);
        registry.remove(lastFolder);
        return lastFolder;
    }

    public String getPath()
    {
        if(registry.size() == 0)
            return null;
        String s = "";

        for (String p : registry)
        {
            s += ("/" + p);
        }
        return s;
    }

    @Override
    public String toString()
    {
        return registry.toString();
    }

}
