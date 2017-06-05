#!/bin/bash

echo "------- shell get tomcat -------"

rm -rf /usr/local/tomcat     # usuwa istniejacego tomcata
sudo mv /home/vagrant/apache-tomcat-7.0.72.tar.gz /usr/local/     # przenosi paczke z tomcatem do folderu /usr/local/ 
cd /usr/local/
tar -xzf apache-tomcat-7.0.72.tar.gz    # rozpakowuje tomcata
mv apache-tomcat-7.0.72 tomcat    # zmiana nazwy na tomcat
chown vagrant:vagrant -R /usr/local/tomcat   #zmiana wlasciciela i grupy na vagrant, -R zmiana dla plikow i podkatalogow

cd /home/vagrant/

echo '
export TOMCAT_HOME=/usr/local/tomcat
export PATH=$PATH:$TOMCAT_HOME/bin' >> /home/vagrant/.bashrc

echo "------- running tomcat -------"

cd /usr/local/tomcat/bin
sudo ./startup.sh    #uruchomienie tomcat
