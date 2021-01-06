rm -r /home/ubuntu/tomcat/book/target/
rm -r /home/ubuntu/tomcat/temp/*
rm /home/ubuntu/tomcat/webapps/book.war
mvn package -f "/home/ubuntu/tomcat/book/pom.xml"
chmod +x /home/ubuntu/tomcat/book/target/book.war
cp /home/ubuntu/tomcat/book/target/book.war /home/ubuntu/tomcat/webapps/