package cc.zy.base.common.paymentUtils.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	    private Properties props;      
	        
	    public PropertiesUtil(String fileName){      
	        readProperties(fileName);      
	    } 
	    
	    private void readProperties(String fileName) {      
	        try {      
	            props = new Properties();      
	            InputStream fis =getClass().getResourceAsStream(fileName);      
	            props.load(fis);        
	        } catch (Exception e) {      
	            e.printStackTrace();      
	        }      
	    } 
	    
	    /**   
	     * 获取某个属性   
	     */      
	    public String getProperty(String key){      
	        return props.getProperty(key);      
	    }      

}
