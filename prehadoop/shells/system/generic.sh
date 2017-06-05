#!/bin/bash

echo "------- shell generic -------"

find /home/vagrant -type f -print0 | xargs -0 dos2unix 2> /dev/null

mv /home/vagrant/system/bashrc /home/vagrant/.bashrc
mv /home/vagrant/system/hosts /etc/hosts
mv /home/vagrant/system/config /home/vagrant/.ssh/config
mv /home/vagrant/system/cluster /etc/dsh/group/cluster
mv /home/vagrant/system/slaves /etc/dsh/group/slaves

groupadd supergroup
