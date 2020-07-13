This program is designed to identify and neutralize the effects of bias in the news. Users can search a term of their choosing, and the program will return to them an unbiased selection of articles containing the term. 

Currently, the program pulls from a dataset of articles. Each article within the database is labeled with seven characteristics: Database ID, Title, Author, Source, Weight, URL, and Content. Articles were assigned a Database ID in the order they were collected. This ID is an arbitrary number used to conveniently identify articles and is not a measure of bias. Weights were assigned to articles based on the source’s position in Figure 1. Articles from sources in the Far Left category were assigned a weight of -2, articles from sources in the Left category were assigned a weight of -1, articles from sources in the Center category were assigned a weight of 0, articles from the Right category were assigned a weight of 1, and articles from the Far Right category were assigned a weight of 2.  Whether an article is assigned a positive or negative number is not indicative of the article’s accuracy or any personal views on the source.

The News Aggregator Prototype,begins by asking the user for a term to search within the database. The user can search any term based on their topic preferences. The user is then presented with two options: 

Enter 1 to search for the requested term in the title
    
By selecting this option the News Aggregator will search for the entered term within each article stored in the database. The program will collect all results, even articles with headlines in which the search term is embedded within a larger word. For example, if the user searches the term ‘Corona,’ headlines with the term ‘Coronavirus’ will be collected, as it contains the requested inner term. 

Enter 2 to search for the requested term in the article body

If the user selects this option, the News Aggregator will search for the entered term within the entire article body. Similar to the first option, the program will collect all articles that contain the term on its own or the term embedded within a larger word or phrase. 
Once collected, the articles containing the search term are grouped by their weight and presented to the user so the total sum of weights is zero. In order to prevent information overload, which, according to Holton & Chyi (2012), “occurs when the amount of available content becomes difficult for an individual to process, often causing negative feelings on the end of the customer,” the user is presented with a maximum of five articles at a time. Depending on the chosen search term, one of the following scenarios will occur:

  A) A search term results in at least one matching article from each political affiliation.In this scenario, the user will be presented with five articles, one from each affiliation. 
  B) A search term does not result in at least one matching article in the Far Left and/or Far Right categories.In each of these three scenarios, the user will be presented with three articles, one from each the Left, Center, and Right. 
  C) A search term does not result in at least one matching article in the Left and/or Right categories. In each of these three scenarios, the user will be presented with three articles, one from each the Far Left, Center, and Far Right. 
  D) A search term does not result in at least one matching article in the Left and/or Right categories, and the search term does not result in at least one matching article in the Far Left and/or Far Right categories. In any of these five scenarios, the user will only be presented with a single article from the center category. 
  
  In each of these scenarios, if a term matches with more than one article within a single affiliation, an article will be chosen at random from all matching articles to be displayed.
	Alternatively a search term does not result in any matches, the user is notified and the program terminates. The program also terminates in any situations where results do not include a result in the center category. This is a design choice intended to ensure a user is not only presented with extreme positions. However, this could be modified in future versions.



