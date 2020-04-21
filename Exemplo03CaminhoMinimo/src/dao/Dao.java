package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entity.Aresta;
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
		Grafo g = new Grafo();
		try {
			
			BufferedReader reader = 
					new BufferedReader(
							new FileReader(this.path));
			int quantidadeVertices;
			quantidadeVertices = Integer.parseInt(reader.readLine());
			System.out.println("Quantidade de vertices: " + quantidadeVertices);
			for(int i=0; i<quantidadeVertices; i++) {
				String linha = reader.readLine();
				String[] palavras = linha.split(" ");
				String nome = palavras[0];
				double x = Double.parseDouble(palavras[1]) * pixelParaMetro;
				double y = Double.parseDouble(palavras[2]) * pixelParaMetro;
				Coordenada c = new Coordenada(x, y);
				Vertice v = new Vertice(nome);
				g.addVertice(v, c);
			}
			int quantidadeArestas = Integer.parseInt(reader.readLine());
			for(int i=0; i<quantidadeArestas; i++) {
				String linha = reader.readLine();
				String[] palavras = linha.split(" ");
				String nomeA = palavras[0]; Vertice vA = new Vertice(nomeA);
				String nomeB = palavras[1]; Vertice vB = new Vertice(nomeB);
				double valor = Double.parseDouble(palavras[2]);
				Aresta arestaAparaB = new Aresta(valor, vB); g.addAresta(vA, arestaAparaB);
				Aresta arestaBparaA = new Aresta(valor, vA); g.addAresta(vB, arestaBparaA);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return g;
		
	}

}
