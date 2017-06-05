#!/bin/bash

echo "------- shell gethadoop -------"

rm -rf /usr/local/hadoop
sudo mv /home/vagrant/hadoop-2.6.4.tar.gz /usr/local/
cd /usr/local/
tar -xzf hadoop-2.6.4.tar.gz
mv hadoop-2.6.4 hadoop
chown vagrant:vagrant -R /usr/local/hadoop

mv /home/vagrant/etc/* /usr/local/hadoop/etc/hadoop/
