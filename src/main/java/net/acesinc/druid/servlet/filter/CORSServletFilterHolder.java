/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.druid.servlet.filter;

import io.druid.server.initialization.jetty.ServletFilterHolder;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author andrewserff
 */
public class CORSServletFilterHolder implements ServletFilterHolder {

    private List<String> allowedOrigins;
    
    public CORSServletFilterHolder() {
        allowedOrigins = new ArrayList<>();
        
    }
    
    public void addAllowedOrigin(String url) {
       if (!allowedOrigins.contains(url)) {
           allowedOrigins.add(url);
       }
    }
    
    @Override
    public Filter getFilter() {
        return null;
    }

    @Override
    public Class<? extends Filter> getFilterClass() {
        return org.ebaysf.web.cors.CORSFilter.class;
    }

    @Override
    public Map<String, String> getInitParameters() {
        Map<String, String> initParams = new HashMap<>();
        if (!allowedOrigins.isEmpty()) {
            initParams.put("cors.allowed.origins", StringUtils.join(allowedOrigins, ','));
        }
        
        if (initParams.isEmpty()) {
            return null;
        } else {
            return initParams;
        }
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
