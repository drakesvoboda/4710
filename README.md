# 4710

## Contributors:

Drake Svoboda | fv9838@wayne.edu | fv9838

John Gettel   | gd3148@wayne.edu | gd3148

## Setup:

Step 1. Import project from war into Eclipse Luna

Step 1.1 Ensure JRE version is 1.8

Step 2. Configure a Tomcat 7 server in Eclipse

Step 2.2 Ensure Tomcat 7 library is on the projects build path

Step 3. Run the \WebContent\jsps\main.jsp file on the Tomcat server

Step 4. From the window menu, select web browser and then select "default system web browser"
	(preferably Google Chrome)

## Using the database

Part 1 requirements:

Initialize the database by clicking the "Initialize Database" button. This deletes
all tables in the database - if they exist. It then creates the tables and populates them.

To assign reviewers to a paper, select "View Papers" and then select a paper in the database.
If a paper has no reviewers you may select three reviewers from the list of available reviewers 
and then assign them to that paper by clicking "update".

Part 2 requirements:

1. To delete or update a paper: navigate to "Main Page" and click "View Papers". Select a paper
from the list. Update the desired fields and click "Update" or click delete to delete the paper
completely.
To add a paper: navigate to "Main Page" and click "View Papers". Click "+ Create a paper" and 
fill in the required fields and click "Update". Once the paper has been created select it from
the list of papers and add any authors. Adjust the order of the authors with the up and down
arrows next to the selected author's name. Then add reviewers to the paper. Click "update" when done.

2. To delete or update a pc member: navigate to "Main Page" and click "View PC Members". Select a 
pc member from the list. Update the desired fields and click "Update" or click delete to delete the 
pc member completely.
To add a pc member: navigate to "Main Page" and click "View PC Members". Click "+ Create a pc member" and 
fill in the required fields and click "Update".

3. To update a review: navigate to "Main Page" and click "View Reviews". Select a 
review from the list. Update the desired fields and click "Update". The submitted date automatically updates when a review is updated. 
To delete a review: navigate to "Main Page" and click "View Reviews". Select a new pc member to review 
the paper and then click "delete" to delete the review. 
To insert a review: navigate to "Main Page" and click "View Papers" and then select the desired paper.
Select three reviewers from the list of available reviewers and then assign them to that paper by clicking "update".

4. To list all papers written by a single author with a given name: navigate to "Main Page" and click "View Papers". Select the author's name from the drop down menu, select "Single Author" and click "Go. 

5. To list all papers with a given author as the first author: navigate to "Main Page" and click "View Papers". Select the author's name from the drop down menu, select "First Author" and click "Go. 

6. To list all papers coauthored by two given authors: navigate to "Main Page" and click "View Papers". Select the names from the drop down menu, select "Multiple Authors" and click "Go. 

7. To view the pc members with the most reviews: navigate to "Main Page" and click "View PC Members". The names
of the pc members are listed at the top of the page.

8. To view the pc members with no reviews: navigate to "Main Page" and click "View PC Members". The names
of the pc members are listed at the bottom of the page.

9. To list the papers rejected by two given pc members: navigate to "Main Page" and click "View PC Members".
At the top of the page select the desired pc members and click "Go".

10. To view the recommended papers: navigate to "Main Page" and click "View Papers". The recommended papers
are listed at the bottom of the page.
