import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.text.WordUtils;

public class Article {
	
	//variables set to private for protection
	private String Title;
	private String Author; 
	private String Source;
	private String Weight;
	private String URL;
	private String Content;
	private String DatabaseID;
	
	//ArrayLists to hold articles when read in and split by political affiliation
	ArrayList <Article> farLeftList = new ArrayList <Article>();
	ArrayList <Article> leftList = new ArrayList <Article>();
	ArrayList <Article> centerList = new ArrayList <Article>();
	ArrayList <Article> rightList = new ArrayList <Article>();
	ArrayList <Article> farRightList = new ArrayList <Article>();
	ArrayList <Article> combinedList = new ArrayList <Article>();
	
	//opening scanner for interactive capabilities
	Scanner scanner = new Scanner (System.in);
	
	//empty default constructor
	public Article() {
		
	}

	//getter and setter for title
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}

	//getter and setter for author
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}

	//getter and setter for source
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}

	//getter and setter for weight
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}

	//getter and setter for URL
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}

	//getter and setter for content
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

	//getter and setter for database ID
	public String getDatabaseID() {
		return DatabaseID;
	}
	public void setDatabaseID(String databaseID) {
		DatabaseID = databaseID;
	}
	
	//searchTitle is invoked when a user wants to search for a term within the articles' title
	//takes in the list of articles and the term inputed by the user
	public void searchTitle(List<Article> itemList, String inputedTerm){ 
		
		//changes the inputed term to lowercase so that the user's casing does not affect the search
		String term = inputedTerm.toLowerCase();
		
		//for loop iterates through each article in the database
		for (int i = 0; i<itemList.size(); i++) {
			
			//searchTitle represents the title of the article currently being examined (in lowercase) 
			String searchTitle = itemList.get(i).getTitle().toLowerCase();
			
			//assigns each "match" to an array list based on its weighting
			if (searchTitle.contains(term) && itemList.get(i).getWeight().contains("-2")) {
				farLeftList.add(itemList.get(i));			
			}
			else if (searchTitle.contains(term) && itemList.get(i).getWeight().contains("-1")){
				leftList.add(itemList.get(i));
			}
			else if (searchTitle.contains(term) && itemList.get(i).getWeight().contains("0")){
				centerList.add(itemList.get(i));
			}
			else if (searchTitle.contains(term) && itemList.get(i).getWeight().contains("1")){
				rightList.add(itemList.get(i));
			}
			else if (searchTitle.contains(term) && itemList.get(i).getWeight().contains("2")){
				farRightList.add(itemList.get(i));
			}
				
		}
		//if all weighted arraylists are empty, alert the user the term could not be found
		if (farLeftList.size() == 0 && leftList.size() == 0 && centerList.size() == 0 && rightList.size() == 0 && farRightList.size() == 0) {
			System.out.print("No articles contain " + term);
		}
		//otherwise,the term could be found, calls the combineArticles method
		else {
			combineArticles(term);		
		}
	
	}
	
