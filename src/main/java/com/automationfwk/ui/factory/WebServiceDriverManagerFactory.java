package com.automationfwk.ui.factory;

import com.automationfwk.config.josnmodels.EnvironmentConfigJsonModel;
import com.automationfwk.constants.AuthenticationType;
import com.automationfwk.drivers.TokenAuthWebServiceDriverManager;
import com.automationfwk.drivers.WebServiceDriverManager;


public class WebServiceDriverManagerFactory 
{

	public static WebServiceDriverManager getManager(AuthenticationType authType,EnvironmentConfigJsonModel config) throws Exception{
        switch (authType){
            case BEARERTOKEN -> {
                return new TokenAuthWebServiceDriverManager(config);
            }
            case COOKIE -> {
                return new TokenAuthWebServiceDriverManager(config);
            }
            default -> throw new IllegalStateException("Unsupported auth type: " + authType);
        }
    }
}
