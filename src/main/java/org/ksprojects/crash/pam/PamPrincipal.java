// The MIT License (MIT)
//
// Copyright (c) 2014 Dirk Olmes
//
// https://github.com/dirk-olmes/jaas-pam
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
package org.ksprojects.crash.pam;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;

import org.jvnet.libpam.UnixUser;

public class PamPrincipal implements Principal
{
    private String _userName;
    private String _gecos;
    private String _homeDir;
    private String _shell;
    private int _uid;
    private int _gid;
    private Set<String> _groups;

    public PamPrincipal(UnixUser user)
    {
        super();
        _userName = user.getUserName();
        _gecos = user.getGecos();
        _homeDir = user.getDir();
        _shell = user.getShell();
        _uid = user.getUID();
        _gid = user.getGID();
        _groups = Collections.unmodifiableSet(user.getGroups());
    }

    @Override
    public String getName()
    {
        return _userName;
    }

    public String getGecos()
    {
        return _gecos;
    }

    public String getHomeDir()
    {
        return _homeDir;
    }

    public String getShell()
    {
        return _shell;
    }

    public int getUid()
    {
        return _uid;
    }

    public int getGid()
    {
        return _gid;
    }

    public Set<String> getGroups()
    {
        return _groups;
    }
}