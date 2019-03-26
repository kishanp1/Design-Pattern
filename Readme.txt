Observer Pattern using BST tree.

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=/import/linux/home1/kpatel51/cs542/kishankumar_patel_assign_2/studentCoursesBackup/input.txt -Darg1=/import/linux/home1/kpatel51/cs542/kishankumar_patel_assign_2/studentCoursesBackup/delete.txt -Darg2=/import/linux/home1/kpatel51/cs542/kishankumar_patel_assign_2/studentCoursesBackup/output1.txt -Darg3=/import/linux/home1/kpatel51/cs542/kishankumar_patel_assign_2/studentCoursesBackup/output2.txt -Darg4=/import/linux/home1/kpatel51/cs542/kishankumar_patel_assign_2/studentCoursesBackup/output3.txt

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

[Date: 10/03/2017]

-----------------------------------------------------------------------

I have used BST for this project, as other than easy understanding of
BST, with large number of node N, it gives consistent logN time 
complexity for search and insert.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

For learning and clarifying BST concept I have refered this youtube 
video: https://www.youtube.com/watch?v=M6lYob8STMI

