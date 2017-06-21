FROM tomcat:latest
MAINTAINER Mo Nuaimat "nuaimat2002@yahoo.com"

COPY wait_mysql.sh /root/wait_mysql.sh
RUN  apt-get update && \
     apt-get -y install mysql-client
RUN chmod +x /root/wait_mysql.sh && \
    /bin/bash /root/wait_mysql.sh
COPY auctions.war /usr/local/tomcat/webapps/auctions.war

