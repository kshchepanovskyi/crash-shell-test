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

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class UsernamePasswordCallbackHandler implements CallbackHandler
{
    private String _user;
    private String _password;

    public UsernamePasswordCallbackHandler(String user, String password)
    {
        super();
        _user = user;
        _password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
    {
        for (Callback callback : callbacks)
        {
            if (callback instanceof NameCallback)
            {
                handleName((NameCallback)callback);
            }
            else if (callback instanceof PasswordCallback)
            {
                handlePassword((PasswordCallback)callback);
            }
            else
            {
                throw new UnsupportedCallbackException(callback);
            }
        }
    }

    private void handleName(NameCallback callback)
    {
        callback.setName(_user);
    }

    private void handlePassword(PasswordCallback callback)
    {
        char[] passwordChars = _password.toCharArray();
        callback.setPassword(passwordChars);
    }
}