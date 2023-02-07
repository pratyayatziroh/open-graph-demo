package com.open.graph.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pratyay Ganguli
 */

public class OpenGraphMetaDataProperties {
    private static List<String> properties = new ArrayList<>();
    private OpenGraphMetaDataProperties(){

    }
    public static void loadProperties(){
        properties.add("og:image");
        properties.add("og:title");
        properties.add("og:description");
        properties.add("og:type");
        properties.add("og:url");
        properties.add("og:locale");
        properties.add("og:site_name");
        properties.add("og:audio");
        properties.add("og:video");
    }

    public static List<String> getProperties(){
        loadProperties();
        return properties;
    }

    public static boolean isValidProperty(String property){
        loadProperties();
        for(var ogProperty: properties){
            if(property.equals(ogProperty)){
                return true;
            }
        }
        return false;
    }
}
