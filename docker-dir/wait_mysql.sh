#!/bin/bash

OUTPUT="";
while [ `echo $OUTPUT | grep -c somestring` = 0 ]; do
  OUTPUT=`mysql -u root -p'root' -h database -e "show databases" | grep "auctions"`;
  sleep 2
  echo "Waiting for mysql .."
done