//searchBody is invoked when a user wants to search for a term within the articles' body
//takes in the list of articles and the term inputed by the user	
public void searchBody(List<Article> itemList, String inputedTerm){
		
		//changes the inputed term to lowercase so that the user's casing does not affect the search
		String term = inputedTerm.toLowerCase();
		
		//for loop iterates through each article in the database
		for (int i = 0; i<itemList.size(); i++) {
			
			//searchBody represents the title of the article currently being examined (in lowercase) 
			String searchBody = itemList.get(i).getContent().toLowerCase();
			
			//assigning each "match" to an array list based on its weighting
			if (searchBody.contains(term) && itemList.get(i).getWeight().contains("-2")) {
				farLeftList.add(itemList.get(i));			
			}
			else if (searchBody.contains(term) && itemList.get(i).getWeight().contains("-1")){
				leftList.add(itemList.get(i));
			}
			else if (searchBody.contains(term) && itemList.get(i).getWeight().contains("0")){
				centerList.add(itemList.get(i));
			}
			else if (searchBody.contains(term) && itemList.get(i).getWeight().contains("1")){
				rightList.add(itemList.get(i));
			}
			else if (searchBody.contains(term) && itemList.get(i).getWeight().contains("2")){
				farRightList.add(itemList.get(i));
			}
				
		}
		//if all weighted arraylists are empty, alert the user the term could not be found
		if (farLeftList.size() == 0 && leftList.size() == 0 && centerList.size() == 0 && rightList.size() == 0 && farRightList.size() == 0) {
			System.out.print("No articles contain " + term);
		}
		
		//otherwise,the term could be found, calls the combineArticles method
		else {
			combineArticles(term);		
		}	
		
	}
	
	//combineArticles creates an arrayList of articles across weights
	//takes in the search term
	public void combineArticles(String term) {
		
		int size =0;
		Article farLeftArticle = null ;
		Article leftArticle = null;
		Article centerArticle = null;
		Article rightArticle = null;
		Article farRightArticle = null;
		
		//if the farLeftList has at least one article in it
		if (farLeftList.size() > 0) {
			//generate a random article from the list
			int farLeftNum = ThreadLocalRandom.current().nextInt(0, farLeftList.size());
			//set the randomly generated article to a variable
			farLeftArticle = farLeftList.get(farLeftNum);
		}
		
		//if the leftList has at least one article in it
		if (leftList.size()>0) {
			//generate a random article from the list
			int leftNum = ThreadLocalRandom.current().nextInt(0, leftList.size());
			//set the randomly generated article to a variable
			leftArticle = leftList.get(leftNum);
		}
		
		//if the centerList has at least one article in it
		if (centerList.size()>0) {
			//generate a random article from the list
			int centerNum = ThreadLocalRandom.current().nextInt(0, centerList.size());
			//set the randomly generated article to a variable
			centerArticle = centerList.get(centerNum);
		}


		//if the rightList has at least one article in it
		if (rightList.size() > 0) {
			//generate a random article from the list
			int rightNum= ThreadLocalRandom.current().nextInt(0, rightList.size());
			//set the randomly generated article to a variable
			rightArticle = rightList.get(rightNum);
		}
			
		//if the rightList has at least one article in it
		if (farRightList.size() > 0) {
			//generate a random article from the list
			int farRightNum = ThreadLocalRandom.current().nextInt(0, farRightList.size());
			//set the randomly generated article to a variable
			farRightArticle = farRightList.get(farRightNum);
		}
		
		
		//if there are "matches" in each weight
		if (farLeftArticle != null && leftArticle != null && centerArticle != null && rightArticle != null && farRightArticle != null) {
			
			//add each randomly generated article to the combinedList
			combinedList.add(farLeftArticle);
			combinedList.add(leftArticle);
			combinedList.add(centerArticle);
			combinedList.add(rightArticle);
			combinedList.add(farRightArticle);
			
			//set size equal to the size of the combinedList
			size = combinedList.size();
		
			//send the combinedList and size to the outputArticles method
			outputArticles(combinedList, size);
			
		}
		
		//if there is a "match" on the left, center, or right, but no match in the far Left or farRigh
		if (leftArticle != null && centerArticle != null && rightArticle != null && (farLeftArticle == null || farRightArticle == null)) {
			
			//add the randomly generated articles from the left, center, and right
			combinedList.add(leftArticle);
			combinedList.add(centerArticle);
			combinedList.add(rightArticle);
			
			//size is equal to the size of the combinedList
			size = combinedList.size();
			
			//send the combinedList and size to the outputArticles method
			outputArticles(combinedList, size);
		}
		
		//if there is a "match" on the farLeft, center, and farRight, but no match in the left or right
		if (farLeftArticle != null && centerArticle != null && farRightArticle != null && (leftArticle == null || rightArticle == null)) {
			
			//add the randomly generated articles from the left, center amd right
			combinedList.add(farLeftArticle);
			combinedList.add(centerArticle);
			combinedList.add(farRightArticle);
			
			//size is equal to the size of the combinedList
			size = combinedList.size();
			
			//send the combinedList and size to the outputArticles method
			outputArticles(combinedList, size);
		}
		
		//if there is a match in the center, but no match in the farLeft, left, right, farRight
		if (centerArticle != null && (farLeftArticle == null || farRightArticle == null) &&(rightArticle != null || leftArticle == null)) {
			
			//add just the randomly generated center article to the combined list
			combinedList.add(centerArticle);
			
			//size is equal to the size of the combinedList
			size = combinedList.size();
			
			//send the combinedList and size to the outputArticles method
			outputArticles(combinedList, size);
		}
				
	}
		
	//output articles method displays the Articles to the user
	//takes in the combined list and the int size
	public void outputArticles(List<Article> combinedList, int size) {
		
		//randomize the combinedList
		Collections.shuffle(combinedList);
		
		//Alert the user the articles are "loading"
		System.out.println ("Loading " + combinedList.size() + " aricle(s) for you to read. \nThis is a non-biased selection.");
    	
		try
        {
			//set the thread to sleep to slow execution for better user experience (so content does generate so fast)
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    	
		//for loop traverses each article in the combined list
		for (Article art: combinedList) {
			
			//for each article that is not the last in the list
			if (art != combinedList.get(combinedList.size()-1)) {
				
				//Wrap the string so the article body is not printed on one line
				@SuppressWarnings("deprecation")
				String wrappedContent = WordUtils.wrap(art.getContent(),150);
				
				//print the article body
				System.out.println(wrappedContent);
				
				//ask the user if they would like to view the source or move to the next article
				System.out.println("\nLooks like you finished reading. If you haven't, scroll back up for the article. Press 1 to reveal the source & the next article. Press 2 for just the next article. When the next article loads, your screen is positioned at the bottom of the article. Scroll up to start from the begining and to see the source (if requested).");
					int nextStep = scanner.nextInt();
					
					//if the user chooses to view the source
					if (nextStep == 1) {
						//print the author, title, source, and its URL
						System.out.println("Author: " + art.getAuthor() + " Headline: " + art.getTitle() + " Source: "+ art.getSource() + " URL: "+ art.getURL());
						try
				        {
							//set the thread to sleep to slow execution to give the user time to read the source
				            Thread.sleep(4000);
				        }
				        catch(InterruptedException ex)
				        {
				            Thread.currentThread().interrupt();
				        }
					
						//prepare the user the next article is coming
						System.out.print("Your next article is loading\n\n");
						
						try
				        {
							//set the thread to sleep to slow execution for better user experience (so content does generate so fast)
				            Thread.sleep(3000);
				        }
				        catch(InterruptedException ex)
				        {
				            Thread.currentThread().interrupt();
				        }
						//Tell the user the next article is below
						System.out.println("Here's the next article\n\n");
					}
			}	
			//if the article is last in the array List
			else {	
				
				//wrap the content so it doesn't print on one long string
				@SuppressWarnings("deprecation")
				String wrappedContent = WordUtils.wrap(art.getContent(),150);
				
				//print the article content
				System.out.println(wrappedContent);
				
				//ask the user if they would like to view the article's source
				System.out.println("\nLooks like you finished reading. Press 1 to reveal the source.");
				int nextStep = scanner.nextInt();
			
				//if they choose to view the source, print the author, source, and URL
				if (nextStep == 1) {
					System.out.println("Author: " + art.getAuthor() + " Headline: " + art.getTitle()+ " Source: "+ art.getSource() + " URL: "+ art.getURL());
				}
			}
	
		}
	}
	

}