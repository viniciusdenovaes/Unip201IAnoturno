package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entity.Tabuleiro;

public class Dao {
	
	private String path;
	
	public Dao(String aPath) {
		this.path = aPath;
	}
	
	public Tabuleiro getInstance() {
		try {
			
			BufferedReader csvReader = 
					new BufferedReader(
							new FileReader(this.path));
			String row;
			while((row = csvReader.readLine()) != null) {
				System.out.println(row);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
