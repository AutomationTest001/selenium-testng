package com.selenium.testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws Exception {

		String projectPath = System.getProperty("user.dir");
		String configFilePath = projectPath + "\\Config_Info\\config.properties";

		FileInputStream fin = new FileInputStream(configFilePath);
		
		Properties prop=new Properties();
		prop.load(fin);
		
		String os=prop.getProperty("os");
		String url=prop.getProperty("fd_url");
		String br=prop.getProperty("browser");
		
		System.out.println(os);
		System.out.println(url);
		System.out.println(br);
		
		
		fin.close();

	}

}
