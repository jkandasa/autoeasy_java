#****************************************************************
#Author: Jeeva Kandasamy (jkandasa@redhat.com)
#Date: 13, Oct 2013
#****************************************************************
#!/bin/bash

JVM_MIN_MAX_SIZE="-Xms4m -Xmx64m"

java $JVM_MIN_MAX_SIZE  -cp .:../lib/*:../resources/user-libs/* com.autoeasy.base.AutoEasyMain