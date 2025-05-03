#!/bin/sh

set -a
. /opt/cers/.env
set +a

export PATH=/opt/java/openjdk/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin

cd /opt/cers && java -jar "$(find . -maxdepth 1 -type f -name "*.jar" | head -n 1)" >> /var/log/cers/"$(date +%Y-%m-%d)".log 2>&1