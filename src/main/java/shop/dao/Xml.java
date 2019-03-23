package shop.dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.File;

/**
 * Created by Администратор on 28.02.2018.
 */
public class Xml {

    public String getConfig(){
        XStream xs = new XStream(new StaxDriver());
        Config con = new Config();
        xs.fromXML(new File("config.xml"),con);
        return con.conn;
    }

}
