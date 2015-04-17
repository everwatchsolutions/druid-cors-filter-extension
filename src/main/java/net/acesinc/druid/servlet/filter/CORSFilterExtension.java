/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.druid.servlet.filter;

import com.fasterxml.jackson.databind.Module;
import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;
import io.druid.initialization.DruidModule;
import io.druid.server.initialization.jetty.ServletFilterHolder;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author andrewserff
 */
public class CORSFilterExtension implements DruidModule {
    private static final Logger log = Logger.getLogger(CORSFilterExtension.class);
    
    @Override
    public List<? extends Module> getJacksonModules() {
        return ImmutableList.of();
    }

    @Override
    public void configure(Binder binder) {
        Multibinder<ServletFilterHolder> multibinder = Multibinder.newSetBinder(binder, ServletFilterHolder.class);
        
        ServletFilterHolder holder = null;
        
        holder = new CORSServletFilterHolder();
//        holder = new SimpleCORSServletFilterHolder();
        multibinder.addBinding().toInstance(holder);
        
    }

}
