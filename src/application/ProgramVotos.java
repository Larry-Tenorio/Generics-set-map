package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProgramVotos {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votos = new TreeMap<>();

		
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				int contar = Integer.parseInt(fields[1]);
				
				if(votos.containsKey(nome)) {
					int votosAteAgora = votos.get(nome);
					votos.put(nome, contar + votosAteAgora);
				}
				else {
					votos.put(nome, contar);
				}
				
				line = br.readLine();
			}
			
			for(String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
