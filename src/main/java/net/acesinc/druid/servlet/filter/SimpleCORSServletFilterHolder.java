/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.druid.servlet.filter;

import io.druid.server.initialization.jetty.ServletFilterHolder;
import java.util.EnumSet;
import java.util.Map;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import org.apache.log4j.Logger;

/**
 *
 * @author andrewserff
 */
public class SimpleCORSServletFilterHolder implements ServletFilterHolder {
    private static final Logger log = Logger.getLogger(SimpleCORSServletFilterHolder.class);
    
    @Override
    public Filter getFilter() {
        return null;
    }

    @Override
    public Class<? extends Filter> getFilterClass() {
        return SimpleCORSServletFilter.class;
    }

    @Override
    public Map<String, String> getInitParameters() {
        return null;
    }

    @Override
    public String getPath() {
        return "/*";
    }

    @Override
    public EnumSet<DispatcherType> getDispatcherType() {
        return null;
    }
    
}
