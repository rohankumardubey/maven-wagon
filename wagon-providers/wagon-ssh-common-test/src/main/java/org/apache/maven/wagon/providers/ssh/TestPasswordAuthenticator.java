package org.apache.maven.wagon.providers.ssh;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.sshd.server.PasswordAuthenticator;
import org.apache.sshd.server.session.ServerSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olivier Lamy
 */
public class TestPasswordAuthenticator
    implements PasswordAuthenticator
{
    public List<PasswordAuthenticatorRequest> passwordAuthenticatorRequests =
        new ArrayList<PasswordAuthenticatorRequest>();

    public boolean authenticate( String username, String password, ServerSession session )
    {
        passwordAuthenticatorRequests.add( new PasswordAuthenticatorRequest( username, password ) );
        return true;
    }

    public static class PasswordAuthenticatorRequest
    {
        public String username;

        public String password;

        public PasswordAuthenticatorRequest( String username, String password )
        {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder();
            sb.append( "PasswordAuthenticatorRequest" );
            sb.append( "{username='" ).append( username ).append( '\'' );
            sb.append( ", password='" ).append( password ).append( '\'' );
            sb.append( '}' );
            return sb.toString();
        }
    }
}
