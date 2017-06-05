#!/bin/bash

vagrant up 

vagrant ssh hadoop-master -c " /usr/local/hadoop/bin/hdfs namenode -format"
vagrant ssh hadoop-master -c " /usr/local/hadoop/sbin/start-dfs.sh"
vagrant ssh hadoop-master -c " /usr/local/hadoop/sbin/start-yarn.sh"
vagrant ssh hadoop-master -c " /usr/local/hadoop/bin/hdfs dfs -mkdir -p /user/vagrant/input"
vagrant ssh hadoop-master -c " dsh -M -g cluster 'jps'"
vagrant ssh hadoop-master -c "sudo useradd -G supergroup,vagrant LUK"


#hdfs dfs -put /usr/local/aaa.txt input
#sudo useradd -G supergroup,vagrant LUK