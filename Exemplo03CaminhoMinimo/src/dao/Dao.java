package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entity.Coordenada;
import entity.Grafo;
import entity.Vertice;

public class Dao {
	
	public static final double pixelParaMetro = 1.0/4.0;
	
	private String path;
	
	public Dao(String aPath) {
		this.path = aPath;
	}
	
	public Grafo getInstance() {
		Grafo g = null;
		try {
			
			BufferedReader reader = 
					new BufferedReader(
							new FileReader(this.path));
			int quantidadeVertices;
			quantidadeVertices = Integer.parseInt(reader.readLine());
			System.out.println("Quantidade de vertices: " + quantidadeVertices);
			g = new Grafo(quantidadeVertices);
			
			for(int i=0; i<quantidadeVertices; i++) {
				String linha = reader.readLine();
				String[] palavras = linha.split(" ");
				String nome = palavras[0];
				double x = Double.parseDouble(palavras[1]) * pixelParaMetro;
				double y = Double.parseDouble(palavras[2]) * pixelParaMetro;
				Coordenada c = new Coordenada(x, y);
				Vertice v = new Vertice(i, nome, c);
				g.addVertice(v);
			}
			
			int quantidadeArestas = Integer.parseInt(reader.readLine());
			for(int i=0; i<quantidadeArestas; i++) {
				String linha = reader.readLine();
				String[] palavras = linha.split(" ");
				String nomeA = palavras[0]; Vertice vA = g.getVertice(nomeA);
				String nomeB = palavras[1]; Vertice vB = g.getVertice(nomeB);
				double valor = Double.parseDouble(palavras[2]);
				g.addAresta(vA, vB, valor);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return g;
		
	}

}
