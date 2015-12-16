- This exercise reads the data from Parablog (https://www.parashift.com.au/2015/10/27/real-time-collaboration-in-alfresco/) and counts the occurrence of each word. From the result it generates a word cloud and the word with higher counts have larger font size then the one has less counts. 

- The project ignores few small words like "be", "a", "that", "", "in", "or", "to", "on", "an", "of", "as", "this", "it", "be", "the", "and", "is", and "for".

- The project uses Jsoup to parse the HTML to data.

- JQclouds is the library which the project uses to print the word cloud.

- The project has been deployed on AWS Elastic beanstalk and can be accessed at http://parashift-project.elasticbeanstalk.com/ 

-This project uses Tomcat server on Elastic beanstalk

References:
- https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Code-Style
- http://crunchify.com/how-to-create-a-war-file-from-eclipse-using-maven-plugin-apache-maven-war-plugin-usage/
- http://crunchify.com/simplest-spring-mvc-hello-world-example-tutorial-spring-model-view-controller-tips/
-http://crunchify.com/java-how-to-find-maximum-occurrence-of-words-from-text-file/