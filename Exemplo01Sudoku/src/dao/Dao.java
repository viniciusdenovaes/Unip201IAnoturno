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
		Tabuleiro t = new Tabuleiro();
		try {
			
			BufferedReader csvReader = 
					new BufferedReader(
							new FileReader(this.path));
			String row;
			int i=0;
			while((row = csvReader.readLine()) != null) {
				String[] cells = row.split(" ");
				for(int j=0; j<cells.length; j++) {
					if(!cells[j].equals(" ") && cells[j].length()>0)
						t.setCell(i, j, Integer.parseInt(cells[j]));
				}
				i++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return t;
		
	}

}
