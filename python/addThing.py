#!/usr/bin/python3
import sys
import random
import string

import requests
from requests.auth import HTTPBasicAuth

url = "http://th1ngs.com/rest/api/1/thing";

#myobj = {'boxId': '1', 'thingTypeId': 1, 'summary': 'EOOO' };
#response = requests.post(url, auth=HTTPBasicAuth('bruno', 't0ledo'), json = myobj)
#print(str(response.status_code) + " "+ response.text)

print(f"Arguments count: {len(sys.argv)}");
for i, arg in enumerate(sys.argv):
        print(f"Argument {i:>6}: {arg}")
        
if sys.argv and sys.argv[1]=='place':
	myobj = {'boxKey': 'GUIDE', 'thingTypeId': 9, \
		'summary': ''+sys.argv[2] };
	response = requests.post(url, auth=HTTPBasicAuth('bruno', 't0ledo'), json = myobj)
	print("ADD THING: "+ str(response.status_code) + " "+ str(response.ok));


print('# DONE');
