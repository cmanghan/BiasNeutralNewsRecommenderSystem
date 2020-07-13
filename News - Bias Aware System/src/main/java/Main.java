import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 * 
 * 
 * 
 * @author Caroline Manghan
 *
 */
public class Main {
	
	static List<Article> itemList = Arrays.asList();	
	static Article article = new Article();


	public static void main(String[] args) throws IOException {
		
		//String to hold the neame of the file being read in
		String fileName = "NewsArticlesProjectCSV.csv"; 
		
		//call the processInputFile and pass the file's name
		processInputFile(fileName); 
		
		//call the promptUser method
		promptUser();
		
	}
	
	//method to input articles
	private static void processInputFile(String fileName) {
		
		//read in data from the file
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
			
			//read in the data, skipping the first line (the first line holds column titles)
			itemList=br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close(); //close the buffered reader		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		//function to map the data to an article object
		private static Function<String, Article> mapToItem = (line) -> {
			//split the csv data by comma
			String [] dataIndex = line.split(","); 
			Article item = new Article();
			
			//set the attributes according to their index in the inputed data
			item.setDatabaseID(dataIndex[0]);	
			item.setTitle(dataIndex[1]);			
			item.setAuthor(dataIndex[2]); 
			item.setSource(dataIndex[3]);
			item.setWeight(dataIndex[4]);
			item.setURL(dataIndex[5]);
			item.setContent(dataIndex[6]);
			
			return item;
		};

		//promptUser method interacts with the user 
		public static void promptUser() {
			Scanner scanner = new Scanner(System.in);
			
			//ask the user which term they would like to search and set it to the variable term
			System.out.println("Enter term to search");
			String term = scanner.nextLine();
			
			//ask the user if they would like to search that term in the title or the article body
			System.out.println("Enter 1 to search for '" + term + "' in the article title. Enter 2 to search in the article body");
			int where = scanner.nextInt();
				
			//if the user wants to search the title, call the searchTitle method
			if (where ==1) {
				article.searchTitle(itemList, term);
			}
			
			//if the user wants to search the body of the article, call the searchBody method
			else if (where == 2) {
				article.searchBody(itemList, term);
			}
			
			//if the user enters anything else alert them of the invalid input and call the method again
			else {
				System.out.println("Invalid input. Please try again");
				promptUser();
			}
		}
	
}
	