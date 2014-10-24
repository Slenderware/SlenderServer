/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slender.app.factory;

import com.slender.domain.Priority;

public class PriorityFactory {
    public Priority getPriority(String pri){
        Priority priority = new Priority();
        priority.setPriority(pri);
        return priority;
    }
}
