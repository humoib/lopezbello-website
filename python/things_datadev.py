#!/usr/bin/python3

import random
import string

import requests
from requests.auth import HTTPBasicAuth

response = requests.get("http://localhost:8888/rest/api/1/thing", auth=HTTPBasicAuth('bruno', 't0ledo'))
print(str(response.status_code) + " "+ str(response.ok))

#response = requests.post("http://localhost:8888/rest/api/1/thing", auth=HTTPBasicAuth('bruno', 't0ledo'))

url = "http://localhost:8888/rest/api/1/thing";

#myobj = {'boxId': '1', 'thingTypeId': 1, 'summary': 'EOOO' };
#response = requests.post(url, auth=HTTPBasicAuth('bruno', 't0ledo'), json = myobj)
#print(str(response.status_code) + " "+ response.text)


for x in range(1, 10):
	myobj = {'boxKey': 'SCRUM', 'thingTypeId': 3, 'summary': ''.join(random.sample(string.ascii_letters, 15)), \
	 'analysis': ''.join(random.sample(string.ascii_letters, 15)),
	 'Text': ''.join(random.sample(string.ascii_letters, 15)),
	 'Text large': ''.join(random.sample(string.ascii_letters, 15)),
	 'Select': 'zzz',
	 'Radio': '1',
	 'campo1': 'campo1 value',
	 'campo2': 'campo2 value' }
	response = requests.post(url, auth=HTTPBasicAuth('bruno', 't0ledo'), json = myobj)
	print("ADD THING: "+ str(response.status_code) + " "+ str(response.ok));

print('# DONE');
