import requests
import urllib
import os
from bs4 import BeautifulSoup


url = input("Insert the URL of the Website you wanna scan")
response = requests.get(url)

found_images = []
if response.status_code == 200:
    
    doc = BeautifulSoup(response.text, "html.parser")
    
    images = doc.find_all("img")
    
    for img in images:
        path = urllib.parse.urljoin(url, img.attrs["src"])
        found_images.append(path)

if not os.path.exists("./images"):
    os.mkdir("./images")


for found_image in found_images: 
    filename = found_image.split("/")[-1]
    
    response = requests.get(found_image)
    with open("./images/" + filename, "wb") as file:
        file.write(response.content)
