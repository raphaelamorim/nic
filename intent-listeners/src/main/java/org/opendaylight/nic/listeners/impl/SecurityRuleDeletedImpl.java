/*
 * Copyright (c) 2015 Hewlett Packard Enterprise Development LP.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.nic.listeners.impl;

import org.opendaylight.nic.listeners.api.SecurityRuleDeleted;

import java.sql.Timestamp;
import java.util.Date;

//TODO: Add relevant fields to this POJO
public class SecurityRuleDeletedImpl implements SecurityRuleDeleted {
    private final Timestamp timeStamp;

    public SecurityRuleDeletedImpl() {
        Date date= new Date();
        timeStamp = new Timestamp(date.getTime());
    }
    @Override
    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}