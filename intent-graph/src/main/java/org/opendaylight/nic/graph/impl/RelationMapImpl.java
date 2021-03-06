/*
 * Copyright (c) 2015 Hewlett Packard Enterprise Development Company, L.P. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.nic.graph.impl;

import org.opendaylight.nic.mapping.api.IntentMappingService;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to implement Label tree Map
 */

public class RelationMapImpl {
    protected IntentMappingService labelRelationMap;

    public RelationMapImpl(IntentMappingService mappingSvc) {
        this.labelRelationMap = mappingSvc;
    }

    /* Method to add a relationship between EPGs.
     * @param keyLabel EPG Label name
     * @param valueLabel EPG Label name
     */
    public boolean addLabelRelation(String keyLabel, String valueLabel) {
        Map<String, String> map = new HashMap<>();
        map.put(keyLabel, valueLabel);
        labelRelationMap.add(keyLabel, map); //add key/object to map
        return true;
    }
    /* Method to check if a label has a relationship without another label and vice versa */
    public boolean hasRelation(String keyLabel, String valueLabel) throws NullPointerException {
        Map<String, String> map = new HashMap<>();
        map.put(keyLabel, valueLabel);
        if (labelRelationMap != null) {
            if (labelRelationMap.get(keyLabel).containsKey(valueLabel) || labelRelationMap.get(valueLabel).containsKey(keyLabel)) {
                return true;
            }
            else if (labelRelationMap.get(keyLabel).containsValue(valueLabel)) {
                return true;
            }
        }
        return false;
    }
}
